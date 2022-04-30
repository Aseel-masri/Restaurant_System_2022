package myproject.software.restaurants_rating_2022;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    @FXML private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }

    Image image;
    private List<Restaurant> restaurants =new  ArrayList<>();
    private List<Restaurant> getData() throws SQLException {
        List<Restaurant>rstaurants=new ArrayList<>();

            Restaurant rstaurant;

            rstaurant = new Restaurant();
        conection conClass=new conection();
        Connection c=conClass.getConnection();

            Statement s=c.createStatement();
            String sql="select * from restaurants";
        ResultSet r=s.executeQuery(sql);

            while (r.next()) {
                rstaurant = new Restaurant();
                rstaurant.setName(r.getString("res_name"));

                rstaurant.setImgSrc(r.getString("res_main_image"));
                rstaurants.add(rstaurant);
            }

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

        try {
            NormalRstaurants.addAll(getData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            TrendingRstaurants.addAll(getData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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