package myproject.software.restaurants_rating_2022;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;

import java.io.File;


public class ownerController {

    @FXML
    private ImageView left_image;

    @FXML
    private ImageView main_image;

    @FXML
    private ImageView right_image;

    @FXML
    private JFXComboBox<String> cityes;
    @FXML
    private JFXTextArea menu;



    @FXML
    public void initialize() {
        strings.add("Nablus");
        strings.add("Tulkarm");
        strings.add("Jenin");
        strings.add("Ramallah");
        strings.add("Qalqilya");

        cityes.setItems(strings);
       cityes.setEditable(false);
       menu.setText("dddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
               "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");

    }

    final ObservableList<String> strings = FXCollections.observableArrayList();

    @FXML
    void uplode_main_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            main_image.setImage(m);
        }
    }

    @FXML
    void update_left_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            left_image.setImage(m);
        }
    }


    @FXML
    void update_right_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            right_image.setImage(m);
        }
    }
    }
