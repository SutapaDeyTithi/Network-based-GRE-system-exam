/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.exam.pkg101;

import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;




import java.util.ArrayList;
import java.util.Collections;


public class FXMLDocumentController implements Initializable {

    NetworkUtil nc_student = LoginscreenController.nc_socket;

    int[] ans = new int[100];
    int[] ans_no = new int[100];
    int[] random_num = new int[100];
    int[] q_no = new int[100];
    static int c=0;
    static int time_over_marks = 0;
    static int[] std_ans=new int[100];
    public static int z=0;
    public static boolean cond=true;
//    boolean op_cond1 = true;
//    boolean op_cond2 = true;
//    boolean op_cond3 = true;
    private OnlineExam101 main;
    private LoginscreenController info;
    private int minute;
    private int hour;
    private int second;

    @FXML
    private Button logOut;
    @FXML
    private Label q1;

    @FXML
    private Label q1op1;

    @FXML
    private Label q2op2;

    @FXML
    private Label q1op2;

    @FXML
    private Label q2;

    @FXML
    private Label q2op3;

    @FXML
    private Label q1op3;

    @FXML
    private Label q2op4;

    @FXML
    private Label q1op4;

    @FXML
    private Button submit;

    @FXML
    private ToggleGroup b1_group;

    @FXML
    private RadioButton b1op4;

    @FXML
    private ToggleGroup b2_group;

    @FXML
    private RadioButton b2op2;

    @FXML
    private RadioButton b1op1;

    @FXML
    private RadioButton b2op1;

    @FXML
    private RadioButton b1op2;

    @FXML
    private RadioButton b2op4;

    @FXML
    private Label q2op1;

    @FXML
    private RadioButton b1op3;

    @FXML
    private RadioButton b2op3;
    @FXML
    private TextField exam_name;
    @FXML
    private Button get_exam;
    @FXML
    private Label score;
    @FXML
    private Button next;
    public int i=0;
    @FXML
    public Label countDown;
    public static boolean again = false;//starting again

    @FXML
    private ToggleGroup b3_group;
    @FXML
    private RadioButton b3op1;
    @FXML
    private RadioButton b3op2;

    @FXML
    private RadioButton b3op3;
    @FXML
    private RadioButton b3op4;
    @FXML
    private Label q3;
    @FXML
    private Label q3op1;
    @FXML
    private Label q3op2;
    @FXML
    private Label q3op3;
    @FXML
    private Label q3op4;
    @FXML
    private Label q4;
    @FXML
    private Label q4op1;
    @FXML
    private Label q4op2;
    @FXML
    private Label q4op3;
    @FXML
    private Label q4op4;
    @FXML
    private RadioButton b4op1;
    @FXML
    private RadioButton b4op2;

    @FXML
    private RadioButton b4op3;
    @FXML
    private RadioButton b4op4;
    @FXML
    private Label q6;
    @FXML
    private Label q6op1;
    @FXML
    private Label q6op2;
    @FXML
    private Label q6op3;
    @FXML
    private Label q6op4;
    @FXML
    private RadioButton b6op1;
    @FXML
    private RadioButton b6op2;

    @FXML
    private RadioButton b6op3;
    @FXML
    private RadioButton b6op4;
    @FXML
    private Label q7;
    @FXML
    private Label q7op1;
    @FXML
    private Label q7op2;
    @FXML
    private Label q7op3;
    @FXML
    private Label q7op4;
    @FXML
    private RadioButton b7op1;
    @FXML
    private RadioButton b7op2;

    @FXML
    private RadioButton b7op3;
    @FXML
    private RadioButton b7op4;
    @FXML
    private Label q8;
    @FXML
    private Label q8op1;
    @FXML
    private Label q8op2;
    @FXML
    private Label q8op3;
    @FXML
    private Label q8op4;
    @FXML
    private RadioButton b8op1;
    @FXML
    private RadioButton b8op2;

    @FXML
    private RadioButton b8op3;
    @FXML
    private RadioButton b8op4;
    @FXML
    private Label q9;
    @FXML
    private Label q9op1;
    @FXML
    private Label q9op2;
    @FXML
    private Label q9op3;
    @FXML
    private Label q9op4;
    @FXML
    private RadioButton b9op1;
    @FXML
    private RadioButton b9op2;

