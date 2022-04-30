package myproject.software.restaurants_rating_2022;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane parent;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FadeTraansition.applayFadeTransition(parent,Duration.seconds(5),(e) ->{
            try {
                Stage s=(Stage) parent.getScene().getWindow();

             //   Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));

            //   parent.getChildren().setAll(root);
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);

                s.setScene(scene);

                s.setHeight(667);
                s.setWidth(1203);
                s.setX(10);
                s.setY(10);
                s.show();
            } catch (IOException ex){
                Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE,null,ex);

            }});

    }

}