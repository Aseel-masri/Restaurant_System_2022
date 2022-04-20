package myproject.software.restaurants_rating_2022;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

    public class RestaurantController {

        @FXML
        private ImageView IMG;
        @FXML
        private Label RestoName;


        private Restaurant rest;
        public void setData() {
            this.rest=rest;
            RestoName.setText(rest.getName());
            Image image=new Image(getClass().getResourceAsStream(rest.getImgSrc()));
            IMG.setImage(image);
        }
    }
