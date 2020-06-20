package Admin.ui.LibraryCard;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class CardController implements Initializable {
    @FXML
    private JFXTextField username2;
    @FXML
    private JFXTextField ID;
    @FXML
    private JFXTextField username;


    public void handleLoginButtonAction(ActionEvent actionEvent) throws InterruptedException {
    }

    public void handleCancelButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
