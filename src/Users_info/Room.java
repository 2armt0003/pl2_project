/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users_info;

import java.util.Date;

/**
 *
 * @author abanob kamal
 */
public class Room {
    private String number ;
    
    private String type ;
    
    private String DateIn, DateOut;
    
    private String services ;
    
    private String customerName  = "....";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateIn() {
        return DateIn;
    }

    public void setDateIn(String DateIn) {
        this.DateIn = DateIn;
    }

    public String getDateOut() {
        return DateOut;
    }

    public void setDateOut(String DateOut) {
        this.DateOut = DateOut;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    
    
    
    
}
