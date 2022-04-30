package myproject.software.restaurants_rating_2022;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.w3c.dom.events.MouseEvent;

public class RestaurantController {

        @FXML
        private ImageView RestoIMG;
        @FXML
        private Label RestoName;
        @FXML
        private void click(ActionEvent actionEvent){
            myListener.onClickListener(restaurant);
        }
        private MyListener myListener;

        private Restaurant restaurant;
        public void setData(Restaurant restaurant,MyListener myListener) {
            this.restaurant=restaurant;
            this.myListener=myListener;
            RestoName.setText(restaurant.getName());
            Image image=new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
            RestoIMG.setImage(image);
        }
    }
