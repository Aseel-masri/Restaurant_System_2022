package myproject.software.restaurants_rating_2022;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML private javafx.scene.control.Button closepage;

    @FXML
    private ImageView menu;

    @FXML
    void closepage(ActionEvent event) {
        Stage stage = (Stage) closepage.getScene().getWindow();

        stage.close();
    }

    public void setData(Image m){
        menu.setImage(m);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
