/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_1;



import java.util.*;

/**
 *
 * @author acer
 */
public class Cipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the plain text :");
        String s=sc.nextLine();
        //sc.next();
             
        System.out.println("Enter the value of K :");
        int k=sc.nextInt();
        System.out.println("k"+k);
        String encryp="";
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i))){
               char c=Character.toLowerCase(s.charAt(i));
             //  System.out.println("character : "+c);
               int v=c-'\0';
               v=v-97;
               int temp = (v+k)%26;
               temp=temp+97;
               char n=(char)temp;
               //System.out.println("New character : "+n);
               encryp=encryp+n;
            }
            else
                encryp=encryp+s.charAt(i);
        }
        System.out.println("Encrypted value :"+encryp);
        System.out.println("Decryption :");
         String decryp="";
        for(int i=0;i<encryp.length();i++){
            if(Character.isAlphabetic(encryp.charAt(i))){
               char c=encryp.charAt(i);
               //System.out.println("character : "+c);
               int v=c-'\0';
               v=v-97;
               int temp;
               if(v-k<0){
                   temp = 25-(k-1);
               }
               else
                  temp = (v-k);
               temp=temp+97;
               char n=(char)temp;
              // System.out.println("New character : "+n);
               decryp=decryp+n;
            }
            else
                decryp=decryp+encryp.charAt(i);
        }
        System.out.println("Decrypted value :"+decryp);
        
        System.out.println("Using Brute force : ");
        Brute_force(encryp);
    }
    static void Brute_force(String encryp){
        String decryp="";
        for(int j=0;j<26;j++){
        for(int i=0;i<encryp.length();i++){
            if(Character.isAlphabetic(encryp.charAt(i))){
               char c=encryp.charAt(i);
               //System.out.println("character : "+c);
               int v=c-'\0';
               v=v-97;
               int temp;
               if(v-j<0){
                   temp = 25-(j-1);
               }
               else
                  temp = (v-j);
               temp=temp+97;
               char n=(char)temp;
              // System.out.println("New character : "+n);
               decryp=decryp+n;
            }
            else
                decryp=decryp+encryp.charAt(i);
        }
        System.out.println("For k="+j+"Encrypted value :"+decryp);
        
        decryp="";
        }
    }
    
}