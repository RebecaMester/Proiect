package Bibliotecar.ui.EditBook;

import Bibliotecar.ui.dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.*;
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
    PreparedStatement pst;
    Connection conn;
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
        this.yearcolumn.setCellValueFactory(new PropertyValueFactory("an"));
        this.subjectcolumn.setCellValueFactory(new PropertyValueFactory("subiect"));
        this.editioncolumn.setCellValueFactory(new PropertyValueFactory("editie"));
        this.pagescolumn.setCellValueFactory(new PropertyValueFactory("pag"));
        this.copiescolumn.setCellValueFactory(new PropertyValueFactory("exemplare"));
        this.shelfcolumn.setCellValueFactory(new PropertyValueFactory("raft"));
        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }

    private Connection connect() {
        // SQLite connection string
        Statement st = null;
        String url = "jdbc:sqlite:src/main/resources/AddBook/books.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void refresh()
    {
        this.dc = new dbConnection();
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM carti");
            while (rs.next()) {
                this.data.add(new Bibliotecar.ui.EditBook.BookData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException e) {
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
    private void EditBook(ActionEvent event) throws InterruptedException {
        /*Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection ("jdbc:sqlite:books.sqlite"); //run procedure getConnection to connect to the database - see below
            st = conn.createStatement(); //set up a statement st to enable you to send SQL statements to the database.
        } catch (SQLException ex) {
        }*/
        String query = ("UPDATE carti SET titlu=?,autor=?,an=?,subiect=?,editie=?,pagini=?,exemplare=?,raft=? WHERE id=?");
        try
        {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, this.titlu.getText());
            stmt.setString(2, this.autor.getText());
            stmt.setString(3, this.an.getText());
            stmt.setString(4, this.subiect.getText());
            stmt.setString(5, this.editie.getText());
            stmt.setString(6, this.pag.getText());
            stmt.setString(7, this.exemplare.getText());
            stmt.setString(8, this.raft.getText());
            stmt.setString(9, this.id.getText());
            stmt.execute();
            conn.close();
        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
       refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Editare cu succes");
        String s ="Cartea a fost editata cu succes! ";
        alert.setContentText(s);
        alert.show();
        TimeUnit.SECONDS.sleep(1);
        alert.close();
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
