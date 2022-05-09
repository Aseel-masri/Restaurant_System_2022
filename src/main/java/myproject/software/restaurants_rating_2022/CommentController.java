package myproject.software.restaurants_rating_2022;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class CommentController {

    @FXML
    private Label AuthorEmail;

    @FXML
    public TextField Comment_Content;

    @FXML
    private Label Day_Time;



    private Comment comment;

    public void setDate(Comment comment){
        this.comment=comment;
        Day_Time.setText(comment.getDay_Date());
        AuthorEmail.setText(comment.getAuthorEmail());
        Comment_Content.setText(comment.getText());
        c_id.setText(String.valueOf(comment.getid()) );



    }
    @FXML
    private Label c_id;

    @FXML
    void delete(ActionEvent event) throws SQLException {
        int id=0;
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("LoginUser.fxml"));
        LoginUserController l=fxmlLoader1.getController();
        id=l.user_id;
        if(id==0){
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("you are not logged in to delete any comments.");
            a.show();

        }
        else{
        conection c=new conection();
        Connection connection=c.getConnection();
        String sql="delete from comments where c_id='"+Integer.parseInt(c_id.getText())+"'";
        String sql1="select user_id from comments where c_id='"+Integer.parseInt(c_id.getText())+"'";
        Statement statement=connection.createStatement();
        Statement statement1=connection.createStatement();
            ResultSet r=statement1.executeQuery(sql1);
            int uid=-1;
            while (r.next()){
                uid=r.getInt("user_id");
            }
            if(uid==id){
                statement.execute(sql);
                connection.close();
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("comment deleted successfully");
                a.show();
            }
            else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("cant delete, you are not the user who posted this comment");
                a.show();
            }

    }
    }

    @FXML
    void edit(ActionEvent event) throws SQLException {
        int id=0;
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("LoginUser.fxml"));
        LoginUserController l=fxmlLoader1.getController();
        id=l.user_id;
        if(id==0){
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("you are not logged in to edit any comments.");
            a.show();

        }
        else{
        conection c=new conection();
        Connection connection=c.getConnection();
        String sql1="select user_id from comments where c_id='"+Integer.parseInt(c_id.getText())+"'";
        Statement statement=connection.createStatement();
        ResultSet r=statement.executeQuery(sql1);
        int uid=-1;
        while (r.next()){
            uid=r.getInt("user_id");
        }
        if(uid==id){
            Comment_Content.setEditable(true);
        }
        else{
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("cant edit, you are not the user who posted this comment");
            a.show();
        }

    }}

    @FXML
    void save(ActionEvent event) throws SQLException {
        int id=0;
        FXMLLoader fxmlLoader1=new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("LoginUser.fxml"));
        LoginUserController l=fxmlLoader1.getController();
        id=l.user_id;
        if(id==0){
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("you are not logged in to save any changes.");
            a.show();

        }
        else{
            conection c=new conection();
            Connection connection=c.getConnection();
            String sql1="select user_id from comments where c_id='"+Integer.parseInt(c_id.getText())+"'";
            Statement statement=connection.createStatement();
            ResultSet r=statement.executeQuery(sql1);
            int uid=-1;
            while (r.next()){
                uid=r.getInt("user_id");
            }
            if(uid==id){
                Date date= new Date();
                Calendar ca=Calendar.getInstance();
                date=ca.getTime();
                Statement statement1=connection.createStatement();
                String sql2="update comments set c_info='"+Comment_Content.getText()+"', c_date='"+date.toString()+"' where c_id='"+Integer.parseInt(c_id.getText())+"'";
                statement1.execute(sql2);
                connection.close();
                Alert a=new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("comment updated successfully.");
                a.show();
            }
            else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("nothing has been updated");
                a.show();
            }

        }
    }
}
