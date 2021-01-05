/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ex6;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author Gabriel
 */
public class Client {
    
public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Ma conectez la server.");
        Socket s = new Socket("127.0.0.1", 4050);
        System.out.println("Conexiune realizata!");
        //......
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

        fluxOut.println("CJ 11 ABC");
        String response = fluxIn.readLine();
        System.out.println(response);

        fluxOut.println("CJ 11 AbC");
        response = fluxIn.readLine();
        System.out.println(response);

        fluxOut.println("CJ 11 AAA");
        response = fluxIn.readLine();
        System.out.println(response);

        fluxOut.println("CJ 11 ABB");
        response = fluxIn.readLine();
        System.out.println(response);
        Thread.sleep(5000);

        fluxOut.println("CJ 11 ABC");
        response = fluxIn.readLine();
        System.out.println(response);
        Thread.sleep(5000);

        fluxOut.println("CJ 11 ABB");
        response = fluxIn.readLine();
        System.out.println(response);

        fluxOut.println("close connection");
        response = fluxIn.readLine();
        System.out.println(response);


        s.close();

    }
}

