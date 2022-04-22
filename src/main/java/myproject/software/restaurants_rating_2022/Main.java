package myproject.software.restaurants_rating_2022;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setHeight(700);
        stage.setWidth(800);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
