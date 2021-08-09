/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online_exam_server;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class server {

    public static void main(String[] args) throws ClassNotFoundException, java.net.SocketException {
        try {
            ServerSocket servsock = new ServerSocket(3365);


            while (true) {

                data a = new data();
                Socket client_sock = servsock.accept();
                NetworkUtil nc = new NetworkUtil(client_sock);


                System.out.println(nc);
                String t_or_s = (String ) nc.read();
                System.out.println(t_or_s);

             //    a=(data) nc.read();
                if (t_or_s.equals("teacher")) {
                    new TeacherDataThread(nc).start();
                } else if(t_or_s.equals("student"))
                {

                    new StudentDataThread(nc).start();

                 }

            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
