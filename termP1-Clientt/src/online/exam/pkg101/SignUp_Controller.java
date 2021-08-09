package online.exam.pkg101;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.*;
import java.net.URL;

import java.util.*;


public class SignUp_Controller implements Initializable {

    // private static ArrayList<regist>registList = new ArrayList<regist>();

    static NetworkUtil nc_student = LoginscreenController.nc_socket;

    private OnlineExam101 main;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;



    @FXML
    private Button submit;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nc_student = LoginscreenController.nc_socket;

    }

    @FXML
    void submitAction(ActionEvent event) throws Exception{
//        username.setText(null);
//        password.setText(null);
//        confirmPassword.setText(null);
        String userName = username.getText();
        String Password = password.getText();
        String confirmPass = confirmPassword.getText();
        System.out.println(confirmPass);

        FileReader reg = null;
        reg = new FileReader("reg.txt");

        char[] buff = new char[1000];
        int size = reg.read(buff);
        String full=new String(buff,0,size);
        //System.out.println(full);
        String[] person=full.split("#");

        int z=0;
        String uName[]=new String[1000];
        String pWord[] = new String[1000];
        while(z<person.length)
        {
            StringTokenizer tokens=new StringTokenizer(person[z],"&");

            uName[z]= tokens.nextToken();
            pWord[z] = tokens.nextToken();
            // System.out.println(uName[z]);
            // System.out.println(pWord[z]);
            z++;
        }
        boolean alreadyExist = false;
        for(int i=0;i<person.length;i++)
        {
            if(uName[i].equals(userName) && pWord[i].equals(Password))
            {
                alreadyExist=true;
                // System.out.println(uName[i]);
                break;
            }
        }



        try {
            if ( !(username.getText().isEmpty()) && !(password.getText().isEmpty()) && !(confirmPass.isEmpty()) && (Password.equals(confirmPass) ) && !userName.equals("t") && alreadyExist==false) {
                    FileWriter fw = new FileWriter("reg.txt", true);

                    //  System.out.println("6");
                    //System.out.println(userName + Password);
                    String new_user = userName + "&" + Password + "#";
                    fw.write(new_user);
                    fw.flush();
                    fw.close();
                    //Individual user information file where all the scores are stored

                    String fName = userName + Password + ".txt";
                    FileWriter f = null;
                    f = new FileWriter(fName, true);
                    f.write(userName + "&" +Password + "&");
                    f.flush();
                    f.close();
                    main.showLoginPage();
            }
            else if(username.getText().isEmpty() || password.getText().isEmpty() || confirmPass.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("Passwords must be identical.");
                alert.showAndWait();
            }
            else if(!(Password.equals(confirmPass))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("Passwords must be identical.");
                alert.showAndWait();
            }
            else if((userName.equals("t")) && (Password.equals("1"))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The username is not available.");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The username is not available.");
                alert.showAndWait();
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @FXML
    void backAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    void setMain( OnlineExam101 main) {
        this.main = main;
    }


}

