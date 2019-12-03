 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_package;

import Users_info.Cusrtomer;
import Data_Io.Customer_Data_Functions;
import Data_Io.Employee_Data_Functions;
import Data_Io.Room_Data_Functions;
import Users_info.Admin;
import Users_info.Employee;
import Users_info.Receptionest;
import Users_info.Room;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author abanob kamal
 */
public class Pl2_project_test {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Room r1 = new Room();
       Room r2 = new Room();
       Room r3 = new Room();
       
       r1.setNumber("1");
       r1.setType("single");
       r1.setDateIn("3/12");
       r1.setDateOut("4/12");
       r1.setServices("room serving");
       r1.setCustomerName("....");
       
        r2.setNumber("2");
       r2.setType("dobule");
       r2.setDateIn("3/12");
       r2.setDateOut("4/12");
       r2.setServices("room serving");
       r2.setCustomerName("....");
       
        r3.setNumber("3");
       r3.setType("trible");
       r3.setDateIn("3/12");
       r3.setDateOut("4/12");
       r3.setServices("room serving");
       r3.setCustomerName("....");
       
        Room_Data_Functions.deletRoom(r2);
       
    
    }
   
    
}
        
        
       
