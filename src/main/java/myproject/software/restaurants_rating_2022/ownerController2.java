package myproject.software.restaurants_rating_2022;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ownerController2 implements Initializable {
    @FXML
    private TextField name;
    @FXML
    void exit(MouseEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    String ccity;
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
    @FXML
    void update(ActionEvent event) throws SQLException {

        comments cmt = new comments();
        int id = cmt.selectedres.getId();

        conection conection1 = new conection();
        Connection c = conection1.getConnection();
        Statement s = c.createStatement();
       // System.out.println(cityes.getValue());


        String sql1="UPDATE `restaurants` SET  `res_name` = '"+name.getText()+"', `res_city` = '"+cityes.getValue()+"', `res_main_image` = '"+m4+"',\n" +
                "`res_image1` = '"+m1+"', `res_image2` = '"+m3+"', `res_menu` = '"+m5+"', `middle_image` = '"+m2+"'\n" +
                "WHERE `restaurants`.`res_id` = "+id;
        s.executeUpdate(sql1);
        c.close();
        System.out.println("Done");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Restaurant");
        alert.setHeaderText(null);
        alert.setContentText("               Done Update Restaurant ");

        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comments cmt = new comments();
        int restid = cmt.selectedres.getId();
        //RestoName.setText(cmt.selectedres.getName());
        //RestoIMG.setImage(new Image(getClass().getResourceAsStream(cmt.selectedres.getImgSrc())));
        strings.add("Nablus");
        strings.add("Tulkarm");
        strings.add("Jenin");
        strings.add("Ramallah");
        strings.add("Qalqilya");

        cityes.setItems(strings);
        cityes.setEditable(false);
   try {

            conection conClass=new conection();
            Connection c=conClass.getConnection();
            String sql="SELECT * FROM restaurants where res_id = "+restid;
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery(sql);

            while (r.next()) {
             name.setText(r.getString("res_name"));
             Image mm1 =new Image(getClass().getResourceAsStream(r.getString("res_main_image")));
             main_image.setImage(mm1);
             m4 = r.getString("res_main_image");

             Image mm2 =new Image(getClass().getResourceAsStream(r.getString("res_image1")));
             left_image.setImage(mm2);
             m1=r.getString("res_image1");

             Image mm3 =new Image(getClass().getResourceAsStream(r.getString("res_image2")));
             right_image.setImage(mm3);
                m3=r.getString("res_image2");
             Image mm4 =new Image(getClass().getResourceAsStream(r.getString("middle_image")));
             mid_image.setImage(mm4);
                m2=r.getString("middle_image");
             Image mm5 =new Image(getClass().getResourceAsStream(r.getString("res_menu")));
             menu.setImage(mm5);
                m5=r.getString("res_menu");
           //  cityes.setPromptText(r.getString("res_city"));
           ccity=r.getString("res_city");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
