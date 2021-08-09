/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_exam_server;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDataThread extends Thread {

    NetworkUtil nc;


    public TeacherDataThread(NetworkUtil nc) {
        this.nc = nc;
        System.out.println(nc);
    }

    @Override
    public void run() {
        FileWriter fp = null;
        try {
            String file = (String) nc.read() + ".txt";
            fp = new FileWriter(file, true);
            String qu1 = (String) nc.read();
            fp.write(qu1);
            fp.flush();
        } catch (IOException ex) {
            Logger.getLogger(TeacherDataThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fp.close();
              //  nc.closeConnection();
            } catch (IOException ex) {
                Logger.getLogger(TeacherDataThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
