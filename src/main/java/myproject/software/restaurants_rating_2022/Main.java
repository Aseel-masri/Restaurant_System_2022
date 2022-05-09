package myproject.software.restaurants_rating_2022;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("splash.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
       // stage.setHeight(381);
       // stage.setWidth(513);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
