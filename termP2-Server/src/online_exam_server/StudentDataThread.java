/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_exam_server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentDataThread extends Thread{
    NetworkUtil nc;
    String name;

    public StudentDataThread(NetworkUtil nc) {
        this.nc = nc;
    }

    @Override
    public void run() {

            FileReader f = null;
            try {

                String filename = (String) nc.read() + ".txt";
                System.out.println(filename + " eitai ");
                f = new FileReader(filename);

                char[] buff = new char[10000];
                int size = f.read(buff);
                String full = new String(buff, 0, size);
                System.out.println(full);
                System.out.println(nc);
                nc.write(full);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentDataThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentDataThread.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    f.close();
                    // nc.closeConnection();
                } catch (IOException ex) {
                    Logger.getLogger(StudentDataThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    
    
}
