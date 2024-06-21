package com.example.lab_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class HelloController implements Initializable {
    public TableView<tbl> Table;
    public TableColumn<tbl,Integer> ID;
    public TableColumn <tbl,String> Username;
    public TableColumn <tbl,String> College;
    public TableColumn <tbl,String> Password;
    public TextField nID;
    public TextField nUsername;
    public TextField nCollege;
    public TextField nPassword;


    @FXML
    private Label welcomeText;

    ObservableList<tbl> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fetchdata();
    }

    private void fetchdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/lab_2_nabin";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `tbl`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Username");
                String email = resultSet.getString("College");
                String password = resultSet.getString("Password");
                Table.getItems().add(new tbl(id, name, email, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<tbl,Integer>("ID"));
        Username.setCellValueFactory(new PropertyValueFactory<tbl,String>("Username"));
        College.setCellValueFactory(new PropertyValueFactory<tbl,String>("College"));
        Password.setCellValueFactory(new PropertyValueFactory<tbl,String>("Password"));
        Table.setItems(list);


    }





    public void Updatedata(ActionEvent actionEvent) {
        String id = nID.getText();
        String Username = nUsername.getText();
        String College = nCollege.getText();
        String password = nPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab_2_nabin";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `tbl` SET `Username`='"+Username+"',`College`='"+College+"',`Password`='"+password+"' WHERE ID='"+id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Deletedata(ActionEvent actionEvent) {
        String id = nID.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab_2_nabin";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `tbl` WHERE id='"+id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Insertdata(ActionEvent actionEvent) { String Username = nUsername.getText();
        String College = nCollege.getText();
        String Password = nPassword.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/lab_2_nabin";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {

            String query = "INSERT INTO `tbl`( `Username`, `College`, `Password`) VALUES ('"+Username+"','"+College+"','"+Password+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Loaddata(ActionEvent actionEvent) {
        String ID = nID.getText();
        String jdbcUrl = "jdbc:mysql://localhost:3306/lab_2_nabin";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `tbl` WHERE ID='"+ ID +"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {


                String Username = resultSet.getString("Username");
                String College = resultSet.getString("College");
                String Password = resultSet.getString("Password");

                nUsername.setText(Username);
                nCollege.setText(College);
                nPassword.setText(Password);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}