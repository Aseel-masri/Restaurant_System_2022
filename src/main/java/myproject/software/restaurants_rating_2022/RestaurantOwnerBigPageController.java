package myproject.software.restaurants_rating_2022;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RestaurantOwnerBigPageController implements Initializable {
    @FXML private ImageView exit,menu,userimg;
    @FXML
    private AnchorPane pane1,pane2,paneRes;
    @FXML
    VBox VBoxOwners,BOXTEXT ;

    @FXML JFXButton report;
    @FXML AnchorPane message;
    @FXML AnchorPane reportAnchor;
    @FXML VBox itemRes,vboxmsg;
    @FXML
    HBox box2;
    @FXML
    TextArea textArea1;
    @FXML
    private AnchorPane contentarea;



    String x="3";
    String t;
    int n = 0;
    ObservableList<String> names = FXCollections.observableArrayList();
    ObservableList<String> names2 = FXCollections.observableArrayList();
    ObservableList<String> data = FXCollections.observableArrayList();
    ObservableList<String> data2 = FXCollections.observableArrayList();
    ObservableList <Integer> dataid = FXCollections.observableArrayList();
    ObservableList <Integer> ownerIDMsg = FXCollections.observableArrayList();
    ObservableList<String> MSGINFO = FXCollections.observableArrayList();
    ObservableList <String> test = FXCollections.observableArrayList();

    @FXML ListView<String>  listRes=new ListView<>(names);
    @FXML  Label ResSelected,userlabel;
    @FXML TextField text;

    @FXML ListView<String>  listRes2=new ListView<>(names2);
    @FXML ListView l2;
    boolean flage=false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });
        pane1.setVisible(false);
        RestaurantOwnerLogController res =new RestaurantOwnerLogController();
        int ownerID=1;
           String ownerEMAIL= res.EmailOwner;
