package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AllownerRes implements Initializable {
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;



    // private List<Restaurant> allrstaurants =new ArrayList<>();
    public   Restaurant  selectedrest;
    private MyListener myListener;
    private comments cmnts ;
    //private CommentsController cc;

    @FXML
    void insert(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("RestaurantOwnerPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Hello!");

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(new Scene(root1));
            stage.show();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }



        private List<Restaurant> getData() throws SQLException {
        List<Restaurant>rstaurants=new ArrayList<>();

        Restaurant restaurantt;
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("restaurantOwnerlog.fxml"));
            RestaurantOwnerLogController  ro = fxmlLoader.getController();

            int ownerid=ro.ownerid;
        restaurantt = new Restaurant();
        conection conClass=new conection();
        Connection c=conClass.getConnection();

        Statement s=c.createStatement();
        String sql="select * from restaurants where owner_id  = "+ownerid;
        ResultSet r=s.executeQuery(sql);

        while (r.next()) {
            restaurantt = new Restaurant();
            restaurantt.setId(r.getInt("res_id"));

            restaurantt.setName(r.getString("res_name"));

            restaurantt.setImgSrc(r.getString("res_main_image"));
            rstaurants.add(restaurantt);
        }

        return rstaurants;
    }

    private void setChosenRestoCard(Restaurant restaurant){

        comments cmt = new comments();
        cmt.selectedres=restaurant;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Restaurant>allrstaurants=new ArrayList<>();
        int coulmn=1;
        int row=1;
        try {
            allrstaurants.addAll(getData());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(allrstaurants.size()>0){
            setChosenRestoCard(allrstaurants.get(0));
            myListener=new MyListener() {
                @Override
                public void onClickListener(Restaurant restaurant) {
                    setChosenRestoCard(restaurant);
                }
            };
        }
        for(int i=0;i <allrstaurants.size() ;i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Restaurant3.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Restaurant3Controller restaurantController=fxmlLoader.getController();
            restaurantController.setData(allrstaurants.get(i),myListener);

            grid.add(anchorPane,coulmn,row);
            coulmn++;
            if(coulmn==4){row++; coulmn=1;}
            grid.setHgap(10);
            grid.setVgap(10);

        }

    }
    @FXML
    void refresh(MouseEvent event) throws Exception {
        Stage stage2 = (Stage)grid.getScene().getWindow();
        stage2.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("RestaurantOwnerBigPage.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Hello!");

        stage.initStyle(StageStyle.TRANSPARENT);

        stage.setScene(new Scene(root1));
        stage.show();
        RestaurantOwnerBigPageController ad = fxmlLoader.getController();
        ad.allrestaurant();
    }
    @FXML
    private ImageView exit;
    @FXML
    void exit(MouseEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RestaurantOwnerBigPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
