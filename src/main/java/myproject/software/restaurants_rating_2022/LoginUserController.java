package myproject.software.restaurants_rating_2022;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginUserController {
    public static int user_id;
    public ResultSet r=null;
    public String mail,password;


    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;



    @FXML
    void loginUser(MouseEvent event) {
        conection conClass=new conection();
        Connection c=conClass.getConnection();
        try {
            Statement s=c.createStatement();
            String sql="select user_id,user_email,user_pass from user where user_email='"+email.getText()+"'";
            r=s.executeQuery(sql);

            while (r.next()){
                mail=r.getString("user_email");
                password=r.getString("user_pass");
                user_id= Integer.parseInt(r.getString("user_id"));

            }
            if (email.getText().equalsIgnoreCase(mail)&&pass.getText().equals(password)){
                Stage stage = (Stage) closebtn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);

                stage.setScene(scene);

                stage.setHeight(667);
                stage.setWidth(1203);
                stage.setY(5);
                stage.setX(5);
                stage.show();



            }
            else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("wrong email or password please try again");
                a.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void signupUser(MouseEvent event) throws IOException {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("signupUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);

        stage.setHeight(504);
        stage.setWidth(794);
        stage.show();

    }
    @FXML private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }


}
