package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas. *;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import javafx.scene.shape.*;
import javafx.scene.control.ListView;

import java.awt.*;
import java.util.Date;
//import java.awt.Canvas;

public class Main extends Application {

    ListView<String> listview;


    @Override
    public void start(Stage primaryStage) throws Exception{

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Clock");
        Group group = new Group();
        Canvas canvas=new Canvas(500,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Line gc_hour = new Line(250,250,250,170);
        gc_hour.setStroke(Color.BLUE);
        Circle circle_second = new Circle(6);
        circle_second.setStroke(Color.RED);
        circle_second.setFill(Color.RED);
        circle_second.setCenterY(140);
        circle_second.setCenterX(250);
        Circle circle_minutes = new Circle(7);
        circle_minutes.setCenterX(250);
        circle_minutes.setCenterY(140);
        circle_minutes.setFill(Color.ORANGE);
        circle_minutes.setFill(Color.ORANGE);
        Circle circle_hours = new Circle(8);
        circle_hours.setCenterX(250);
        circle_hours.setCenterY(140);
        circle_hours.setFill(Color.BLUE);
        circle_hours.setFill(Color.BLUE);
        Label twelve = new Label("12");
        drawShapes(gc);
        group.getChildren().add(canvas);
       // group.getChildren().add(gc_hour);
        group.getChildren().add(circle_second);
        group.getChildren().add(circle_minutes);
        group.getChildren().add(circle_hours);
        Date data = new Date();
        Circle cir = new Circle(100);
        cir.setCenterX(250);
        cir.setCenterY(250);
        PathTransition pl = new PathTransition();
        pl.setNode(circle_second);
        pl.setPath(cir);
        pl.setDuration(Duration.seconds(60));
        pl.setAutoReverse(false);
        pl.setCycleCount(Animation.INDEFINITE);
        pl.play();
        long getseconds = data.getSeconds();
        pl.jumpTo(Duration.seconds(getseconds));
        Circle cir2 = new Circle(90);
        cir2.setCenterX(250);
        cir2.setCenterY(250);
        PathTransition pl2 = new PathTransition();
        pl2.setNode(circle_minutes);
        pl2.setPath(cir2);
        pl2.setDuration(Duration.minutes(60));
        pl2.setAutoReverse(false);
        pl2.setCycleCount(Animation.INDEFINITE);
        pl2.play();
        long getminutes = data.getMinutes();
        pl2.jumpTo(Duration.minutes(getminutes));
        Circle cir3 = new Circle(75);
        cir3.setCenterX(250);
        cir3.setCenterY(250);
        PathTransition pl3 = new PathTransition();
        pl3.setNode(circle_hours);
        pl3.setPath(cir3);
        pl3.setDuration(Duration.hours(12));
        pl3.setAutoReverse(false);
        pl3.setCycleCount(Animation.INDEFINITE);
        pl3.play();
        long gethours = data.getHours();
        pl3.jumpTo(Duration.hours(gethours%12));

        listview = new ListView<>();
        listview.getItems().addAll( "00:25","06:23","07:00","07:26","07:58","08:00","11:11");
        String firstalarm = listview.getItems().get(0);
        System.out.println(firstalarm);
        //listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        group.getChildren().addAll(listview);
        listview.setLayoutX(430);
        listview.setLayoutY(50);

        primaryStage.setScene(new Scene(group,500,500));
        primaryStage.show();
    }
    private void drawShapes(GraphicsContext gc)
    {

        gc.setStroke(Color.GREEN);
        gc.strokeOval(100, 100, 300, 300);
        gc.strokeOval(250,250,5,5);
        gc.strokeLine(250, 100, 250, 120);
        gc.strokeLine(250, 400, 250, 380);
        gc.strokeLine(100, 250, 120, 250);
        gc.strokeLine(400,250,380,250);
        gc.strokeLine(340,130,325,145);
        gc.strokeLine(381,175,360,190);
        gc.strokeLine(378,330,360,320);
        gc.strokeLine(324,384,314,360);
        gc.strokeLine(157,130,170,145);
        gc.strokeLine(120,175,138,190);
        gc.strokeLine(120,325,145,315);
        gc.strokeLine(180,384,193,360);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(360,225,360,267);
        gc.strokeLine(370,225,390,225);
        gc.strokeLine(370,267,390,267);
        gc.strokeLine(390,225,390,246);
        gc.strokeLine(370,246,390,246);
        gc.strokeLine(370,246,370,267);
        gc.strokeLine(130,225,130,267);
        gc.strokeLine(150,246,150,267);
        gc.strokeLine(130,267,150,267);
        gc.strokeLine(130,246,150,246);
        gc.strokeLine(130,225,150,225);
        gc.strokeLine(240,130,260,130);
        gc.strokeLine(240,151,260,151);
        gc.strokeLine(240,172,260,172);
        gc.strokeLine(260,130,260,172);
        gc.strokeLine(240,130,240,151);
        gc.strokeLine(240,370,260,370);
        gc.strokeLine(240,349,260,349);
        gc.strokeLine(240,328,260,328);
        gc.strokeLine(260,328,260,370);
    }



    public static void main(String[] args)
    {
        launch(args);
    }
}
