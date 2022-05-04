package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class BigLogInController {
    @FXML
    private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }
    @FXML
    void openLoginAdmin(MouseEvent event) throws IOException {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogInManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);

        stage.setHeight(481);
        stage.setWidth(730);
        stage.show();
    }

    @FXML
    void openLoginOwner(MouseEvent event) throws IOException {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("restaurantOwnerlog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);

        stage.setHeight(481);
        stage.setWidth(731);
        stage.show();

    }

    @FXML
    void openLoginUser(MouseEvent event) throws IOException {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setScene(scene);

        stage.setHeight(481);
        stage.setWidth(740);
        stage.show();
    }
}
