/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users_info;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author abanob kamal
 */
public class Receptionest extends Person{
    private int  password ;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public static int ReceptionestLogin(Receptionest r){
          String line ;
       String [] values ;
        try{
             Scanner s = new Scanner(new File("ReceptionestData.txt"));
             while(s.hasNext()){
                 line = s.nextLine();
                 values = line.split(",");
                 if(r.getName() == values[0]){
                     return 1;
                 }
             }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}
