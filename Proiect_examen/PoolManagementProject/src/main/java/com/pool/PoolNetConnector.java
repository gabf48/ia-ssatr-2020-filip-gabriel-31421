/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class PoolNetConnector{

    PoolService pService;

    public PoolNetConnector() throws ClassNotFoundException, SQLException {
        pService = new PoolService();
    }

    public void startServer() {

        try {

            ServerSocket ss = new ServerSocket(4050);

            while (true) {
                System.out.println("Astept conexiune la client...");
                try (Socket s = ss.accept()) {
                    System.out.println("Clientul s-a conectat!");
                    BufferedReader fluxIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    PrintWriter fluxOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                    String line = "";
                    //  while(!line.equals("close connection")){
                    String nume = fluxIn.readLine();
                    String result = pService.customerManagement(nume);
                    fluxOut.println(result);
                    //         }
                }
            }
        } catch (IOException | SQLException e) {
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PoolNetConnector netCon = new PoolNetConnector();
        netCon.startServer();

    }

}
