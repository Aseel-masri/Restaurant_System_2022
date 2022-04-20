package myproject.software.restaurants_rating_2022;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    private VBox ChosenRestoCard;

    @FXML
    private ImageView RestoImage;

    @FXML
    private HBox RestoNameLabel;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    private List<Restaurant> Restaurants =new  ArrayList<>();
    private List<Restaurant> getData(){
        List<Restaurant>Restaurants=new ArrayList<>();
        Restaurant rest;
        for(int i=0;i<20;i++){
            rest =new Restaurant();
            rest.setName("Solitaire");
            rest.setColor("FFB587");
            rest.setImgSrc("/iamge/solitare.jpg");


        }return Restaurants;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Restaurants.addAll(getData());
        for(int i=0;i < Restaurants.size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Restaurant"));
            RestaurantController restaurantController=fxmlLoader.getController();
            restaurantController.setData();
        }
    }
}