/* ***************** add the name of restaurants into list by ownerID     */
        String mira="mirajamous100@gmail.com";

        String em = null;
        try {
            conection conClass=new conection();
            Connection c=conClass.getConnection();
            Statement  s = c.createStatement();
            String sql1= "select * from restaurants_owners ";
            ResultSet r=s.executeQuery(sql1);
            while(r.next()) {
                 em=r.getString("owner_email");
                if(em.equals(ownerEMAIL)){
                    n=r.getInt("owner_id");
                }
                else{


                }
                }
//            System.out.println(em);
//            System.out.println(n);
            int n2;
            String na = null;
            conection conClass22=new conection();
            Connection c22=conClass22.getConnection();
            Statement  s22 = c22.createStatement();
            String sql= "select * from restaurants";
            ResultSet r22=s22.executeQuery(sql);
            while(r22.next()){

             n2=r22.getInt("owner_id");
             na=r22.getString("res_name");
             if(n2==n){
                 test.add(na);
                // listRes.setCellFactory(ComboBoxListCell.forListView(test));
                 //listRes.setItems(test);
             }


            }

            for(int g=0;g<test.size();g++){
                listRes.getItems().add(test.get(g));
            }

                
//            listRes.setItems(data);
//            listRes.setCellFactory(ComboBoxListCell.forListView(names));
//            listRes.setItems(names);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /* *************** select item from List View  ************** */

        listRes.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                 String new_val) -> {
                    // System.out.println(new_val);
                    ResSelected.setText(new_val);
                });
        /* ********************************************************** */

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), pane2);
        translateTransition.setByX(-600);
        translateTransition.play();


        menu.setOnMouseClicked(event -> {
            menu.setRotate(90);
            pane1.setVisible(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.20);
            fadeTransition1.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(+600);
            translateTransition1.play();


        });
        pane1.setOnMouseClicked(event -> {

            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0.20);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);


            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();
            menu.setRotate(180);
        });

        /* ***************  restaurant owner data base for messages page   *************** */
        int id;
        try {
            conection conClass21 = new conection();
            Connection c1 = conClass21.getConnection();
            Statement s21 = c1.createStatement();
            String sql21 = "select * from admin";
            ResultSet r21 = s21.executeQuery(sql21);


            while (r21.next()) {
              //  String ss2 = r2.getString("admin_id");
                String email = r21.getString("admin_email");
                id = r21.getInt("admin_id");
              //  names2.add("admin #"+ss2);
                data2.add(email);
                dataid.add(id);
                listRes2.getItems().add(email);


            }

            //n= owner id log in

            Image image = new Image(getClass().getResourceAsStream("/image/user.png"));


            listRes2.getSelectionModel().selectedItemProperty().addListener(
                    (ObservableValue<? extends String> ov, String old_val,
                     String new_val2) -> {
                        flage = false;
                        vboxmsg.getChildren().clear();
                        ownerIDMsg.clear();
                        MSGINFO.clear();
                        try {
                            conection conClass3 = new conection();
                            Connection c3 = conClass3.getConnection();
                            Statement s3 = c3.createStatement();
                            String sql3 = "select * from msgs";
                            ResultSet r3 = s3.executeQuery(sql3);

                            while (r3.next()) {

                                int in = r3.getInt("owner_id");

                                    String mmm = r3.getString("msg_info");
                                    ownerIDMsg.add(in);
                                    MSGINFO.add(mmm);
                            }
                            for(int p=0 ;p<ownerIDMsg.size();p++){
                                if(ownerIDMsg.get(p)==n){
                                    String w = MSGINFO.get(p);
                                    Label k = new Label();
                                    k.setText(w);
                                    vboxmsg.getChildren().add(k);

                                }
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }

                        int idd = 0;

                        for (int i = 0; i < data2.size(); i++) {

                            if (new_val2 == data2.get(i)) {
                                userimg.setImage(image);
                                userlabel.setText(data2.get(i));
                                idd = dataid.get(i);
                            }


                        }
//                        for (int g = 0; g < ownerIDMsg.size(); g++) {
//                            if (idd == ownerIDMsg.get(g)) {
//                                String w = MSGINFO.get(g);
//                                Label k = new Label();
//                                k.setText(w);
//                                vboxmsg.getChildren().add(k);
//
//                            }
//
//                        }


                    });


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        contentarea.getChildren().removeAll();


    }
    @FXML
    private JFXButton homepage;
    public void homepage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RestaurantOwnerBigPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) homepage.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void trending(ActionEvent event) {
    }

    public void genreort(MouseEvent mouseEvent) {
        message.setVisible(false);
        reportAnchor.setVisible(true);
        contentarea.setVisible(false);
    }

    public void allrestaurant(ActionEvent event) throws Exception {
        FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition1.setFromValue(0.15);
        fadeTransition1.setToValue(0);
        fadeTransition1.play();

        fadeTransition1.setOnFinished(event1 -> {
            pane1.setVisible(false);
        });


        TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition1.setByX(-600);
        translateTransition1.play();
        message.setVisible(false);
        reportAnchor.setVisible(false);
        Parent fxml = FXMLLoader.load(getClass().getResource("AllownerRes.fxml"));
        contentarea.getChildren().removeAll();
        contentarea.getChildren().setAll(fxml);
        contentarea.setVisible(true);
    }
    public void allrestaurant() throws Exception {
        message.setVisible(false);
        reportAnchor.setVisible(false);
        Parent fxml = FXMLLoader.load(getClass().getResource("AllownerRes.fxml"));
        contentarea.getChildren().removeAll();
        contentarea.getChildren().setAll(fxml);
        contentarea.setVisible(true);
    }

    public void massageclicked(MouseEvent mouseEvent) {
        message.setVisible(true);
        reportAnchor.setVisible(false);
        contentarea.setVisible(false);
    }

    public void smallClose(MouseEvent mouseEvent) {

        message.setVisible(false);
        reportAnchor.setVisible(false);
    }
    Window stage=null;
    public void getfile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file =fileChooser.showSaveDialog(stage) ;
        //fileChooser.setTitle("Open Resource File");
        System.out.println(file);
    }
    int count=1;
    @FXML
    TextField typemsg;
    @FXML ScrollPane s;
    Alert a2 = new Alert(Alert.AlertType.NONE);
    String msg;
    @FXML Button sendBUTTON;
    Alert a = new Alert(Alert.AlertType.NONE);
    public void sendMsg(MouseEvent mouseEvent) throws SQLException {

        String ownerlabel=userlabel.getText();
        if(ownerlabel=="" ||ownerlabel==" " ){
            Alert a2 = new Alert(Alert.AlertType.NONE);
            a2.setAlertType(Alert.AlertType.CONFIRMATION);
            a2.setHeaderText("you must select the manager chat to send a message  ");
            a2.show();

        }
        else if(typemsg.getText()=="type here ..." || typemsg.getText()=="" || typemsg.getText()==" " ){
            Alert a2 = new Alert(Alert.AlertType.NONE);
            a2.setAlertType(Alert.AlertType.CONFIRMATION);
            a2.setHeaderText("you must type message to send it");
            a2.show();

        }

        else{
            if(flage==false){
                Separator sep=new Separator();
                //vboxmsg.getChildren().add(sep);
                Label LAB=new Label("new message");
                sep.setStyle("-fx-border-color: red;-fx-border-style: solid none none none;");
                //ep.setStyle("-fx-border-style: solid none none none;");
                LAB.setStyle("-fx-background-color:  #ccddff;");

                vboxmsg.getChildren().add(sep);
                vboxmsg.getChildren().add(LAB);

            }

            int finalid=0;
            // Separator sep=new Separator();

            for(int k=0;k<data2.size();k++){
                if(ownerlabel==data2.get(k)){

                    msg=  typemsg.getText();

                    int id2=dataid.get(k);
                    conection conClass2=new conection();
                    Connection c2=conClass2.getConnection();
                    Statement st = c2.createStatement();
                    Statement st2=c2.createStatement();
                    String sql22="select msg_id from msgs";
                    ResultSet r3=st2.executeQuery(sql22);
                    while(r3.next()){
                        int f=r3.getInt("msg_id");
                        finalid=f;
                    }
                    finalid++;
                    st.executeUpdate("INSERT INTO msgs " + "VALUES ('"+ finalid +"','"+id2+"',1,'"+msg+"')");
                    c2.close();
                    typemsg.setText("");
                    Label l=new Label();

                    l.setText(msg);
                    vboxmsg.getChildren().add(l);
                    flage=true;


//                   Alert a2 = new Alert(Alert.AlertType.NONE);
//                   a2.setAlertType(Alert.AlertType.CONFIRMATION);
//                   a2.setHeaderText("send sucsses");
//                   a2.show();


                    count++;

                }
            }


        }
    }

    public void smallClose2(MouseEvent mouseEvent) {
        message.setVisible(false);
        reportAnchor.setVisible(false);
    }

    public void getReport(MouseEvent mouseEvent) {
        if(ResSelected.getText()=="" ||ResSelected.getText()==" " ||ResSelected.getText()==null){
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("you must select a valid Restaurant ");
            a.show();
        }
        else{
            // report code => get report by restaurant name from => ResSelected.getText()

        }
    }

    public void myListMouusClicked(MouseEvent mouseEvent) {
    }

    public void searchTextKey(KeyEvent keyEvent) {
    }

    public void onactionsearch(ActionEvent event) {
    }

    public void searchhandel(MouseEvent mouseEvent) {
        t=text.getText();
        ObservableList<String> namesss = FXCollections.observableArrayList();
        for(int i=0;i<names.size();i++){
            if(t==names.get(i)){
                namesss.add(t);
                listRes.setItems(namesss);

            }
            else{

                listRes.setItems(names);

            }
        }

    }
}
