package com.company;

//region import
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//endregion

public class SecondStage extends Application{
    private static final double SECONSTAGEWIDTH = 200;
    private static final double SECONDSTAGEHEIGHT = 100;
    private static final int POINTSFORITERATION = 100;
    Stage secondStage;
    int points;
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
        score.setText("");
        VBox vb = new VBox(score, gameOver);
        Scene scene = new Scene(vb);
        secondStage.setScene(scene);
        secondStage.show();
        vb.setAlignment(Pos.CENTER);
    }

    public void setScore() {
        points = points + POINTSFORITERATION;
        score.setText(String.valueOf(points));
    }

    public void setGameOver() {
        gameOver.setText("GAMEOVER");
    }
}
