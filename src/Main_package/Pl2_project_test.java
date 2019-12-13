 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_package;

import Users_info.Customer;
import Data_Io.Customer_Data_Functions;
import Data_Io.Employee_Data_Functions;
import Data_Io.Room_Data_Functions;
import Users_info.Admin;
import Users_info.Employee;

import Users_info.Receptionest;
import Users_info.Room;
import Views.UserManagemnet_employee;
import Views.UserManagment_customer;
import Views.UserModule_main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import views.*;


/**
 *
 * @author abanob kamal
 */
public class Pl2_project_test {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
     //  new Login_Screen();  
     // new UserModule_main();
      // new RoomManagment_bill (); 
     // new  UserManagment_customer();
    new UserManagemnet_employee();
    try{ }
    catch(Exception e){System.out.println(e.getMessage());}
    // new NewClass();
   // RoomManagment_main   r = new RoomManagment_main();r.setVisible(true);
      
      /* Room r1  =new Room();
       Room r2  =new Room();
       Room r3  =new Room();
       
       r1.setNumber("1"); 
       r1.setType("single"); 
       r1.setDateIn("1/12");
       r1.setDateOut("1/1");
       r1.setServices("home");
       r1.setCustomerName("....");
       
        r2.setNumber("2"); 
       r2.setType("double"); 
       r2.setDateIn("1/5");
       r2.setDateOut("1/1");
       r2.setServices("home");
       r2.setCustomerName("abanoub");
       
        r3.setNumber("3"); 
       r3.setType("trible"); 
       r3.setDateIn("1/12");
       r3.setDateOut("1/1");
       r3.setServices("home");
       r3.setCustomerName("....");
       
       Room_Data_Functions.addRoom(r1);
       Room_Data_Functions.addRoom(r2);
       Room_Data_Functions.addRoom(r3);
      Room_Data_Functions.updateRoom(r2);*/
       
       
        
    }
   
    
}
        
        
       
