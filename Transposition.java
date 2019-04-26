/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_2;



import java.util.*;

/**
 *
 * @author cse
 */
public class Transposition {
static String s,sortkey;
static HashMap<String,ArrayList<String>> map;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the key : ");
        s=sc.next();
        char[] sort=s.toCharArray();
        Arrays.sort(sort);
        sortkey=String.valueOf(sort);
       map=new HashMap<String,ArrayList<String>>();
       for(int i=0;i<s.length();i++){
           map.put(String.valueOf(s.charAt(i)),null);
       }
        System.out.println("Plain Text :");
        sc.nextLine();
        String input=sc.nextLine();
        input =input.replaceAll(" ", "");
        int j=0;
        String encrypt=transposition(input);
        System.out.println("Single Transposition : "+encrypt);
        for(int i=0;i<s.length();i++){
            map.replace(String.valueOf(s.charAt(i)), null);
       }
        String second=transposition(encrypt);
        System.out.println("Double Transposition : "+second);
      
        for(int i=0;i<s.length();i++){
            map.replace(String.valueOf(s.charAt(i)), null);
       }
        String d1=decryption(second);
         System.out.println("Decryption 1 :"+d1);
      
        for(int i=0;i<s.length();i++){
            map.replace(String.valueOf(s.charAt(i)), null);
       }
         String d2=decryption(d1);
          System.out.println("Decryption 2 :"+d2);
       
       
    }
   
    static String transposition(String input){
        String enc="";
        ArrayList<String> a2;
         int j=0;
        for(int i=0;i<input.length();i++){
            a2=new ArrayList<String>();
           if(j==s.length()){
               j=0;
           }
           if(map.get(String.valueOf(s.charAt(j)))!=null){
               ArrayList<String> a1=map.get(String.valueOf(s.charAt(j)));
               for(String d:a1){
                   System.out.println("Key  :"+String.valueOf(s.charAt(j))+" "+d);
                   a2.add(d);
               }
           }
               a2.add(String.valueOf(input.charAt(i)));
               map.replace(String.valueOf(s.charAt(j)), a2);
               j++;
          
         }
        int max_len=map.get(String.valueOf(s.charAt(0))).size();
        for(int i=0;i<s.length();i++){
           ArrayList<String> mm=map.get(String.valueOf(sortkey.charAt(i)));
            for(String o : mm)
                enc=enc+o;
            if(max_len!=mm.size()){
                int q=max_len-mm.size();
                while(q-->0)
                     enc=enc+"x";
            }
          
        }
        return enc;
    }
    static String decryption(String input){
         String decr="";
        ArrayList<String> a2;
         int j=0,i=0;
        while(i<input.length()){
            a2=new ArrayList<String>();
           if(j==sortkey.length()){
               j=0;
           }
           int k=input.length()/s.length();
            while(k>0){
                //System.out.println("key: "+String.valueOf(s.charAt(j))+" "+String.valueOf(input.charAt(i)));
                a2.add(String.valueOf(input.charAt(i)));
                map.replace(String.valueOf(sortkey.charAt(j)), a2);
                i++;
                k--;
           }
           j++;
         }
        int k=input.length()/s.length();
        for( i=0;i<k;i++){
             for(int v=0;v<sortkey.length();v++){
                 ArrayList<String> a1=map.get(String.valueOf(s.charAt(v)));
                 decr=decr+a1.get(i);
             }
        }
        return decr;
    }
   
}