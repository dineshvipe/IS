/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_prac3;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class CBC {
    static HashMap<String,String> map=new HashMap<String, String>();
     static HashMap<String,String> map_d=new HashMap<String, String>();
    static String IV;
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the 16 bit input : ");
         String input=sc.next();
         int iv=(int)(Math.random()*(3-1)+1);
         IV=Integer.toBinaryString(iv);
            if(IV.length()<2){
                    IV="0"+IV;

            }
         System.out.println("Random IV Generated : "+IV);
          mapping();
         String cipher=Encryption(input);
         Decryption(cipher);
        
     }
     
     static String Encryption(String input){
         String inter="",sub="";
         String temp=IV;
          String encryption="";
         for(int i=0;i<input.length();i+=2){
             sub=input.substring(i,i+2);
             inter=XOR(sub,temp);
             temp=map.get(inter);
             encryption+=temp;
         }
          System.out.println("Encryption : "+encryption);
          return encryption;
     }
     
     static void Decryption(String cipher){
          String inter="",sub="";
         String temp=IV;
          String decryption="";
         for(int i=0;i<cipher.length();i+=2){
             sub=map_d.get(cipher.substring(i,i+2));
             inter=XOR(sub,temp);
             temp=cipher.substring(i,i+2);
             decryption+=inter;
             
         }
          System.out.println("Decryption : "+decryption);
     }
     static String XOR(String s,String qq){
         String q="";
         for(int i=0;i<2;i++)
         if(s.charAt(i)==qq.charAt(i))
             q=q+"0";
         else
             q=q+"1";
         return q;
             
     }
     static void mapping(){
         map.put("00","01");
         map.put("01","10");
         map.put("10","11");
         map.put("11","00");
         map_d.put("00","11");
         map_d.put("01","00");
         map_d.put("10","01");
         map_d.put("11","10");
     }
}
