package Bibliotecar.ui.AddBook;

import Bibliotecar.ui.dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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

    @FXML
    private void addBook(ActionEvent event) throws InterruptedException {
        String sql = "INSERT INTO carti (id, titlu, autor, an, subiect, editie, pagini, exemplare, raft) VALUES (? , ?, ?, ?, ?, ?, ? ,? , ?)";
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.titlu.getText());
            stmt.setString(3, this.autor.getText());
            stmt.setString(4, this.an.getText());
            stmt.setString(5, this.subiect.getText());
            stmt.setString(6, this.editie.getText());
            stmt.setString(7, this.pag.getText());
            stmt.setString(8, this.exemplare.getText());
            stmt.setString(9, this.raft.getText());

            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

    }

    @FXML
    private void clearFields(ActionEvent event)
    {
        this.id.setText("");
        this.titlu.setText("");
        this.autor.setText("");
        this.an.setText("");
        this.subiect.setText("");
        this.exemplare.setText("");
        this.editie.setText("");
        this.pag.setText("");
        this.raft.setText("");
    }
}
