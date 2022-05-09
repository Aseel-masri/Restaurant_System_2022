package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginManagerController {
    ResultSet r;
    public String mail,password;
    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;

    @FXML
    private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }
    @FXML
    void login(MouseEvent event) {

        conection conClass=new conection();
        Connection c=conClass.getConnection();
        try {

            Statement s=c.createStatement();
            String sql="select admin_email,admin_pass from admin where admin_email='"+email.getText()+"'";
            r=s.executeQuery(sql);

            while (r.next()){
                mail=r.getString("admin_email");
                password=r.getString("admin_pass");

            }
            if (email.getText().equalsIgnoreCase(mail)&&pass.getText().equals(password)){
                Stage stage = (Stage) closebtn.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);

                stage.setScene(scene);

                stage.setHeight(500);
                stage.setWidth(800);
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


}
