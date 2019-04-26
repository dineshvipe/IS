/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IS_prac3;




import java.util.*;


public class DES {

   static HashMap<Integer,Integer> map_10=new HashMap<Integer,Integer>();
   static HashMap<Integer,Integer> map_8=new HashMap<Integer,Integer>();
   static HashMap<Integer,Integer> map8b=new HashMap<Integer,Integer>();
   static HashMap<Integer,Integer> map_4right=new HashMap<Integer,Integer>();
   static HashMap<Integer,Integer> map_44=new HashMap<Integer,Integer>();
   static HashMap<Integer,Integer> IP_in=new HashMap<Integer,Integer>();
   static int[][] s0=new int[4][4];
   static int[][] s1=new int[4][4];
   static String k1="",k2="";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the 10 bit key: ");
        String key=sc.next();//"1010000010";
        key_calculation(key);
        System.out.println("Input : ");
        String Input=sc.next(); //"01101101";
        
        keys();
         
         String Cipher=Encryption(Input.substring(0,8),k1,k2)+Encryption(Input.substring(8,16),k1,k2);
         System.out.println("Cipher text: "+Cipher);
         String Plain=Encryption(Cipher.substring(0,8),k2,k1)+Encryption(Cipher.substring(8,16),k2,k1);
         System.out.println("Decryption : Plain text : "+Plain);
    }
    
    static String  Encryption(String Input,String k1,String k2){
        String permut="";
        for(int i=0;i<8;i++){
            permut=permut+Input.charAt(map8b.get(i+1)-1);
        }
        String permut2=permute(permut.substring(4,8)+permut.substring(4,8),map_4right,8);
        
        String xor=expansion_XOR(permut2,k1);
        
        String four_bit=expansion_arr(xor.substring(0,4),s0)+expansion_arr(xor.substring(4,8),s1);
        
        String permuted_four=permute(four_bit,map_44,4);   
        
        String xor_4_bit=expansion_XOR(permuted_four,permut.substring(0,4));
       
        String swaped=permut.substring(4,8)+xor_4_bit;
        
        permut2=permute(swaped.substring(4,8)+swaped.substring(4,8),map_4right,8);
        
        xor=expansion_XOR(permut2,k2);
        
        four_bit=expansion_arr(xor.substring(0,4),s0)+expansion_arr(xor.substring(4,8),s1);
        
        permuted_four=permute(four_bit,map_44,4); 
        
        xor_4_bit=expansion_XOR(permuted_four,swaped.substring(0,4));
        
        String swaped1=xor_4_bit+swaped.substring(4,8);
       
        return permute(swaped1,IP_in,8);
    }
    static String permute(String s, HashMap<Integer,Integer> m,int f){
         String q="";
        for(int i=0;i<f;i++){
            q=q+s.charAt(m.get(i+1)-1);
        }
        return q;
    }
    
    static String expansion_arr(String s,int[][] arr){
        String q="";
        int i=Integer.parseInt(String.valueOf(s.charAt(0))+String.valueOf(s.charAt(3)),2);
        int j=Integer.parseInt(String.valueOf(s.charAt(1))+String.valueOf(s.charAt(2)),2);
        int k=arr[i][j];
        q=Integer.toBinaryString(k);
        if(q.length()<2){
                q="0"+q;
            
        }
        return q;
    }
    static String expansion_XOR(String s,String k){
        String q="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==k.charAt(i)){
                q=q+"0";
            }
            else
                q=q+"1";
        }
        return q;
    }
   
    static void keys(){
  
        map8b.put(1, 2);
        map8b.put(2, 6);
        map8b.put(3, 3);
        map8b.put(4, 1);
        map8b.put(5, 4);
        map8b.put(6, 8);
        map8b.put(7, 5);
        map8b.put(8, 7);
        
        IP_in.put(1, 4);
         IP_in.put(2, 1);
          IP_in.put(3,3);
           IP_in.put(4,5);
            IP_in.put(5,7);
             IP_in.put(6,2);
              IP_in.put(7,8);
               IP_in.put(8,6);
               
               
        map_4right.put(1, 4);
        map_4right.put(2, 1);
       map_4right.put(3, 2);
        map_4right.put(4, 3);
        map_4right.put(5, 2);
        map_4right.put(6, 3);
        map_4right.put(7, 4);
       map_4right.put(8, 1);
       
       map_44.put(1, 2);
        map_44.put(2, 4);
         map_44.put(3,3 );
          map_44.put(4,1 );
       
    s0[0][0]=1;
    s0[0][1]=0;
    s0[0][2]=3;
    s0[0][3]=2;
    s0[1][0]=3;
    s0[1][1]=2;
    s0[1][2]=1;
    s0[1][3]=0;
    s0[2][0]=0;
    s0[2][1]=2;
    s0[2][2]=1;
    s0[2][3]=3;
    s0[3][0]=3;
    s0[3][1]=1;
    s0[3][2]=3;
    s0[3][3]=2;
               
    s1[0][0]=0;
    s1[0][1]=1;
    s1[0][2]=2;
    s1[0][3]=3;
    s1[1][0]=2;
    s1[1][1]=0;
    s1[1][2]=1;
    s1[1][3]=3;
    s1[2][0]=3;
    s1[2][1]=0;
    s1[2][2]=1;
    s1[2][3]=0;
    s1[3][0]=2;
    s1[3][1]=1;
    s1[3][2]=0;
    s1[3][3]=3;           
               
               
               
    }
    
    
    static void  key_calculation(String key){
        map_10.put(1, 3);
        map_10.put(2, 5);
        map_10.put(3, 2);
        map_10.put(4, 7);
        map_10.put(5, 4);
        map_10.put(6, 10);
        map_10.put(7, 1);
        map_10.put(8, 9);
        map_10.put(9, 8);
        map_10.put(10, 6);
        
        //8 bit 
        map_8.put(1, 6);
        map_8.put(2, 3);
        map_8.put(3, 7);
        map_8.put(4, 4);
        map_8.put(5, 8);
        map_8.put(6, 5);
        map_8.put(7, 10);
        map_8.put(8, 9);
        String permut="";
        for(int i=0;i<10;i++){
            permut=permut+key.charAt(map_10.get(i+1)-1);
        }
        String shift11="", shift12="";
        for(int i=1;i<5;i++){
            shift11=shift11+permut.charAt(i);
            shift12=shift12+permut.charAt(i+5);
        }
        shift11=shift11+permut.charAt(0);
        shift12=shift12+permut.charAt(5);
        permut=shift11+shift12;
        
        for(int i=0;i<8;i++){
            k1=k1+permut.charAt(map_8.get(i+1)-1);
        }
        System.out.println("K1 is :"+k1);
        shift11="";
        shift12="";
        for(int i=2;i<5;i++){
            shift11=shift11+permut.charAt(i);
            shift12=shift12+permut.charAt(i+5);
        }
        shift11=shift11+permut.charAt(0)+permut.charAt(1);
        
        shift12=shift12+permut.charAt(5)+permut.charAt(6);
        permut=shift11+shift12;
       
        for(int i=0;i<8;i++){
            k2=k2+permut.charAt(map_8.get(i+1)-1);
        }
        System.out.println("K2 is :"+k2);   
    }
}
