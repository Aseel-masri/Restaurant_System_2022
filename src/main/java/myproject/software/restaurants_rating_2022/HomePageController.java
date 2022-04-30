package myproject.software.restaurants_rating_2022;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
    private Label RestoNameLabel;

    @FXML
    private GridPane grid;

    @FXML
    private GridPane grid2;

    @FXML
    private ScrollPane scroll;
    private MyListener myListener;

    Image image;
    private List<Restaurant> restaurants =new  ArrayList<>();
    private List<Restaurant> getData(){
        List<Restaurant>rstaurants=new ArrayList<>();

            Restaurant rstaurant;

            rstaurant = new Restaurant();
            rstaurant.setName("Dominos");
            rstaurant.setImgSrc("/image/d2.png");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Treio");
            rstaurant.setImgSrc("/image/T100.png");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("W");
            rstaurant.setImgSrc("/image/w1.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Solitaire ");
            rstaurant.setImgSrc("/image/solitare.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Ward");
            rstaurant.setImgSrc("/image/ward.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Lemon W Na3na3");
            rstaurant.setImgSrc("/image/l1.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("90S");
            rstaurant.setImgSrc("/image/N33jpg.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("KFC");
            rstaurant.setImgSrc("/image/k2.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Hardees");
            rstaurant.setImgSrc("/image/Hrdees.jpg");
            rstaurants.add(rstaurant);

            rstaurant = new Restaurant();
            rstaurant.setName("Dominos");
            rstaurant.setImgSrc("/image/d2.png");
            rstaurants.add(rstaurant);


        return rstaurants;
    }

    private void setChosenRestoCard(Restaurant restaurant){

        RestoNameLabel.setText(restaurant.getName());
        image = new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        RestoImage.setImage(image);
        //Location from database
        //OverALL Rate from database

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //restaurants.addAll(getData());
        List<Restaurant>NormalRstaurants=new ArrayList<>();
        List<Restaurant>TrendingRstaurants=new ArrayList<>();

        NormalRstaurants.addAll(getData());
        TrendingRstaurants.addAll(getData());
        if(NormalRstaurants.size()>0){
            setChosenRestoCard(NormalRstaurants.get(0));
            myListener=new MyListener() {
                @Override
                public void onClickListener(Restaurant restaurant) {
                    setChosenRestoCard(restaurant);
                }
            };
        }
        if(TrendingRstaurants.size()>0){
            setChosenRestoCard(TrendingRstaurants.get(0));
            myListener=new MyListener() {
                @Override
                public void onClickListener(Restaurant restaurant) {
                    setChosenRestoCard(restaurant);
                }
            };
        }



        int coulmn=1;
        int row=1;
        try {


        for(int i=0;i <NormalRstaurants.size() ;i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Restaurant.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            RestaurantController restaurantController=fxmlLoader.getController();
            restaurantController.setData(NormalRstaurants.get(i),myListener);

            grid.add(anchorPane,coulmn,row);
            coulmn++;
            if(coulmn==4){row++; coulmn=1;}
            grid.setHgap(10);
            grid.setVgap(10);

            }
            for(int i=0;i < 3;i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Restaurant.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                RestaurantController restaurantController=fxmlLoader.getController();
                restaurantController.setData(TrendingRstaurants.get(i+3),myListener);

                grid2.add(anchorPane,coulmn,row);
                coulmn++;
                grid2.setHgap(10);
                grid.setVgap(10);


        }}catch (IOException e) {
            e.printStackTrace();

        }
    }
}