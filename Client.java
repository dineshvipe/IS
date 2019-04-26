/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cse
 */

public class Client {
public static void main(String[] args) throws IOException {
try{ Scanner sc = new Scanner(System.in);
    InetAddress ip = InetAddress.getByName("localhost");
Socket s = new Socket(ip, 5056);
    DataInputStream dis = new DataInputStream(s.getInputStream());
    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
System.out.println("Received value of P and G...");
int P=Integer.parseInt(dis.readUTF());
int G=Integer.parseInt(dis.readUTF());
Random rand = new Random();
int Xb = (int)(Math.random()*(P-1)+1); 
        int Yb=((int)Math.pow(G,Xb))%P;
        System.out.println("Sendinf to Party A...");
        dos.writeUTF(String.valueOf(Yb));
        String Ya = dis.readUTF();
        System.out.println("Receiving from Party B...");
        int Secret_Key=((int)Math.pow(Integer.parseInt(Ya),Xb))%P;
        System.out.println("Secret Key : "+Secret_Key);
dis.close();
dos.close();
}catch(Exception e){
e.printStackTrace(); } } }