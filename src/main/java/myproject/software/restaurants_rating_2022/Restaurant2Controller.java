package myproject.software.restaurants_rating_2022;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class Restaurant2Controller {

    @FXML
    private ImageView RestoIMG;
    @FXML
    private Label RestoName;


    @FXML
    void clickc(ActionEvent event)  {
try {
  myListener.onClickListener(restaurant);

    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(getClass().getResource("comments.fxml"));
    Parent root1 = (Parent) fxmlLoader.load();
    Stage stage = new Stage();
    stage.setTitle("Hello!");

        stage.initStyle(StageStyle.TRANSPARENT);

    stage.setScene(new Scene(root1));
    stage.show();
    CommentsController commentscontroller = fxmlLoader.getController();


}
catch(Exception e){
    e.printStackTrace();
}
    }

    @FXML
    void clickd(ActionEvent event) {
        myListener.onClickListener(restaurant);
        comments x = new comments();
        // System.out.println(x.selectedres.getName());
        try {

            conection conClass=new conection();
            Connection c=conClass.getConnection();
            //System.out.println("ID value = "+x.selectedres.getRest_id());
            String sql="DELETE FROM restaurants " +"WHERE res_id=" +x.selectedres.getId();
            Statement s=c.createStatement();
           s.executeUpdate(sql);
            System.out.println("delete "+x.selectedres.getName()+ "done");


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Restaurant");
            alert.setHeaderText(null);
            alert.setContentText(x.selectedres.getName()+" Deleted");

            alert.showAndWait();


    }
        catch (Exception e){e.printStackTrace();}
    }
    private MyListener myListener;

    private Restaurant restaurant;
    public void setData(Restaurant restaurant,MyListener myListener ){
        this.restaurant=restaurant;
        this.myListener=myListener;
        RestoName.setText(restaurant.getName());
        Image image=new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        RestoIMG.setImage(image);
    }

}
