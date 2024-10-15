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
        String scelta;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Il client è partito!");
        Socket s = new Socket("localhost", 3000);
        System.out.println("Il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaInviata;
        boolean acceso = true;

        do{
            System.out.println("Quale operazione vuoi svolgere?\n");
            System.out.println("1)Trasformare una frase tutta in maiuscolo\n");
            System.out.println("2)Trasformare una frase tutta in minuscolo\n");
            System.out.println("3)Ribaltare i caratteri della frase\n");
            System.out.println("4)Contare il numero di caratteri della frase\n");
            System.out.println("0)Uscire\n");

            scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.println("Digita la frase:");
                    stringaInviata = scanner.nextLine();
                    out.writeBytes("M" + "\n");
                    if(in.readLine().equals("?")){
                        out.writeBytes(stringaInviata + "\n");
                        String stringRicevuta = in.readLine();
                        System.out.println("Risultato: " + stringRicevuta + "\n\n\n");
                    }
                    break;

                case "2":
                    System.out.println("Digita la frase:");
                    stringaInviata = scanner.nextLine();
           
                    out.writeBytes("m" + "\n");
                    if(in.readLine().equals("?")){
                        out.writeBytes(stringaInviata + "\n");
                        String stringRicevuta = in.readLine();
                        System.out.println("Risultato: " + stringRicevuta + "\n\n\n");
                    }
                    break;

                case "3":
                    System.out.println("Digita la frase:");
                    stringaInviata = scanner.nextLine();
                    out.writeBytes("r" + "\n");
                    if(in.readLine().equals("?")){
                        out.writeBytes(stringaInviata + "\n");
                        String stringRicevuta = in.readLine();
                        System.out.println("Risultato: " + stringRicevuta + "\n\n\n");
                    }
                    break;

                case "4":
                    System.out.println("Digita la frase:");
                    stringaInviata = scanner.nextLine();
                    out.writeBytes("c" + "\n");
                    if(in.readLine().equals("?")){
                        out.writeBytes(stringaInviata + "\n");
                        String stringRicevuta = in.readLine();
                        System.out.println("Risultato: " + stringRicevuta + "\n\n\n");
                    }
                    break;

                case "0":
                    out.writeBytes("!" + "\n");
                    acceso = false;
                    break;


                default:
                    out.writeBytes(scelta + "\n");
                    if(in.readLine().equals("#")){
                        System.out.println("Operazione non esistente"+ "\n\n\n");
                    }
                    break;
            }
            
            
        }while(acceso);

    }
}