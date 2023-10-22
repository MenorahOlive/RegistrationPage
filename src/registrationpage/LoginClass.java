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
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginClass extends Application {

    static Stage loginStage = new Stage();
    @Override
    public void start(Stage primaryStage) {
        Text userName = new Text("UserName");
        TextField userNameField = new TextField();
        Text pass = new Text("Password");
        PasswordField passwordFld = new PasswordField();
        Button loginBtn = new Button("Login");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,300);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
     
        gridPane.add(userName, 1, 1);
        gridPane.add(userNameField, 2, 1);
        gridPane.add(pass, 1, 2);
        gridPane.add(passwordFld, 2, 2);
        gridPane.add(loginBtn, 1, 3);
        primaryStage.setTitle("Login Page");
        Scene scene=new Scene (gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        loginBtn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
             
                String username = userNameField.getText();
                String passwrd = passwordFld.getText();
             
             
             try
             {
                 //Step One - Register the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                //Step Two - Creating the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/exercise?","root","");
               
                //Step Three - Create the statement object
                Statement st= con.createStatement();                
               
                //Step Four
                String query = "SELECT * FROM exercise.registration Where username = '"+username+"' AND passwrd = '"+passwrd+"' ";
                //step five- execute query
                ResultSet rs = st.executeQuery(query);
               
                if(rs.next())
                {
                    //successful login opens to home page
                    HomeClass h = new HomeClass();
                    h.start(HomeClass.homeStage);
                }
               
                else
                {
                    Alert al = new Alert(Alert.AlertType.WARNING);
                    al.setContentText("Invalid Credentials");
                    al.show();
               
                }
               
                //Step five - Closing the connection
                con.close();
             
             }
            catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
            {
            }
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
