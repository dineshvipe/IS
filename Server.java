/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

/**
 *
 * @author cse
 */
public class Server
{ 
static int  VALIDATION(int P,int G){
    ArrayList<Integer> aa=new ArrayList<Integer>();
    int j=0;
    for(int i=1;i<P;i++){
      int a=(int)Math.pow(G,i)%P; 
      aa.add(a);
    }
    int i;
    for(i=1;i<P;i++){
        if(aa.contains(i)==false)
            return 0;
        int g=aa.indexOf(i);
        aa.remove(g);
    }
    
        return 1;
    
    
}
public static void main(String[] args) throws IOException
{ Scanner sc=new Scanner(System.in);
    ServerSocket ss = new ServerSocket(5056);

 Socket s = null;
try{ s = ss.accept();
int p=0,g=0;
while(true){
System.out.println("Enter the value of P and G: ");
p=sc.nextInt();
g=sc.nextInt();
int dg=VALIDATION(p,g);
if(dg==1 && p>g)
    break;
}
DataInputStream dis = new DataInputStream(s.getInputStream());
 DataOutputStream dos = new DataOutputStream(s.getOutputStream());
Thread t = new Handler(s, dis, dos,p,g);
t.start(); }
catch (Exception e){
s.close();
e.printStackTrace(); }
 } }

class Handler extends Thread

{ 
    int flag=0;
    final DataInputStream dis;
final DataOutputStream dos;
final Socket s;
final int P,G;
public Handler(Socket s, DataInputStream dis, DataOutputStream dos,int p,int g)
        { this.s = s;
this.dis = dis;
this.dos = dos;
        this.P=p;
        G=g;}


@Override
public void run()
{ 

    try { 
        
        dos.writeUTF(String.valueOf(P));
        dos.writeUTF(String.valueOf(G));
        System.out.println("Cal Exponential...");
        Random rand = new Random();
        int Xa = (int)(Math.random()*(P-1)+1); 
        int Ya=((int)Math.pow(G,Xa))%P;
        System.out.println("Sendinf to Party B...");
        dos.writeUTF(String.valueOf(Ya));
        String Yb = dis.readUTF();
        System.out.println("Receiving from Party B...");
        int Secret_Key=((int)Math.pow(Integer.parseInt(Yb),Xa))%P;
        System.out.println("Secret Key : "+Secret_Key);
    

 
    }catch (IOException e) {
e.printStackTrace(); } 
}
 } 