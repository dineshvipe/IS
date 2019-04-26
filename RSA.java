/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_prac4;

import java.util.Scanner;
import java.math.*;
import java.io.*;
public class RSA {
    public static void main(String[] args) {
         int p,q,n,fi_n,e=0,d=0;
        int plaintext, cipher = 0,output = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter p and q : ");
        p = sc.nextInt();
        
        
        if(!isPrime(p))
        {
            System.out.println("P should be prime\nEnter again:");
            p=sc.nextInt();
        }
        q = sc.nextInt();
        if(!isPrime(q))
        {
            System.out.println("P should be prime\nEnter again:");
            q=sc.nextInt();
        }
        n = p*q;
        System.out.println("Value of n : "+n);
        fi_n = (p-1)*(q-1);
        System.out.println("fi(n) : "+fi_n);
      
        for(int i=2;i<fi_n;i++)
        {
            if(gcd(i,fi_n)==1)
            {  e=i;
                break;
            }
        }
        System.out.println("e :"+e);
        BigInteger be = BigInteger.valueOf(e);
        BigInteger bfn = BigInteger.valueOf(fi_n);
        BigInteger bn = BigInteger.valueOf(n);
        BigInteger bd;
        bd = be.modInverse(bfn);
        //System.out.println("The value of d is : "+bd);
        d = bd.intValue();
         System.out.println("Value of d is : "+d);
        System.out.println("Public Key KU : {"+e+","+n+"}");
        System.out.println("Private Key KR : {"+d+","+p+","+q+"}");
        
        System.out.println("Enter Plaintext (Numeric) : ");
        plaintext = sc.nextInt();
        
        cipher =(int)(Math.pow(plaintext,e) % n);
        
        System.out.println("Encrypted Text : "+cipher);

        output  = (int) (Math.pow(cipher, d) % n);
        System.out.println("Decrypted Text : "+output);
    }
    
    
     public static int gcd(int a, int b) 
    { 
               if (a == 0) 
                   return b; 
               return gcd(b % a, a); 
    } 
    public static boolean isPrime(int n) {  
       if (n <= 1) {  
           return false;  
       }  
       for (int i = 2; i <= Math.sqrt(n); i++) {  
           if (n % i == 0) {  
               return false;  
           }  
       }  
       return true;  
   } 
}
