package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpUserController {


    @FXML
    private PasswordField confirmpass;
    @FXML
    private Label msg;
    @FXML
    private TextField city;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

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
    void openLogin(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginUser.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 240);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(scene);

        stage.setHeight(500);
        stage.setWidth(750);
        stage.show();
    }
    @FXML
    void signup(MouseEvent event) throws SQLException {
        int id=0;
        if(pass.getText().equals(confirmpass.getText())) {

            msg.setVisible(false);

            conection conection1 = new conection();
            Connection c = conection1.getConnection();
            Statement s = c.createStatement();
            String sql = "select user_id from user";
            ResultSet set = s.executeQuery(sql);

            while (set.next())
                id = set.getInt("user_id");
            id=id+1;
            String sql1="insert into user values('"+id+"','"+name.getText()+"','"+email.getText()+"','"+city.getText()+"','"+pass.getText()+"')";
            s.execute(sql1);
            c.close();
            name.setText("");
            pass.setText("");
            city.setText("");
            email.setText("");
            confirmpass.setText("");


        }else{
            msg.setVisible(true);
            confirmpass.setText("");

        }



    }
}
