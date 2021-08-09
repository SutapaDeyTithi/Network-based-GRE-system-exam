/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.pkg101;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import static sun.security.jgss.GSSUtil.login;


public class LoginscreenController implements Initializable {

    /**
     * Initializes the controller class.
     */

    private OnlineExam101 main;
    public static String user = new String();
    public static String pass = new String();
    @FXML
    private Button sign_up;
    @FXML
    private PasswordField password;

    @FXML
    private Label user_label;

    @FXML
    private Label not_match;
    @FXML
    private Label password_label;

    @FXML
    private Button login;
    @FXML
    private Button Reset;
    @FXML
    private  Button prev_score;

    @FXML
    private TextField username;

    @FXML
    void username_text(ActionEvent event) {

    }

    @FXML
    void password_text(ActionEvent event) {

    }
    public static NetworkUtil nc_socket;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void login_clicked(ActionEvent event) throws IOException {
        nc_socket = new NetworkUtil("localhost", 3365);
        FileReader f = null;
        user = new String(username.getText());
        pass = new String(password.getText());
        f = new FileReader("reg.txt");

        char[] buff = new char[1000];
        int size = f.read(buff);
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
        boolean flag = false;
        for(int i=0;i<person.length;i++)
        {
            if(uName[i].equals(user) && pWord[i].equals(pass))
            {
                flag=true;
               // System.out.println(uName[i]);
                break;
            }
        }


        if (flag==true) {
            //nc_socket = new NetworkUtil("localhost", 3352);
            nc_socket.write("student");
            try {
                main.showMenuPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (pass.equals("1") && user.equals("t")) {
            nc_socket.write("teacher");
            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("teacher.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } else {
            // failed login
            nc_socket.write("Failed Login!");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }
    }

    @FXML
    void resetAction(ActionEvent event) {
        username.setText(null);
        password.setText(null);
    }
    @FXML
    public void sign_up_clicked (ActionEvent event) throws IOException
    {

        Stage stage = (Stage) sign_up.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SignUp_Controller controller = loader.getController();
        controller.setMain(main);
        stage.setTitle("Registration Page");
        stage.setScene(new Scene(root));
        stage.show();
    }
    void setMain(OnlineExam101 main) {
        this.main = main;
    }

    public static String getPass() {
        return pass;
    }

    public static String getUser() {
        return user;
    }
}
