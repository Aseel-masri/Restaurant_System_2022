package myproject.software.restaurants_rating_2022;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CommentController {

    @FXML
    private Label AuthorEmail;

    @FXML
    private TextArea Comment_Content;

    @FXML
    private Label Day_Time;



    private Comment comment;

    public void setDate(Comment comment){
        this.comment=comment;
        Day_Time.setText(comment.getDay_Date());
        AuthorEmail.setText(comment.getAuthorEmail());
        Comment_Content.setText(comment.getText());



    }
}
