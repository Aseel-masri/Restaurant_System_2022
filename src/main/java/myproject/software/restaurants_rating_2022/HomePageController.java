package myproject.software.restaurants_rating_2022;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
import org.controlsfx.control.Rating;

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
    public int loggedUser_id;
    ResultSet r=null;

    public int choseenres_id;
    @FXML
    private Label choseenres_address;

    @FXML
    private Label choseenres_name;
    @FXML
    private Rating clear_rate;

    @FXML
    private Rating food_rate;
    @FXML
    private Rating price_rate;
    @FXML
    private Rating services_rate;
    @FXML
    private ImageView left_image;

    @FXML
    private ImageView middle_image;
    @FXML
    private ImageView right_image;
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
    private GridPane grid3;
    @FXML
    private ScrollPane scroll;
    private MyListener myListener;

    @FXML
    private AnchorPane rest_Pane;
    @FXML
    private Button bk_btn;

    @FXML
    private Button ViewRestPage;
    @FXML private javafx.scene.control.Button closebtn;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }
    @FXML
     void back_btn(MouseEvent event)throws IOException{
        rest_Pane.setVisible(false);
    }

    Image middle,left,right;
    @FXML
     void view(MouseEvent event){

        conection conClass=new conection();
        Connection c=conClass.getConnection();
        try {
            Statement s=c.createStatement();
            String sql="select res_name,res_city,middle_image,res_image1,res_image2 from restaurants where res_id='"+choseenres_id+"'";
            r=s.executeQuery(sql);
            while (r.next()){
                choseenres_name.setText(r.getString("res_name"));
                choseenres_address.setText(r.getString("res_city"));
               middle = new Image(getClass().getResourceAsStream(r.getString("middle_image")));
                middle_image.setImage(middle);
                left = new Image(getClass().getResourceAsStream(r.getString("res_image1")));
                left_image.setImage(left);
                right = new Image(getClass().getResourceAsStream(r.getString("res_image2")));
                right_image.setImage(right);
            }








        rest_Pane.setVisible(true);
    } catch (SQLException e) {
            e.printStackTrace();
        }}

        Image image;
    private List<Restaurant> restaurants =new  ArrayList<>();
    private List<Comment>Comments=new ArrayList<>();


    private List<Comment>getDataCom(){
        List<Comment>comments=new ArrayList<>();

            for(int i=0;i<10;i++) {
                Comment comment = new Comment();
                comment.setAuthorEmail("danaturabi@hotmail.com");
                comment.setDay_Date("Monday At 1:45:02 am");
                comment.setText("I like this restaurant because ...");
                comments.add(comment);
            }


        return comments;


    }
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
                rstaurant.setId(Integer.parseInt(r.getString("res_id")));
                rstaurants.add(rstaurant);
            }

        return rstaurants;
    }

    private void setChosenRestoCard(Restaurant restaurant){

        RestoNameLabel.setText(restaurant.getName());
        image = new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        RestoImage.setImage(image);
        choseenres_id=restaurant.getId();
        //Location from database
        //OverALL Rate from database

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("LoginUser.fxml"));
        LoginUserController l=fxmlLoader1.getController();
        loggedUser_id=l.user_id;



        //restaurants.addAll(getData());
        List<Restaurant>NormalRstaurants=new ArrayList<>();
        List<Restaurant>TrendingRstaurants=new ArrayList<>();
        List<Comment>commentsList=new ArrayList<>();


        try{  commentsList.addAll(getDataCom());}catch(Exception e){e.printStackTrace();}

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
        int c=1;
        int r=1;
        try {
            for(int i=0;i<commentsList.size();i++){
                FXMLLoader fxmlLoader=new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Comment.fxml"));
                AnchorPane anchorPane=fxmlLoader.load();
                CommentController commentController=fxmlLoader.getController();
                commentController.setDate(commentsList.get(i));
                grid3.add(anchorPane,c,r);
                c++;
                if(c==2){r++;c=1;}
              //  grid3.setVgap(10);
             //   grid3.setHgap(10);
            }

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
    @FXML
    void saveRate(ActionEvent event) throws SQLException {
        int id=0;
      conection c=new conection();
      Connection connection=c.getConnection();
      Statement s=connection.createStatement();
        String sql = "select rate_id from rating";
        ResultSet set = s.executeQuery(sql);

        while (set.next())
            id = set.getInt("rate_id");
        id=id+1;
        double avg=(clear_rate.getRating()+food_rate.getRating()+services_rate.getRating()+price_rate.getRating())/4.0;
        String sql1="insert into rating values('"+id+"','"+this.loggedUser_id+"','"+this.choseenres_id+"','"+services_rate.getRating()+"','"+food_rate.getRating()+"','"+price_rate.getRating()+"','"+clear_rate.getRating()+"','"+avg+"')";
        s.execute(sql1);
        connection.close();


    }
}