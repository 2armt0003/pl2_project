/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Io;

import static Data_Io.Customer_Data_Functions.addCustomer;
import Users_info.Cusrtomer;
import Users_info.Employee;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author abanob kamal
 */
public class Employee_Data_Functions {
   public static String   EmployeeDataFile = "EmployeeDataFile.txt" ;
   private static Scanner in ;
   public static Employee findEmployee(String employeeName){
       Employee employee = new Employee();
       boolean found  = false ;
       String line  ;
       String [] values;
       try{
           in = new Scanner(new File(EmployeeDataFile));
           in.useDelimiter("[,\n]");
           while(in.hasNext() && !found){
               line  = in.nextLine();
               values = line.split(",");
               if(values[0].equals(employeeName)){
                   found = true;
                   employee.setName( values[0]);
                   employee.setPhone(values[1]);
                   employee.setMail(values[2]);
                   employee.setAge(values[3]);
                   employee.setAddress(values[4]);
                   employee.setWork_type(values[5]);
                   return employee;
                   
               }
           }
           in.close();
           
           
       }catch(Exception e){
       
       }
     
       return null;
   }//fun end 
   
    public static void addEmployee(Employee employee, String file){
      
       try{
           //انا هنا باخداسم الملف اللي هيتفتح علشان مره هخزن في الموقت و مره في الاساسي 
           FileWriter fw = new FileWriter(file, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           pw.println(
                   employee.getName() +","+
                   employee.getPhone() +","+
                   employee.getMail() +","+
                   employee.getAge()+","+
                   employee.getAddress() +","+
                   employee.getWork_type());
           pw.flush();
           pw.close();
            
           
       }catch(Exception e){
           
       }
   }//fun end
    
    
    public static void updateEmployee(Employee employee){
       File newfile = new File("temp.txt");
       File oldfile = new File(EmployeeDataFile);
       Employee tempemployee = new Employee();
       String line  ;
       String [] values;

       try{
           FileWriter fw = new FileWriter(newfile, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           in = new Scanner(oldfile);
           in.useDelimiter("[,\n]");
           while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
                   
               if(tempemployee.name.equals(employee.name)){
                    pw.println(
                   employee.getName() +","+
                   employee.getPhone() +","+
                   employee.getMail() +","+
                   employee.getAge()+","+
                   employee.getAddress() +","+
                   employee.getWork_type());
                  
                }
               else{
                   
                    pw.println(line);
               }
                
               
           }
           pw.close();
           
       }catch(Exception e){
       
       }
       in.close();
       oldfile.delete();
       File f = new File(EmployeeDataFile);
       newfile.renameTo(f);
   }//fun end 

   public static void deletEmployee(Employee employee){
       
      File newfile = new File("temp.txt");
       File oldfile = new File(EmployeeDataFile);
       Employee tempemployee = new Employee();
       String line  ;
       String [] values;

       try{
           FileWriter fw = new FileWriter(newfile, true );
           BufferedWriter bf = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bf);
           in = new Scanner(oldfile);
           in.useDelimiter("[,\n]");
           while(in.hasNext()){
                line = in.nextLine();
                values = line.split(",");
                   
               if(tempemployee.name.equals(employee.name)){
                
                }
               else{
                   
                    pw.println(line);
               }
                
               
           }
           pw.close();
           
       }catch(Exception e){
       
       }
       in.close();
       oldfile.delete();
       File f = new File(EmployeeDataFile);
       newfile.renameTo(f);
   }//end fun 
       
   
    

    
}//class end 
