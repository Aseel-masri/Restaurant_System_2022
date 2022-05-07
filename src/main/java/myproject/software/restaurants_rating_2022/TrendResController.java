package myproject.software.restaurants_rating_2022;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class TrendResController {
    @FXML
    private ImageView RestoIMG;

    @FXML
    private Label RestoName;
    private Restaurant restaurant;
    @FXML
    private ImageView starrate;

    public void setData(Restaurant restaurant) {
        this.restaurant=restaurant;
        RestoName.setText(restaurant.getName());
        Image image=new Image(getClass().getResourceAsStream(restaurant.getImgSrc()));
        RestoIMG.setImage(image);
        Image image2=new Image(getClass().getResourceAsStream(restaurant.getRest_rate()));
        starrate.setImage(image2);
    }
}
