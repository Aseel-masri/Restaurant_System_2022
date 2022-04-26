package myproject.software.restaurants_rating_2022;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

    public class RestaurantController {

        @FXML
        private ImageView RestoIMG;
        @FXML
        private Label RestoName;


        private Restaurant restaurant;
        public void setData(Restaurant restaurant) {
            this.restaurant=restaurant;
            RestoName.setText(restaurant.getName());
         //  Image image=new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
         //   RestoIMG.setImage(image);
        }
    }
