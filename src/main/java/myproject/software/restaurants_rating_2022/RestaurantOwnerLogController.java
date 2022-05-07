package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestaurantOwnerLogController {
    @FXML private javafx.scene.control.Button closebtn;

    @FXML
    private TextField email;

    @FXML
    private TextField pass;

    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }

    @FXML
    void login(MouseEvent event) {
        boolean f=false;
        ResultSet r=null;
        conection conClass=new conection();
        Connection c=conClass.getConnection();
        String mail = null,password=null;
        try {
            Statement s=c.createStatement();
            String sql="select owner_email,owner_pass from restaurants_owners where owner_email='"+email.getText()+"'";
            r=s.executeQuery(sql);

            while (r.next()){
                mail=r.getString("owner_email");
                password=r.getString("owner_pass");
                if (email.getText().equalsIgnoreCase(mail)&&pass.getText().equals(password)){
                    f=true;
                    Stage stage = (Stage) closebtn.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RestaurantOwnerPage.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 320, 240);

                    stage.setScene(scene);

                    stage.setHeight(600);
                    stage.setWidth(800);
                    stage.show();
                    break;
                }
            }


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    void signup(MouseEvent event) throws IOException {

        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);

        stage.setHeight(500);
        stage.setWidth(750);
        stage.show();
    }



}