/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Io;

import static Data_Io.Customer_Data_Functions.Customer_Data_File;
import Users_info.Customer;
import Users_info.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Service_Data_Functions {
   public static String  Service_Data_File = "ServiceData.txt";
   private static Scanner in ;
    public static Service findService(String ServiceName){
       Service service = new Service();
       boolean found  = false ;
       String line ;
       String [] values;
       try{
           in = new Scanner(new File(Customer_Data_File));
        
           while(in.hasNext() && !found){
               line = in.nextLine();
               values = line.split(",");
               if(values[0].equals(ServiceName) ){
                   found = true;
                   service.setName(values[0]);
                   service.setType(values[1]);
                   service.setDiscription(values[2]);
                   service.setId(values[3]);
                   return service;
                   
               }
           }
           in.close();
           
           
       }catch(Exception e){
       
       }
     
       return null;
   }//fun end 
   public static void addService(Service service){
       try{
          
           FileWriter fw = new FileWriter(Customer_Data_File, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           pw.println(
                    service.getName() +","+
                   service.getType() +","+
                   service.getDiscription()+","+
                    service.getId());
           pw.flush();
           pw.close();
            
           
       }catch(Exception e){
           
       }
   }//fun end 
    public static void updateService(Service service){
      
     File oldfile = new File(Service_Data_File);
     File newfile = new File("temp.txt");
   
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
                if(values[0].equals(service.getName())){
                     pw.println(
                    service.getName() +","+
                   service.getType() +","+
                   service.getDiscription()+","+
                    service.getId());

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
     public static void deletService(Service service){
     File oldfile = new File(Customer_Data_File);
     File newfile = new File("temp.txt");
  
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
                if(values[0].equals(service.getName())){
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
    
}//end of class
