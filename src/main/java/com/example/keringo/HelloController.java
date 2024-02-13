package com.example.keringo;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML private Pane pnJatek;
    @FXML private Button ptButton;
    @FXML private Slider sdSpeed;
    @FXML private Slider sdRadius;
    @FXML private Label lbSpeed;
    @FXML private Label lbRadius;



    private ImageView ivBall = new ImageView(new Image(getClass().getResourceAsStream("ball1.png")));

    private AnimationTimer timer;
    private boolean run=false;
    private int alfa =0;

    public void initialize(){
        pnJatek.setClip(new Rectangle(600,600));
        lbSpeed.textProperty().bind(Bindings.format("Speed: %0.f",sdSpeed.valueProperty()));
        lbRadius.textProperty().bind(Bindings.format("Radius: %0.f",sdRadius.valueProperty()));
        ivBall.setLayoutX(500-32);
        ivBall.setLayoutY(300-32);
        Circle kor = new Circle(300,300,200, Color.LIGHTGREEN);
        pnJatek.getChildren().add(kor);
        pnJatek.getChildren().add(ivBall);
        timer=new AnimationTimer(){
            @Override
            public void handle(long now){
                mozgat();
            }
        };

    }

    private void mozgat(){
        int r= (int)sdRadius.getValue();
        int x = 300 +(int)(r* Math.cos(alfa*3.14/180));
        int y = 300 -(int)(r* Math.cos(alfa*3.14/180));
        ivBall.setLayoutX(x-32);
        ivBall.setLayoutY(y-32);
        int speed=(int)sdSpeed.getValue();
        alfa+=speed;
    }

    @FXML private void onButtonClick(){
        if (run==false){
            timer.start();
            ptButton.setText("Stop");
            run = true;
        }else{
            timer.stop();
            ptButton.setText("Start");
            run = false;
        }

    }

    @FXML private void onKep1Click(){
        ivBall.setImage(new Image(getClass().getResourceAsStream("ball1.png")));
    }
    @FXML private void onKep2Click(){
        ivBall.setImage(new Image(getClass().getResourceAsStream("ball1.png")));
    }


}