    @FXML
    private RadioButton b9op3;
    @FXML
    private RadioButton b9op4;
    @FXML
    private Label q10;
    @FXML
    private Label q10op1;
    @FXML
    private Label q10op2;
    @FXML
    private Label q10op3;
    @FXML
    private Label q10op4;
    @FXML
    private RadioButton b10op1;
    @FXML
    private RadioButton b10op2;

    @FXML
    private RadioButton b10op3;
    @FXML
    private RadioButton b10op4;
    @FXML
    private Label q5;
    @FXML
    private Label q5op1;
    @FXML
    private Label q5op2;
    @FXML
    private Label q5op3;
    @FXML
    private Label q5op4;
    @FXML
    private RadioButton b5op1;
    @FXML
    private RadioButton b5op2;

    @FXML
    private RadioButton b5op3;
    @FXML
    private RadioButton b5op4;
    @FXML
    private Button eng;
    @FXML
    private Button new_exam;
    public static boolean t_or_sub;
    public static int score_konta;

    @FXML
    private LineChart<?,?> LineChart;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private RadioButton sub1;
    @FXML
    private RadioButton sub2;
    @FXML
    private Label subName1;
    @FXML
    private Label subName2;
    //public static boolean t_or_sub;
    //public static int score_konta;
    public static String examName;
    private static boolean op = false;
    @FXML
    void option_clicked(ActionEvent event){
        if(sub1.isSelected()){
            examName = subName1.getText();
            op = true;
        }
        else if(sub2.isSelected()){
            examName = subName2.getText();
            op = true;
        }
        op = true;
    }

