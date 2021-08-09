/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.pkg101;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class TeacherController implements Initializable {
    
    NetworkUtil nc_teacher = LoginscreenController.nc_socket;
    private OnlineExam101 main;
     @FXML
    private TextField q1;

    @FXML
    private TextField q1op1;

    @FXML
    private TextField q2op2;

    @FXML
    private TextField q1op2;

    @FXML
    private TextField q2;

    @FXML
    private TextField q2op3;

    @FXML
    private TextField q1op3;

    @FXML
    private TextField q2op4;

    @FXML
    private TextField q1op4;

    @FXML
    private TextField q2op1;
     @FXML
    private ScrollBar scrollbar;
    @FXML
    private Button submit;
    @FXML
    private TextField exm;
     @FXML
    private TextField ans1;
      @FXML
    private TextField ans2;
      @FXML
    private TextField exam_Name;
      @FXML
    private Button lout;


    data []ob=new data [10];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int i;
    nc_teacher = LoginscreenController.nc_socket;
    for(i=1;i<10;i++){
        ob[i]=new data();
        
    }

    }    

    @FXML
    private void submit_teacher(ActionEvent event) {
         nc_teacher.write(exam_Name.getText());
         String name,ans;
         ans="1";
         ans=ans1.getText();
         ob[0]=new data(ans+'&',q1.getText()+'&',q1op1.getText()+'&',q1op2.getText()+'&',q1op3.getText()+'&',q1op4.getText()+'#');
         nc_teacher.write((String)ob[0].toString());
    }

    void setMain(OnlineExam101 main) {
        this.main = main;
    }
    
}
