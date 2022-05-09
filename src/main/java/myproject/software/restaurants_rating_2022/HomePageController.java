package myproject.software.restaurants_rating_2022;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    ResultSet r1=null;
    double o=0;

    public int choseenres_id;
    @FXML
    private Label choseenres_address;

    @FXML
    private Rating overallrating;
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
    private Button bk_btn1;

    @FXML
    private Button Search_btn;

    @FXML
    private TextField write_rest_name_city;

    @FXML
    private Button ViewRestPage;
    @FXML private javafx.scene.control.Button closebtn;

    @FXML
    private AnchorPane searchPane;

    @FXML
    private GridPane grid4;
    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();

        stage.close();

    }
    ///////////new////////
    @FXML
    private void search(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        grid4.getChildren().clear();
        int flag = 0;// not found
        int flag2=0;// not found2
        if (write_rest_name_city.getText().isEmpty()==true) {
            restaurants.clear();
            Alert a=new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setHeaderText("please fill the search bar");
            a.show();

        }

        else  {
            for(int i=0;i<RestNames.size();i++) {
                if ((RestNames.get(i).equalsIgnoreCase(write_rest_name_city.getText()))) {
                    flag=1;
                }

            }
            for(int i=0;i<RestCity.size();i++) {
                if ((RestCity.get(i).equalsIgnoreCase(write_rest_name_city.getText()))) {
                    flag2=1;
                }

            }
            if(flag==0&&flag2==0){//not found
                restaurants.clear();
                Alert a=new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);
                a.setHeaderText("No results to your search plz check your inputs again !!");
                a.show();
            }


        }

        restaurants.addAll(searchRest(write_rest_name_city.getText())); //to get filterd data

        rest_Pane.setVisible(false);
        searchPane.setVisible(true);


        int coulmn =1;
        int row = 1;

        for(int i=0;i <restaurants.size() ;i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Restaurant.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            RestaurantController restaurantController=fxmlLoader.getController();
            restaurantController.setData(restaurants.get(i),myListener);
            grid4.add(anchorPane,coulmn,row);
            coulmn++;
            if(coulmn==4){row++; coulmn=1;}
            grid4.setHgap(10);
            grid4.setVgap(10);

        }

        restaurants.clear();

    }

    static List<String>RestNames=new ArrayList<>();
    static List<String>RestCity=new ArrayList<>();
    ///////end new//////////
    @FXML
    void back_btn(MouseEvent event)throws IOException{
        rest_Pane.setVisible(false);
        choseenres_id=0;
        clear_rate.setRating(0);
        food_rate.setRating(0);
        price_rate.setRating(0);
        services_rate.setRating(0);
    }
    @FXML
    void back_btn2(MouseEvent event) {
        rest_Pane.setVisible(false);
        searchPane.setVisible(false);
    }


    Image middle,left,right;
    @FXML
    void view(MouseEvent event){


        conection conClass=new conection();
        Connection c=conClass.getConnection();
        try {
            Statement s=c.createStatement();
            Statement s1=c.createStatement();
            String sql="select res_name,res_city,middle_image,res_image1,res_image2 from restaurants where res_id='"+choseenres_id+"'";
            r=s.executeQuery(sql);

            while (r.next()){
                String sql1="select * from rating where res_id='"+choseenres_id+"'";
                choseenres_name.setText(r.getString("res_name"));
                choseenres_address.setText(r.getString("res_city"));
                middle = new Image(getClass().getResourceAsStream(r.getString("middle_image")));
                middle_image.setImage(middle);
                left = new Image(getClass().getResourceAsStream(r.getString("res_image1")));
                left_image.setImage(left);
                right = new Image(getClass().getResourceAsStream(r.getString("res_image2")));
                right_image.setImage(right);
                ResultSet ss=s1.executeQuery(sql1);
                while(ss.next()){
                    if(ss.getInt(2)==loggedUser_id){
                        clear_rate.setRating(ss.getFloat("Cleanliness_rate"));
                        food_rate.setRating(ss.getFloat("foodquality_rate"));
                        services_rate.setRating(ss.getFloat("services_rate"));
                        price_rate.setRating(ss.getFloat("Priceforservice_rate"));
                    }}
            }
            rest_Pane.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    Image image;
    private List<Restaurant> restaurants =new  ArrayList<>();
    private List<Comment>Comments=new ArrayList<>();


    private List<Comment>getDataCom() throws SQLException {
        List<Comment>comments=new ArrayList<>();
        conection c=new conection();
        Connection connection=c.getConnection();
        Statement s=connection.createStatement();
        String sql="select * from comments";
        ResultSet set=s.executeQuery(sql);
        Statement s1=connection.createStatement();


        while (set.next()){
            Comment comment = new Comment();
            String sql1="select * from user where user_id='"+set.getInt("user_id")+"'";
            ResultSet set1= s1.executeQuery(sql1);
            while (set1.next()){
                comment.setAuthorEmail(set1.getString("user_name"));
            }

            comment.setDay_Date(set.getString("c_date"));
            comment.setText(set.getString("c_info"));
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
        Statement s1=c.createStatement();
        String sql="select * from restaurants";
        ResultSet r=s.executeQuery(sql);

        while (r.next()) {
            rstaurant = new Restaurant();
            rstaurant.setName(r.getString("res_name"));

            rstaurant.setImgSrc(r.getString("res_main_image"));
            rstaurant.setId(Integer.parseInt(r.getString("res_id")));
            String sql1="select avg_rate from rating where res_id='"+rstaurant.getId()+"'";
            ResultSet r1=s1.executeQuery(sql1);
            while(r1.next()){
                o=r1.getFloat("avg_rate");rstaurant.setRate(o);
            }

            rstaurants.add(rstaurant);
        }

        return rstaurants;
    }
    /////////////new///////////
    public static List<Restaurant> searchRest(String resValue)throws ClassNotFoundException,SQLException {

        Restaurant rstaurant;
        rstaurant = new Restaurant();
        List<Restaurant> Filteredrest = new ArrayList<>();
        conection conClass = new conection();
        Connection c = conClass.getConnection();
        Statement s = c.createStatement();
        try {
            String sql = "select * from restaurants where  res_city =  '" + resValue + "' or res_name =  '" + resValue + "' or res_name='"+resValue.toLowerCase()+"' or res_name='"+resValue.toUpperCase()+"' or res_city='"+resValue.toUpperCase()+"' or res_city='"+resValue.toLowerCase()+"'";
            ResultSet resultSet = s.executeQuery(sql);

            while (resultSet.next()) {
                rstaurant = new Restaurant();
                rstaurant.setName(resultSet.getString("res_name"));

                rstaurant.setImgSrc(resultSet.getString("res_main_image"));
                rstaurant.setId(Integer.parseInt(resultSet.getString("res_id")));
                Filteredrest.add(rstaurant);
            }

        } catch (SQLException e) {


        }            return Filteredrest;

    }
    /////////////end new///////////


    private void setChosenRestoCard(Restaurant restaurant){


            RestoNameLabel.setText(restaurant.getName());
            image = new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
            RestoImage.setImage(image);
            choseenres_id=restaurant.getId();
            overallrating.setRating(restaurant.getRate());
            //Location from database
            //OverALL Rate from database

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("LoginUser.fxml"));
        LoginUserController l=fxmlLoader1.getController();
        loggedUser_id=l.user_id;


        overallrating.setRating(0.0);

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
        try{

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

            Comments.addAll(getDataCom());
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
     catch (SQLException e) {
            e.printStackTrace();
        } }
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
        Alert a=new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setHeaderText("rating saved successfully");
        a.show();


    }
    @FXML
    void logout(MouseEvent event) {
        if(loggedUser_id==0){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("you are already logged out.");
            a.show();
        }
        else {
            loggedUser_id = 0;

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("you logged out from your account and you are now in the guest account");
            a.show();
        }
    }
    @FXML
    void login(MouseEvent event) throws IOException {
        if(loggedUser_id==0){
            Stage stage = (Stage) closebtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("bigLogIn.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            stage.setScene(scene);

            stage.setHeight(481);
            stage.setWidth(730);
            stage.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("you are already logged in.");
            a.show();
        }

    }
    @FXML
    private TextField comment;
    @FXML
    void addComment(ActionEvent event) throws IOException, SQLException {

        int coulmn=1;
        int row=1;
        int cc=1;
        int r=1;
        Comment c=new Comment();
        c.setAuthorEmail("baraa");
        c.setDay_Date("5/5/2022");
        c.setText("bnaiodfhqahfdhfqh");

        Comments.add(c);

        grid3.getChildren().clear();
        for(int i=0;i<Comments.size();i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Comment.fxml"));
            AnchorPane anchorPane=fxmlLoader.load();
            CommentController commentController=fxmlLoader.getController();
            commentController.setDate(Comments.get(i));

            grid3.add(anchorPane,cc,r);
            cc++;grid3.setAlignment(Pos.BASELINE_LEFT);

            if(cc==2){r++;cc=1;}
            //  grid3.setVgap(10);
            //   grid3.setHgap(10);
        }



    }

}