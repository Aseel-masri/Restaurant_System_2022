package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class SignController {

    @FXML
    private PasswordField confirmpass;

    @FXML
    private TextField email;
    @FXML
    private Label msg;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField phone;


    @FXML private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }

    @FXML
    void openloginpage(MouseEvent event) throws IOException {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("restaurantOwnerlog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

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
            String sql = "select owner_id from restaurants_owners";
            ResultSet set = s.executeQuery(sql);

            while (set.next())
                id = set.getInt("owner_id");
        id=id+1;
        String sql1="insert into restaurants_owners values('"+id+"','"+name.getText()+"','"+email.getText()+"','"+pass.getText()+"','"+phone.getText()+"')";
        s.execute(sql1);
        c.close();

    }else{
            msg.setVisible(true);
            confirmpass.setText("");

        }

    }



}
