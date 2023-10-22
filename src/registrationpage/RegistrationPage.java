/*
145536- Olive Menorah
140164-Winnie Wanjugu
 */
package registrationpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text firstNumber = new Text("First Number");
        TextField fnumField = new TextField();
        Text surname = new Text("Surname");
        TextField surnameField = new TextField();
        Text email = new Text("Email");
        TextField emailField = new TextField();
        Text tel = new Text("Tel");
        TextField telField = new TextField();
        Text userName = new Text("UserName");
        TextField userNameField = new TextField();
        Text password = new Text("Password");
        PasswordField passwordField = new PasswordField();
        Button loginBtn = new Button("Login");
        Text alreadyRegistered = new Text("Already Registered?");
        Button registerBtn = new Button("Register");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600, 300);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(firstNumber, 1, 1);
        gridPane.add(fnumField, 2, 1);
        gridPane.add(surname, 3, 1);
        gridPane.add(surnameField, 4, 1);
        gridPane.add(email, 1, 2);
        gridPane.add(emailField, 2, 2);
        gridPane.add(tel, 3, 2);
        gridPane.add(telField, 4, 2);
        gridPane.add(userName, 1, 3);
        gridPane.add(userNameField, 2, 3);
        gridPane.add(password, 3, 3);
        gridPane.add(passwordField, 4, 3);
        gridPane.add(registerBtn, 1, 4);
        gridPane.add(alreadyRegistered, 1, 5);
        gridPane.add(loginBtn, 2, 5);
        primaryStage.setTitle("REGISTER");
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        registerBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                String firstNumField = fnumField.getText();
                String surName = surnameField.getText();
                String emailFld = emailField.getText();
                String telFld = telField.getText();
                String username = userNameField.getText();
                String passwrd = passwordField.getText();

                try {
                    //Step One - Register the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //Step Two - Creating the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/exercise?", "root", "");

                    //Step Three - Create the statement object
                    Statement st = con.createStatement();

                    //Step Four
                    String query = "INSERT INTO registration VALUES('"+firstNumField+"','"+surName+"','"+emailFld+"','"+telFld+"','"+username+"','"+passwrd+"')";
                    int rs = st.executeUpdate(query);

                        Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                        al.setContentText("Successful Registration");
                        al.show();

                    

                    //Step five - Closing the connection
                    con.close();

                } catch (Exception ee) {
                    System.out.println(ee);
                    System.out.println("Connection error");
                }
                {
                }
            }
        }));
        loginBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                LoginClass l = new LoginClass();
                l.start(LoginClass.loginStage);
            }
        }));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
