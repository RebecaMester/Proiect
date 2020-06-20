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

public class Login1stController {

    public JFXPasswordField password;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField otp;
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
        JSONArray list = readFromFiles("src/main/resources/Databases/OTP.json");
        ArrayList<LibrarianData> bibliotecari = new ArrayList<LibrarianData>();
        Iterator<JSONObject> it = list.iterator();
        while (it.hasNext()) {
            JSONObject obj = it.next();
            String objInt = (String) obj.get("Username");
            String objInt2 = (String) obj.get("OTP");

            LibrarianData s = new LibrarianData(objInt, objInt2);
            bibliotecari.add(s);
        }
        return bibliotecari;
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) {
        String uname = username.getText();
        String OTP = otp.getText();
        String pass = password.getText();
        ArrayList<LibrarianData> studenti= getDriver();
        Iterator<LibrarianData> it=studenti.iterator();
        while(it.hasNext())
        {
            LibrarianData s=it.next();
            if(s.getEmail().equals(uname) && s.getPass().equals(OTP))
            {
                JSONObject obj = new JSONObject();
                JSONArray jrr = new JSONArray();
                JSONParser jp = new JSONParser();
                try{
                    FileReader file = new FileReader("LibrarianLogin.json");
                    jrr=(JSONArray)jp.parse(file);
                }catch(Exception ex){

                }

                obj.put("Username", uname);
                obj.put("Password", DigestUtils.shaHex(pass));
                jrr.add(obj);
                try{
                    FileWriter file = new FileWriter("LibrarianLogin.json");
                    file.write(jrr.toJSONString());
                    file.close();
                }catch(Exception ex){
                }
                closeStage();
                loadLogin();
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

    void loadLogin() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/LoginBibliotecar/login.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Bibliotecar");
            stage.setScene(new Scene(parent));
            stage.show();

        }
        catch (IOException ex) {

        }
    }

}