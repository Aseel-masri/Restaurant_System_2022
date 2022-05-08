package myproject.software.restaurants_rating_2022;

import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import javafx.scene.control.TextField;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
public class ownerController {
    @FXML
    private TextField name;
    @FXML
    void add(ActionEvent event) throws SQLException {
        int id=0;
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("restaurantOwnerlog.fxml"));
        RestaurantOwnerLogController  ro = fxmlLoader.getController();

        int ownerid=ro.ownerid;
        conection conection1 = new conection();
        Connection c = conection1.getConnection();
        Statement s = c.createStatement();
        String sql = "select res_id from restaurants";
        ResultSet set = s.executeQuery(sql);

        while (set.next())
            id = set.getInt("res_id");
        id=id+1;
        /*INSERT INTO `restaurants` VALUES ('8', 'KFC', 'nablus', '/image/k2.jpg', '/image/new_KFC3rd.jpg', '/image/new_KFC2ndjpg.jpg', '...', '1', '/image/new_KFC1st.jpg')*/

        String sql1="INSERT INTO `restaurants`" +
                " (`res_id`, `res_name`, `res_city`, `res_main_image`, `res_image1`," +
                " `res_image2`, `res_menu`, `owner_id`, `middle_image`) " +
                "VALUES ('"+id+"', '"+name.getText()+"', '"+cityes.getValue()
                +"', '"+m4+"', '"+m1+"', '"+m3
                +"', '"+m5+"', '"+ownerid+"', '"+m2+"')";
        s.execute(sql1);
        c.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Restaurant");
        alert.setHeaderText(null);
        alert.setContentText("               Done Added Restaurant ");

        alert.showAndWait();
        System.out.println("Done");
    }
    @FXML
    void exit(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    private ImageView exit;
    @FXML
    private ImageView left_image;

    @FXML
    private ImageView main_image;

    @FXML
    private ImageView right_image;
    @FXML
    private ImageView menu;
    @FXML
    private JFXComboBox<String> cityes;
    @FXML
    private ImageView mid_image;


String m1,m2,m3,m4,m5;

    @FXML
    public void initialize() {
        strings.add("Nablus");
        strings.add("Tulkarm");
        strings.add("Jenin");
        strings.add("Ramallah");
        strings.add("Qalqilya");

        cityes.setItems(strings);
       cityes.setEditable(false);


    }

    final ObservableList<String> strings = FXCollections.observableArrayList();

    @FXML
    void uplode_main_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            main_image.setImage(m);
            System.out.println(m.getUrl());
            String x[] = m.getUrl().split("\\\\");
            int i = x.length;
          m4=("/"+x[i-2]+"/"+(x[i-1]));
        }

    }

    @FXML
    void update_left_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            left_image.setImage(m);
            System.out.println(m.getUrl());
            String x[] = m.getUrl().split("\\\\");
            int i = x.length;
            m1=("/"+x[i-2]+"/"+(x[i-1]));
        }
    }


    @FXML
    void update_right_image(MouseEvent event) {

         FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            right_image.setImage(m);
            System.out.println(m.getUrl());
            String x[] = m.getUrl().split("\\\\");
            int i = x.length;
            m3=("/"+x[i-2]+"/"+(x[i-1]));
        }
    }
    @FXML
    void uplode_mid_image(MouseEvent event) {

        FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            mid_image.setImage(m);
            System.out.println(m.getUrl());
            String x[] = m.getUrl().split("\\\\");
            int i = x.length;
            m2=("/"+x[i-2]+"/"+(x[i-1]));
        }
    }

    @FXML
    void update_menu_image(MouseEvent event) {

        FileChooser fileChooser = new FileChooser();
        Stage s=new Stage();
        File file = fileChooser.showOpenDialog(s);
        if (file!=null) {
            Image m = new Image(file.getPath());
            menu.setImage(m);
            System.out.println(m.getUrl());
            String x[] = m.getUrl().split("\\\\");
            int i = x.length;
            m5=("/"+x[i-2]+"/"+(x[i-1]));

        }
    }


}