package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        String stringaInviata = scanner.nextLine();
        out.writeBytes(stringaInviata + "\n");

        String stringRicevuta = in.readLine();
        System.out.println(stringRicevuta);

        s.close();
    }
}