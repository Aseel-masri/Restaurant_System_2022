package myproject.software.restaurants_rating_2022;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

    private List<Restaurant> restaurants =new  ArrayList<>();
    private Restaurant getData(){
       // List<Restaurant>rstaurants=new ArrayList<>();
        Restaurant rstaurant;
       /* for(int i=0;i<20;i++) {
            rstaurant = new Restaurant();
            rstaurant.setName("Solitaire");
            rstaurant.setColor("FFB587");
            rstaurant.setImgSrc("/iamge/solitare.jpg");
            rstaurants.add(rstaurant);

        }
        */
        rstaurant = new Restaurant();
        rstaurant.setName("Solitaire");
        rstaurant.setColor("FFB587");
        rstaurant.setImgSrc("solitare.jpg");
        return rstaurant;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //restaurants.addAll(getData());
        Restaurant normalRestaurant=this.getData();
        Restaurant trendingRestaurant=this.getData();

        int coulmn=1;
        int row=1;
        try {


        for(int i=0;i < 10;i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Restaurant.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            RestaurantController restaurantController=fxmlLoader.getController();
            restaurantController.setData(normalRestaurant);
            /*
            FXMLLoader fxmlLoader2=new FXMLLoader();
            fxmlLoader2.setLocation(getClass().getResource("Restaurant.fxml"));
            AnchorPane anchorPane2 = fxmlLoader2.load();
            RestaurantController restaurantController2=fxmlLoader2.getController();
            restaurantController2.setData(rr);
             */
           /* if(coulmn==3){
                coulmn=0;
                row++;
            }
            */
            grid.add(anchorPane,coulmn,row);
            coulmn++;
            if(coulmn==4){row++; coulmn=1;}
            grid.setHgap(10);
            grid.setVgap(10);
           //grid.setVisible(true);
           //grid.autosize();
          //  GridPane.setMargin(anchorPane,new Insets(1,1,1,1));
          //  grid.add(anchorPane2,2,1);
            }
            for(int i=0;i < 3;i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Restaurant.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                RestaurantController restaurantController=fxmlLoader.getController();
                restaurantController.setData(normalRestaurant);

                grid2.add(anchorPane,coulmn,row);
                coulmn++;
              //  if(coulmn==4){row++; coulmn=1;}
                grid2.setHgap(10);
               // grid.setVgap(10);


        }}catch (IOException e) {
            e.printStackTrace();

        }
    }
}