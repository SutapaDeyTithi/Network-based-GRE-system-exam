/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.pkg101;

//import java.awt.event.ActionEvent;
//import java.beans.EventHandler;
import java.net.Socket;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import sample.Controller;
import sun.rmi.log.LogInputStream;

import static online.exam.pkg101.FXMLDocumentController.score_konta;
import static online.exam.pkg101.FXMLDocumentController.t_or_sub;


public class OnlineExam101 extends Application {
    Stage stage;
    private final Integer startTime = 120;
    private Integer seconds;
    public static boolean start = false;
    public static boolean timeover = false;
    private int minute;
    private int hour;
    private int second;


//    public static NetworkUtil nc_socket = new NetworkUtil("localhost", 3365);
    @Override
    public void start(Stage primaryStage) throws Exception{
        if(start == false)
        {
            stage = primaryStage;
            showLoginPage();
        }
    }


    public void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("loginscreen.fxml"));
        Parent root = loader.load();

        LoginscreenController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("Log In Page");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showMenuPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();

        FXMLDocumentController controller = loader.getController();
        controller.setMain(this);

        stage.setScene(new Scene(root));
        stage.setTitle("Menu Page");
        stage.show();
    }
    public void showQuizPage() throws Exception {
        // XML Loading using FXMLLoader
       // System.out.println("a");
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("FXMLDocument2.fxml"));
        Parent root = loader.load();


        // Loading the controller
        FXMLDocumentController controller = loader.getController();

        controller.get_exam_clicked();

        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Your Quiz");
        stage.setScene(new Scene(root));
        stage.show();
        seconds = startTime;
        doTime(controller);

    }

    private void doTime(FXMLDocumentController controller)
    {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if(time!=null)
        {
            time.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.seconds(1),new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                FXMLDocumentController docu;
                docu = controller;
                if(t_or_sub==true)
                {
                    seconds--;
                if((seconds/60)<10)
                    {
                        if ((seconds % 60) < 10)
                            controller.countDown.setText("Remaining 0" + String.valueOf(seconds / 60) + " : 0" + String.valueOf(seconds % 60));
                        else
                            controller.countDown.setText("Remaining 0" + String.valueOf(seconds / 60) + " : " + String.valueOf(seconds % 60));
                    }
                    else
                {
                    if ((seconds % 60) < 10)
                        controller.countDown.setText("Remaining " + String.valueOf(seconds / 60) + " : 0" + String.valueOf(seconds % 60));
                    else
                        controller.countDown.setText("Remaining " + String.valueOf(seconds / 60) + " : " + String.valueOf(seconds % 60));
                }

                    //                    if(seconds<10)
//                        controller.countDown.setText("Remaining 0"+ seconds.toString());
//                    else
//                        controller.countDown.setText("Remaining "+ seconds.toString());
                }
//
                if(seconds == 0)
                {
                    t_or_sub = false;
                    time.stop();
                    try{
                        //Thread.sleep(5000);
                        docu.time_over();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }


            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();



    }
    public void showScoreBoard() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Scoreboard.fxml"));
        Parent root = loader.load();

        // Loading the controller
        FXMLDocumentController controller = loader.getController();
        controller.setMain(this);
        stage.setTitle("ScoreBoard");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
