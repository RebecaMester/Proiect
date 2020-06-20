package Bibliotecar.ui.AddStudent;

import Bibliotecar.ui.dbUtil.dbConnection2;
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

public class StudentController
  implements Initializable
{
  @FXML
  private TextField id;
  @FXML
  private TextField firstname;
  @FXML
  private TextField lastname;
  @FXML
  private TextField email;
  @FXML
  private TextField adresa;
  @FXML
  private TextField telefon;
  @FXML
  private TableView<StudentData> studenttable;
  @FXML
  private TableColumn<StudentData, String> idcolumn;
  @FXML
  private TableColumn<StudentData, String> firstnamecolumn;
  @FXML
  private TableColumn<StudentData, String> lastnamecolumn;
  @FXML
  private TableColumn<StudentData, String> emailcolumn;
  @FXML
  private TableColumn<StudentData, String> adresacolumn;
  @FXML
  private TableColumn<StudentData, String> telefoncolumn;
  @FXML
  private Button loadbutton;
  private ObservableList<StudentData> data;
  private dbConnection2 dc;


  public void initialize(URL url, ResourceBundle rb)
  {
    this.dc = new dbConnection2();
  }
  
  @FXML
  private void loadStudentData(ActionEvent event)
  {
    try
    {
      Connection conn = dbConnection2.getConnection();
      this.data = FXCollections.observableArrayList();
      
      ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
      while (rs.next()) {
        this.data.add(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
      }
    }
    catch (SQLException e)
    {
      System.err.println("Error " + e);
    }
    this.idcolumn.setCellValueFactory(new PropertyValueFactory("ID"));
    this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory("firstName"));
    this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory("lastName"));
    this.emailcolumn.setCellValueFactory(new PropertyValueFactory("email"));
    this.adresacolumn.setCellValueFactory(new PropertyValueFactory("adresa"));
    this.telefoncolumn.setCellValueFactory(new PropertyValueFactory("telefon"));
    
    this.studenttable.setItems(null);
    this.studenttable.setItems(this.data);
  }

  @FXML
  private void addStudent(ActionEvent event)
  {
    String sql = "INSERT INTO students (id, fname, lname, email, adresa, telefon) VALUES (? , ?, ?, ?, ?, ?)";
    try
    {
      Connection conn = dbConnection2.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, this.id.getText());
      stmt.setString(2, this.firstname.getText());
      stmt.setString(3, this.lastname.getText());
      stmt.setString(4, this.email.getText());
      stmt.setString(5, this.adresa.getText());
      stmt.setString(6, this.telefon.getText());
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
    this.firstname.setText("");
    this.lastname.setText("");
    this.email.setText("");
    this.adresa.setText("");
    this.telefon.setText("");
  }
}