    @FXML
    void submit_clicked(ActionEvent event) throws IOException {
        for(int k=0;k<10;k++)
            if(std_ans[ans_no[k]]==ans[k]){
                c++;
                System.out.println("barlo");
            }
        if(t_or_sub==true || again==true) {
            try {
                score_konta=1;
                main.showScoreBoard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t_or_sub = false;
        score_konta=1;//submit
        again=false;


    }
    public void time_over() throws IOException {
        score_konta = 2;//timeup

        for(int k=0;k<3;k++)
            if(std_ans[ans_no[k]]==ans[k]){
                time_over_marks++;
            }

        if(t_or_sub==false){
            try {
                main.showScoreBoard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void get_score_clicked(ActionEvent event) throws IOException
    {
        String fname =info.getUser()+ info.getPass()+".txt";
        FileWriter f = new FileWriter(fname, true);

        if(score_konta==1) {
            score.setText("your score is " + c + " \n");
            String s=c+"&";
            f.write(s);
            f.flush();
            f.close();
        }
        else if(score_konta==2)
        { score.setText("Your score is "+time_over_marks+" \n");
            String s=time_over_marks+"&";
            f.write(s);
            f.flush();
            f.close();
        }
    }

    @FXML
    void radio_button_clicked1(ActionEvent event) {
        if (b1op1.isSelected()) {
            ans[0] = 1;
        }
        if (b1op2.isSelected()) {
            ans[0] = 2;
        }
        if (b1op3.isSelected()) {
            ans[0] = 3;
        }
        if (b1op4.isSelected()) {
            ans[0] = 4;
        }
    }
    @FXML
    void radio_button_clicked2(ActionEvent event) {

        if (b2op1.isSelected()) {
            ans[1] = 1;
        }
        if (b2op2.isSelected()) {
            ans[1] = 2;
        }
        if (b2op3.isSelected()) {
            ans[1] = 3;
        }
        if (b2op4.isSelected()) {
            ans[1] = 4;
        }
    }
    @FXML
    void radio_button_clicked3(ActionEvent event) {

        if (b3op1.isSelected()) {
            ans[2] = 1;
        }
        if (b3op2.isSelected()) {
            ans[2] = 2;
        }
        if (b3op3.isSelected()) {
            ans[2] = 3;
        }
        if (b3op4.isSelected()) {
            ans[2] = 4;

        }
    }
    @FXML
    void radio_button_clicked4(ActionEvent event) {

        if (b4op1.isSelected()) {
            ans[3] = 1;
        }
        if (b4op2.isSelected()) {
            ans[3] = 2;
        }
        if (b4op3.isSelected()) {
            ans[3] = 3;
        }
        if (b4op4.isSelected()) {
            ans[3] = 4;

        }
    }
    @FXML
    void radio_button_clicked5(ActionEvent event) {
        if (b5op1.isSelected()) {
            ans[4] = 1;
        }
        if (b5op2.isSelected()) {
            ans[4] = 2;
        }
        if (b5op3.isSelected()) {
            ans[4] = 3;
        }
        if (b5op4.isSelected()) {
            ans[4] = 4;
        }
    }
    @FXML
    void radio_button_clicked6(ActionEvent event) {
        if (b6op1.isSelected()) {
            ans[5] = 1;
        }
        if (b6op2.isSelected()) {
            ans[5] = 2;
        }
        if (b6op3.isSelected()) {
            ans[5] = 3;
        }
        if (b6op4.isSelected()) {
            ans[5] = 4;
        }
    }
    @FXML
    void radio_button_clicked7(ActionEvent event) {
        if (b7op1.isSelected()) {
            ans[6] = 1;
        }
        if (b7op2.isSelected()) {
            ans[6] = 2;
        }
        if (b7op3.isSelected()) {
            ans[6] = 3;
        }
        if (b7op4.isSelected()) {
            ans[6] = 4;
        }
    }
    @FXML
    void radio_button_clicked8(ActionEvent event) {
        if (b8op1.isSelected()) {
            ans[7] = 1;
        }
        if (b8op2.isSelected()) {
            ans[7] = 2;
        }
        if (b8op3.isSelected()) {
            ans[7] = 3;
        }
        if (b8op4.isSelected()) {
            ans[7] = 4;
        }
    }
    @FXML
    void radio_button_clicked9(ActionEvent event) {
        if (b9op1.isSelected()) {
            ans[8] = 1;
        }
        if (b9op2.isSelected()) {
            ans[8] = 2;
        }
        if (b9op3.isSelected()) {
            ans[8] = 3;
        }
        if (b9op4.isSelected()) {
            ans[8] = 4;
        }
    }
    @FXML
    void radio_button_clicked10(ActionEvent event) {
        if (b10op1.isSelected()) {
            ans[9] = 1;
        }
        if (b10op2.isSelected()) {
            ans[9] = 2;
        }
        if (b10op3.isSelected()) {
            ans[9] = 3;
        }
        if (b10op4.isSelected()) {
            ans[9] = 4;
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nc_student = LoginscreenController.nc_socket;

//        try {
//            Socket sock = new Socket("localhost",3333) ;
        //      System.out.println(nc_student);

//            sock.close();
//        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//      score.setText("your score is"+c+"/1");

    }

    @FXML
    private void b1_clicked(javafx.scene.input.MouseEvent event) {
    }
    @FXML
    public void previous_clicked(ActionEvent event)throws IOException{
        FileReader f=null;
        String fname =info.getUser()+ info.getPass()+".txt";
        f = new FileReader(fname);

        char[] buff = new char[1000];
        int size = f.read(buff);
        String full=new String(buff,0,size);
        int z=0;
        String uName=new String();
        String pWord = new String();
        int marks[] = new int[100];
        StringTokenizer tokens=new StringTokenizer(full,"&");
        uName= tokens.nextToken();
        pWord = tokens.nextToken();
        while(tokens.hasMoreTokens())
        {
            marks[z] = Integer.parseInt(tokens.nextToken());
            z++;
        }

        try {
            //main.showPreScore();
            Stage stage = new Stage();
            x = new NumberAxis();
            y = new NumberAxis();
            LineChart = new LineChart<Number,Number>(x,y);
            LineChart.setTitle("Progress");
            XYChart.Series series = new XYChart.Series();
            series.setName(info.getUser());
            for (int i=0;i<z;i++)
                series.getData().add(new XYChart.Data(i+1,marks[i]));
            Scene scene = new Scene(LineChart,689,686);
            LineChart.getData().addAll(series);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public  void new_exam_clicked(ActionEvent event)throws IOException{
        try {

            main.showQuizPage();
            t_or_sub = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    public void get_exam_clicked() throws IOException {

        if(op == false)
            examName = "Math";//if op not selected, default quiz on math

        nc_student.write(examName);
        String fileString = (String) nc_student.read();
     //   System.out.println(fileString);
        data[] ob = new data[100];
        int ans[] = new int[100];
        ans[0] = 1;

        String Q1;
        for (int i = 0; i < 30; i++) {
            ob[i] = new data();
            ob[i].answer = "0";
        }
        String[] full=fileString.split("#");

        while(z<full.length && cond==true)
        {
            //System.out.println(full[z]);
            StringTokenizer tokens=new StringTokenizer(full[z],"&");

            std_ans[z]=Integer.parseInt(tokens.nextToken());
            ob[z].q = tokens.nextToken();
            ob[z].op1 = tokens.nextToken();
            ob[z].op2 = tokens.nextToken();
            ob[z].op3 = tokens.nextToken();
            ob[z].op4 = tokens.nextToken();

            z++;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<10; i++) {
            ans_no[i]=list.get(i);
            //System.out.println(std_ans[ans_no[i]]);
        }

        z=0;
        q1.setText(ob[list.get(z)].q);
        q1op1.setText(ob[list.get(z)].op1);
        q1op2.setText(ob[list.get(z)].op2);
        q1op3.setText(ob[list.get(z)].op3);
        q1op4.setText(ob[list.get(z)].op4);

        q2.setText(ob[list.get(z+1)].q);
        q2op1.setText(ob[list.get(z+1)].op1);
        q2op2.setText(ob[list.get(z+1)].op2);
        q2op3.setText(ob[list.get(z+1)].op3);
        q2op4.setText(ob[list.get(z+1)].op4);

        q3.setText(ob[list.get(z+2)].q);
        q3op1.setText(ob[list.get(z+2)].op1);
        q3op2.setText(ob[list.get(z+2)].op2);
        q3op3.setText(ob[list.get(z+2)].op3);
        q3op4.setText(ob[list.get(z+2)].op4);

        q4.setText(ob[list.get(z+3)].q);
        q4op1.setText(ob[list.get(z+3)].op1);
        q4op2.setText(ob[list.get(z+3)].op2);
        q4op3.setText(ob[list.get(z+3)].op3);
        q4op4.setText(ob[list.get(z+3)].op4);

        q5.setText(ob[list.get(z+4)].q);
        q5op1.setText(ob[list.get(z+4)].op1);
        q5op2.setText(ob[list.get(z+4)].op2);
        q5op3.setText(ob[list.get(z+4)].op3);
        q5op4.setText(ob[list.get(z+4)].op4);

        q6.setText(ob[list.get(z+5)].q);
        q6op1.setText(ob[list.get(z+5)].op1);
        q6op2.setText(ob[list.get(z+5)].op2);
        q6op3.setText(ob[list.get(z+5)].op3);
        q6op4.setText(ob[list.get(z+5)].op4);

        q7.setText(ob[list.get(z+6)].q);
        q7op1.setText(ob[list.get(z+6)].op1);
        q7op2.setText(ob[list.get(z+6)].op2);
        q7op3.setText(ob[list.get(z+6)].op3);
        q7op4.setText(ob[list.get(z+6)].op4);

        q8.setText(ob[list.get(z+7)].q);
        q8op1.setText(ob[list.get(z+7)].op1);
        q8op2.setText(ob[list.get(z+7)].op2);
        q8op3.setText(ob[list.get(z+7)].op3);
        q8op4.setText(ob[list.get(z+7)].op4);

        q9.setText(ob[list.get(z+8)].q);
        q9op1.setText(ob[list.get(z+8)].op1);
        q9op2.setText(ob[list.get(z+8)].op2);
        q9op3.setText(ob[list.get(z+8)].op3);
        q9op4.setText(ob[list.get(z+8)].op4);

        q10.setText(ob[list.get(z+9)].q);
        q10op1.setText(ob[list.get(z+9)].op1);
        q10op2.setText(ob[list.get(z+9)].op2);
        q10op3.setText(ob[list.get(z+9)].op3);
        q10op4.setText(ob[list.get(z+9)].op4);
    }
    @FXML
    void logoutAction(ActionEvent event) {
        main.start = true;
        again=true;
        c=0;
        time_over_marks=0;
        try {
            //nc_student.closeConnection();

            //info.nc_socket = new NetworkUtil("localhost", 3350);
            main.showLoginPage();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void setMain(OnlineExam101 main)
    {

        this.main=main;
    }
//@FXML
//    public void initia() {
//
//        Thread clock = new Thread() {
//            public void run() {
//                for (int i=0;i<120;i++) {
//                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
//                    Calendar cal = Calendar.getInstance();
//
//                    second = cal.get(Calendar.SECOND);
//                    minute = cal.get(Calendar.MINUTE);
//                    hour = cal.get(Calendar.HOUR);
//                    System.out.println(hour + ":" + (minute) + ":" + second);
//                   // countDown.setText(hour + ":" + (minute) + ":" + second);
//                    final int k = second;
//                    if(second)
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException ex) {
//                        //...
//                    }
//                }
//            }
//        };
//        clock.start();
//    }

}
