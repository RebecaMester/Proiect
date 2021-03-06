package Bibliotecar.ui.Login;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Admin.ui.OTP.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class LoginController1 {
        @FXML
        private JFXPasswordField password;
        @FXML
        private JFXTextField username;
        public static JSONArray readFromFiles(String fileName){
            org.json.simple.parser.JSONParser parser=new JSONParser();
            JSONArray list=new JSONArray();
            try{
                Reader reader=new FileReader(fileName);
                list=(JSONArray)parser.parse(reader);
            }catch(IOException e){
                e.printStackTrace();
            }catch(ParseException e){
                e.printStackTrace();
            }
            return list;
        }

        public static ArrayList<LibrarianData> getDriver() {
            JSONArray list = readFromFiles("LibrarianLogin.json");
            ArrayList<LibrarianData> bibliotecari = new ArrayList<LibrarianData>();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                String objInt = (String) obj.get("Username");
                String objInt2 = (String) obj.get("Password");

                LibrarianData s = new LibrarianData(objInt, objInt2);
                bibliotecari.add(s);
            }
            return bibliotecari;
        }

        public void handleLoginButtonAction(ActionEvent actionEvent) {
            String uname = username.getText();
            String pass = password.getText();
            ArrayList<LibrarianData> studenti= getDriver();
            Iterator<LibrarianData> it=studenti.iterator();
            while(it.hasNext())
            {
                LibrarianData s=it.next();
                if(s.getEmail().equals(uname) && s.getPass().equals(DigestUtils.shaHex(pass)))
                {
                    closeStage();
                    loadMain();
                }
            }
        }

        @FXML
        private void handleCancelButtonAction(ActionEvent event) {
            System.exit(0);
        }

        private void closeStage() {
            ((Stage) username.getScene().getWindow()).close();
        }

        void loadMain() {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/LoginBibliotecar/main.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Bibliotecar");
                stage.setScene(new Scene(parent));
                stage.show();

            }
            catch (IOException ex) {

            }
        }

    public void handleRegisterButtonAction(ActionEvent actionEvent) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/LoginBibliotecar/login1st.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Bibliotecar");
            stage.setScene(new Scene(parent));
            stage.show();

        }
        catch (IOException ex) {

        }
    }
}
