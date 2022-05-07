package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GenerateReportController {

    @FXML private javafx.scene.control.Button close1;
    @FXML
    void close2(MouseEvent event) throws IOException {
        Stage stage = (Stage) close1.getScene().getWindow();
        stage.close();
    }
    @FXML
    void actionclose(ActionEvent event) throws IOException {
//        Stage stage = (Stage) close1.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setScene(scene);
//        // stage.setHeight(500);
//        //stage.setWidth(750);
//        stage.show();


    }
}
