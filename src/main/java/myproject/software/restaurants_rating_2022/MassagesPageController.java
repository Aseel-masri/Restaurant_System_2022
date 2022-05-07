package myproject.software.restaurants_rating_2022;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MassagesPageController {
    @FXML
    AnchorPane message;
    @FXML AnchorPane reportAnchor;
//    public void smallClose2(MouseEvent mouseEvent) {
//        message.setVisible(false);
//        reportAnchor.setVisible(false);
//        //flage=false;
//    }

    public void smallClose(MouseEvent mouseEvent) {
        message.setVisible(false);
        reportAnchor.setVisible(false);
        //flage=false;
    }

    public void getfile(ActionEvent event) {
    }

    public void sendMsg(MouseEvent mouseEvent) {
    }
}
