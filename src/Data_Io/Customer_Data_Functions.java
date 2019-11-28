/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Io;

import Users_info.Customer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author abanob kamal
 */
public class Customer_Data_Functions {
   public static String  Customer_Data_File = "CustomerData.txt";
   private static Scanner in ;
   public static Customer findCustomer(String customerName){
       Customer customer = new Customer();
       boolean found  = false ;
       String line ;
       String [] values;
       try{
           in = new Scanner(new File(Customer_Data_File));
        
           while(in.hasNext() && !found){
               line = in.nextLine();
               values = line.split(",");
               if(values[0].equals(customerName) ){
                   found = true;
                   customer.name = values[0];
                   customer.phone = values[1];
                   customer.mail = values[2];
                   customer.nationalty = values[3];
                   customer.gender = values[4];
                   return customer;
                   
               }
           }
           in.close();
           
           
       }catch(Exception e){
       
       }
     
       return null;
   }//fun end 
   
   
   public static void addCustomer(Customer customer){
       try{
        
           FileWriter fw = new FileWriter(Customer_Data_File, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           pw.println(
                    customer.name +","+
                   customer.phone +","+
                   customer.mail +","+
                   customer.nationalty +","+
                   customer.gender );
           pw.flush();
           pw.close();
            
           
       }catch(Exception e){
           
       }
   }//fun end 
   
   
   public static void updateCustomer(Customer customer){
      
     File oldfile = new File(Customer_Data_File);
     File newfile = new File("temp.txt");
     Customer tempCustomer = new Customer();
     String line ;
     String [] values;
     try{
         in = new Scanner(oldfile);
         
         FileWriter fw = new FileWriter(newfile);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
         while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
                if(values[0].equals(customer.name)){
                     pw.println(
                    customer.name +","+
                   customer.phone +","+
                   customer.mail +","+
                   customer.nationalty +","+
                   customer.gender );
                } else {
                    pw.println(line);
             }
               
         }
        in.close();
        pw.flush();
        pw.close();
        oldfile.delete();
        File f = new File(Customer_Data_File);
        newfile.renameTo(f);
         
     }catch(IOException e){
         
     }
   }//fun end 
   public static void deletCustomer(Customer customer){
     File oldfile = new File(Customer_Data_File);
     File newfile = new File("temp.txt");
     Customer tempCustomer = new Customer();
     String line ;
     String [] values;
     try{
         in = new Scanner(oldfile);
         
         FileWriter fw = new FileWriter(newfile);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
         while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
                if(values[0].equals(customer.name)){
                } else {
                    pw.println(line);
             }
               
         }
        in.close();
        pw.flush();
        pw.close();
        oldfile.delete();
        File f = new File(Customer_Data_File);
        newfile.renameTo(f);
         
     }catch(IOException e){
        
     }
             
     
       
   }//end fun 
       
       
}//class end 
    

