package myproject.software.restaurants_rating_2022;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CommentsController implements Initializable {


    @FXML
    private TableColumn<comments, String> comment;

    @FXML
    private TableColumn<comments, String> date;


ObservableList<comments> commentslist= FXCollections.observableArrayList();

    @FXML
    private TableColumn<comments, String> name;



    @FXML
    private TableView<comments> tablee;

    @FXML
    private TableColumn<comments, Integer> user_id;

    @FXML
    private ImageView closee;
    @FXML
    private  ImageView RestoIMG;

    @FXML
    private Label RestoName;



    @FXML
    private Button deletecomment;

    @FXML
    private Button refresh;


    @FXML
    void clickr(ActionEvent event) {
        commentslist.clear();
        showitems();
    }

    @FXML
    void closepage(MouseEvent event) {
        Stage stage = (Stage) closee.getScene().getWindow();
        stage.close();
    }


    private  Restaurant restaurant;
    private MyListener myListener ;
    private ObservableList<comments> selecteditem ;

    @FXML
    void getselected(MouseEvent event) {
        selecteditem= tablee.getSelectionModel().getSelectedItems();

       // System.out.println(selecteditem.get(0).getComment_info());

    }
    @FXML
    void clickd(ActionEvent event) {
int commentid = selecteditem.get(0).getC_id();
        try {

            conection conClass=new conection();
            Connection c=conClass.getConnection();
            //System.out.println("ID value = "+x.selectedres.getRest_id());
            String sql="DELETE FROM comments " +"WHERE c_id=" +commentid;
            Statement s=c.createStatement();
            s.executeUpdate(sql);
            //System.out.println("delete "+x.selectedres.getName()+ "done");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete comments");
            alert.setHeaderText(null);
            alert.setContentText(selecteditem.get(0).getComment_info()+"\nDeleted");
            alert.showAndWait();
            commentslist.clear();
           showitems();
        }
        catch (Exception e){e.printStackTrace();}

    }
    private void showitems(){
        comments cmt = new comments();
        RestoName.setText(cmt.selectedres.getName());
        RestoIMG.setImage(new Image(getClass().getResourceAsStream(cmt.selectedres.getImgSrc())));
        try {

            conection conClass=new conection();
            Connection c=conClass.getConnection();
            String sql="SELECT comments.c_id ,user.user_name , comments.c_info , comments.c_date FROM comments , restaurants , user " +
                    "WHERE comments.res_id=restaurants.res_id " +
                    "and restaurants.res_name= "+'"' +cmt.selectedres.getName()+'"'+
                    " and user.user_id=comments.user_id";
            Statement s=c.createStatement();
            ResultSet r=s.executeQuery(sql);

            while (r.next()) {
                commentslist.add( new comments(r.getInt("comments.c_id"),r.getString("user.user_name")
                        ,r.getString("comments.c_info"),r.getString("comments.c_date")));
            }
            user_id.setCellValueFactory(new PropertyValueFactory<comments, Integer>("c_id"));
            name.setCellValueFactory(new PropertyValueFactory<comments, String>("user_name"));
            comment.setCellValueFactory(new PropertyValueFactory<comments, String>("comment_info"));
            date.setCellValueFactory(new PropertyValueFactory<comments, String>("comment_date"));
            tablee.setItems(commentslist);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

showitems();
    }


}
