package com.company;

//region import
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//endregion

public class SecondStage extends Application{
    private static final double SECONSTAGEWIDTH = 200;
    private static final double SECONDSTAGEHEIGHT = 100;
    Stage secondStage;
    Text score = new Text("0");
    Text gameOver = new Text();

    public SecondStage() {
        secondStage = new Stage();
    }

    @Override
    public void start(Stage stage) throws Exception {
        secondStage.setWidth(SECONSTAGEWIDTH);
        secondStage.setHeight(SECONDSTAGEHEIGHT);
        secondStage.setX(0);
        secondStage.setY(0);
        score.setText("000000000");
        StackPane root = new StackPane(score, gameOver);
        Scene scene = new Scene(root);
        secondStage.setScene(scene);
        secondStage.show();
    }
}
