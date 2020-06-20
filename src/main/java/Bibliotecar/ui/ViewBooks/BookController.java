package Bibliotecar.ui.ViewBooks;

import Bibliotecar.ui.dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookController implements Initializable
{

    @FXML
    private TextField id;
    @FXML
    private TextField titlu;
    @FXML
    private TextField autor;
    @FXML
    private TextField an;
    @FXML
    private TextField editie;
    @FXML
    private TextField subiect;
    @FXML
    private TextField pag;
    @FXML
    private TextField exemplare;
    @FXML
    private TextField raft;
    @FXML
    private TableView<BookData> studenttable;
    @FXML
    private TableColumn<BookData, String> idcolumn;
    @FXML
    private TableColumn<BookData, String> titlecolumn;
    @FXML
    private TableColumn<BookData, String> authorcolumn;
    @FXML
    private TableColumn<BookData, String> yearcolumn;
    @FXML
    private TableColumn<BookData, String> editioncolumn;
    @FXML
    private TableColumn<BookData, String> pagescolumn;
    @FXML
    private TableColumn<BookData, String> copiescolumn;
    @FXML
    private TableColumn<BookData, String> subjectcolumn;
    @FXML
    private TableColumn<BookData, String> shelfcolumn;


    @FXML
    private Button loadbutton;
    private ObservableList<BookData> data;
    private dbConnection dc;


    public void initialize(URL url, ResourceBundle rb)
    {
        this.dc = new dbConnection();
        try
        {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM carti");
            while (rs.next()) {
                this.data.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.titlecolumn.setCellValueFactory(new PropertyValueFactory("titlu"));
        this.authorcolumn.setCellValueFactory(new PropertyValueFactory("autor"));
        this.yearcolumn.setCellValueFactory(new PropertyValueFactory("editie"));
        this.subjectcolumn.setCellValueFactory(new PropertyValueFactory("an"));
        this.editioncolumn.setCellValueFactory(new PropertyValueFactory("raft"));
        this.pagescolumn.setCellValueFactory(new PropertyValueFactory("subiect"));
        this.copiescolumn.setCellValueFactory(new PropertyValueFactory("exemplare"));
        this.shelfcolumn.setCellValueFactory(new PropertyValueFactory("pagini"));
        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }

    @FXML
    private void loadBookData(ActionEvent event)
    {
        try
        {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM carti");
            while (rs.next()) {
                this.data.add(new BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error " + e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
        this.titlecolumn.setCellValueFactory(new PropertyValueFactory("titlu"));
        this.authorcolumn.setCellValueFactory(new PropertyValueFactory("autor"));
        this.yearcolumn.setCellValueFactory(new PropertyValueFactory("an"));
        this.subjectcolumn.setCellValueFactory(new PropertyValueFactory("subiect"));
        this.editioncolumn.setCellValueFactory(new PropertyValueFactory("editie"));
        this.pagescolumn.setCellValueFactory(new PropertyValueFactory("pag"));
        this.copiescolumn.setCellValueFactory(new PropertyValueFactory("exemplare"));
        this.shelfcolumn.setCellValueFactory(new PropertyValueFactory("raft"));
        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }
}
