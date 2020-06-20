package Bibliotecar.ui.main;

import Bibliotecar.ui.util.LibrarianUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Bibliotecar.ui.util.LibrarianUtil;

public class MainController implements Initializable{

    private static final String BOOK_NOT_AVAILABLE = "Indisponibila";
    private static final String NO_SUCH_BOOK_AVAILABLE = "No Such Book Available";
    private static final String NO_SUCH_MEMBER_AVAILABLE = "No Such Member Available";
    private static final String BOOK_AVAILABLE = "Disponibila";

    private Boolean isReadyForSubmission = false;
    private PieChart bookChart;
    private PieChart memberChart;

    @FXML
    private HBox book_info;
    @FXML
    private HBox member_info;
    @FXML
    private TextField bookIDInput;
    @FXML
    private Text bookName;
    @FXML
    private Text bookAuthor;
    @FXML
    private Text bookStatus;
    @FXML
    private TextField memberIDInput;
    @FXML
    private Text memberName;
    @FXML
    private Text memberMobile;
    @FXML
    private JFXTextField bookID;
    @FXML
    private StackPane rootPane;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private Text memberNameHolder;
    @FXML
    private Text memberEmailHolder;
    @FXML
    private Text memberContactHolder;
    @FXML
    private Text bookNameHolder;
    @FXML
    private Text bookAuthorHolder;
    @FXML
    private Text bookPublisherHolder;
    @FXML
    private Text issueDateHolder;
    @FXML
    private Text numberDaysHolder;
    @FXML
    private Text fineInfoHolder;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private JFXButton renewButton;
    @FXML
    private JFXButton submissionButton;
    @FXML
    private HBox submissionDataContainer;
    @FXML
    private StackPane bookInfoContainer;
    @FXML
    private StackPane memberInfoContainer;
    @FXML
    private Tab bookIssueTab;
    @FXML
    private Tab renewTab;
    @FXML
    private JFXTabPane mainTabPane;
    @FXML
    private JFXButton btnIssue;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initComponents();
    }

    void clearBookCache() {
        bookName.setText("");
        bookAuthor.setText("");
        bookStatus.setText("");
    }

    void clearMemberCache() {
        memberName.setText("");
        memberMobile.setText("");
    }


    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    @FXML
    private void handleMenuClose(ActionEvent event) {
        getStage().close();
    }

    @FXML
    private void handleMenuAddBook(ActionEvent event) {
        LibrarianUtil.loadWindow(getClass().getResource("/AddBook/Book.fxml"), "Adauga carte", null);
    }

    @FXML
    private void handleMenuAddMember(ActionEvent event) {
        LibrarianUtil.loadWindow(getClass().getResource("/AddStudent/Student.fxml"), "Adauga studenti", null);
    }

    @FXML
    private void handleMenuViewBook(ActionEvent event) {
        LibrarianUtil.loadWindow(getClass().getResource("/ViewBooks/Book.fxml"), "Lista carti", null);
    }


    @FXML
    private void handleMenuViewMemberList(ActionEvent event) {
        LibrarianUtil.loadWindow(getClass().getResource("/ViewStudents/Student.fxml"), "Lista studenti", null);
    }

    @FXML
    private void handleMenuFullScreen(ActionEvent event) {
        Stage stage = getStage();
        stage.setFullScreen(!stage.isFullScreen());
    }

    private void clearEntries() {
        memberNameHolder.setText("");
        memberEmailHolder.setText("");
        memberContactHolder.setText("");

        bookNameHolder.setText("");
        bookAuthorHolder.setText("");
        bookPublisherHolder.setText("");

        issueDateHolder.setText("");
        numberDaysHolder.setText("");
        fineInfoHolder.setText("");

        disableEnableControls(false);
        submissionDataContainer.setOpacity(0);
    }

    private void disableEnableControls(Boolean enableFlag) {
        if (enableFlag) {
            renewButton.setDisable(false);
            submissionButton.setDisable(false);
        } else {
            renewButton.setDisable(true);
            submissionButton.setDisable(true);
        }
    }

    private void clearIssueEntries() {
        bookIDInput.clear();
        memberIDInput.clear();
        bookName.setText("");
        bookAuthor.setText("");
        bookStatus.setText("");
        memberMobile.setText("");
        memberName.setText("");
        enableDisableGraph(true);
    }

    private void initGraphs() {
        /*bookChart = new PieChart(databaseHandler.getBookGraphStatistics());
        memberChart = new PieChart(databaseHandler.getMemberGraphStatistics());
        bookInfoContainer.getChildren().add(bookChart);
        memberInfoContainer.getChildren().add(memberChart);
        bookChart.setLabelLineLength(10);
        bookChart.setLegendSide(Side.RIGHT);
        memberChart.setLabelLineLength(10);
        memberChart.setLegendSide(Side.RIGHT);
        bookIssueTab.setOnSelectionChanged((Event event) -> {
            clearIssueEntries();
            if (bookIssueTab.isSelected()) {
                refreshGraphs();
            }
        });*/
    }

    private void refreshGraphs() {
        /*bookChart.setData(databaseHandler.getBookGraphStatistics());
        memberChart.setData(databaseHandler.getMemberGraphStatistics());*/
    }

    private void enableDisableGraph(Boolean status) {
        if (status) {
            bookChart.setOpacity(1);
            memberChart.setOpacity(1);
        } else {
            bookChart.setOpacity(0);
            memberChart.setOpacity(0);
        }
    }

    private boolean checkForIssueValidity() {
        bookIDInput.fireEvent(new ActionEvent());
        memberIDInput.fireEvent(new ActionEvent());
        return bookIDInput.getText().isEmpty() || memberIDInput.getText().isEmpty()
                || memberName.getText().isEmpty() || bookName.getText().isEmpty()
                || bookName.getText().equals(NO_SUCH_BOOK_AVAILABLE) || memberName.getText().equals(NO_SUCH_MEMBER_AVAILABLE);
    }



    @FXML
    private void handleIssueButtonKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }

    private void initComponents() {
        mainTabPane.tabMinWidthProperty().bind(rootAnchorPane.widthProperty().divide(mainTabPane.getTabs().size()).subtract(15));
    }


    public void handleMenuDeleteBook(ActionEvent actionEvent) {
        LibrarianUtil.loadWindow(getClass().getResource("/DeleteBook/Book.fxml"), "Sterge carte", null);
    }

    public void handleMenuEditBook(ActionEvent actionEvent) {
        LibrarianUtil.loadWindow(getClass().getResource("/EditBook/Book.fxml"), "Editeaza carte", null);
    }
}
