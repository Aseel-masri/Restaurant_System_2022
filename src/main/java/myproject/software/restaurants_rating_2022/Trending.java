package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
public class Trending implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;


    private List<Restaurant> getData() throws SQLException {
        List<Restaurant>rstaurants=new ArrayList<>();

        Restaurant restaurantt;

        restaurantt = new Restaurant();
        conection conClass=new conection();
        Connection c=conClass.getConnection();

        Statement s=c.createStatement();
        String sql="SELECT rating.res_id, restaurants.res_name, restaurants.res_main_image,AVG(rating.avg_rate) FROM rating ,restaurants WHERE rating.res_id=restaurants.res_id  " +
                "GROUP BY rating.res_id ,restaurants.res_name ORDER BY AVG(rating.avg_rate) DESC  ;\n";
        ResultSet r=s.executeQuery(sql);
        while (r.next()) {
            restaurantt = new Restaurant();
            restaurantt.setName(r.getString("res_name"));
            restaurantt.setImgSrc(r.getString("res_main_image"));
           // restaurantt.setRest_rate("/image/onestar.png");
            //System.out.println(r.getString("AVG(rating.avg_rate)"));
            float x = Float.parseFloat(r.getString("AVG(rating.avg_rate)"));
            System.out.println(x);
           /* if (1 <= r.getFloat("AVG(rating.avg_rate)") && 2 < r.getFloat("AVG(rating.avg_rate)")) {
                restaurantt.setRest_rate("/image/onestar.png");
            } else if (2 <= r.getFloat("AVG(rating.avg_rate)") && 3 < r.getFloat("AVG(rating.avg_rate)")) {
                restaurantt.setRest_rate("/image/twostar.png");
            } else if (3 <= r.getFloat("AVG(rating.avg_rate)") && 4 < r.getFloat("AVG(rating.avg_rate)")) {
                restaurantt.setRest_rate("/image/threestar.png");
            } else if (3 <= r.getFloat("AVG(rating.avg_rate)") && 4 < r.getFloat("AVG(rating.avg_rate)")) {
                restaurantt.setRest_rate("/image/fourstar.png");
            } else if (5 == r.getFloat("AVG(rating.avg_rate)")) {
                restaurantt.setRest_rate("/image/fivestar.png");
            }
*/
            if (1 <= x && 2 > x) {
                System.out.println("one");
                restaurantt.setRest_rate("/image/onestar.png");
            } else if (2 <= x && 3 > x) {
                System.out.println("two");
                restaurantt.setRest_rate("/image/twostar.png");
            } else if (3 <= x && 4 > x ) {
                System.out.println("three");
                restaurantt.setRest_rate("/image/threestar.png");
            } else if (4 <= x && 5 > x) {
                System.out.println("four");
                restaurantt.setRest_rate("/image/fourstar.png");
            } else  {
                System.out.println("five");
                restaurantt.setRest_rate("/image/fivestar.png");
            }

            rstaurants.add(restaurantt);

        }
        return rstaurants;
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

        for(int i=0;i <3 ;i++){
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TrendRes.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            TrendResController tr = fxmlLoader.getController();
            tr.setData(allrstaurants.get(i));
            grid.add(anchorPane,coulmn,row);
            coulmn++;
            if(coulmn==4){row++; coulmn=1;}
            grid.setHgap(10);
            grid.setVgap(10);

        }
    }
    @FXML
    private ImageView exit;
    @FXML
    void exit(MouseEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
