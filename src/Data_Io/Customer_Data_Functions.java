/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Io;

import static Data_Io.Employee_Data_Functions.EmployeeDataFile;
import Users_info.Customer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
                   customer.setName(values[0]);
                   customer.setPhone(values[1]);
                   customer.setMail(values[2]);
                   customer.setNationalty(values[3]);
                   customer.setGender(values[4]);
                   customer.setId(values[5]);
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
                    customer.getName() +","+
                   customer.getPhone() +","+
                   customer.getMail() +","+
                   customer.getNationalty() +","+
                   customer.getGender()+","+
                   customer.getId());
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
                    customer.getName() +","+
                   customer.getPhone() +","+
                   customer.getMail() +","+
                   customer.getNationalty() +","+
                   customer.getGender()+","+
                   customer.getId() );
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
    public static ArrayList getAllData(){
       ArrayList<String> allData = new ArrayList<>();
       String line;
       try{
           FileReader f =  new FileReader(Customer_Data_File);
           in = new Scanner(f);
           while(in.hasNext()){
               line   = in.nextLine();
               allData.add(line);
           }
           f.close();
           in.close();
       }catch(IOException e){
           System.out.println(e.getMessage());
           
       }
       
       return allData;
   }//end fun    
       
       
}//class end 
    

