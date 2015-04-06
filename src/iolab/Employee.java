/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iolab;

/**
 *
 * @author mpatel6
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    public Employee(String firstName, String lastName, String streetAddress, String city, String state, String zip) {
        setFirstName(firstName);
        setLastName(lastName);
        setStreetAddress(streetAddress);
        setCity(city);
        setState(state);
        setZip(zip);                
    }
    
    

    public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String address) {
        this.streetAddress = address;
    }

    public String getCity() {
        return city;
    }

    public final void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public final void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public final void setZip(String zip) {
        this.zip = zip;
    }
    
    @Override
    public String toString(){
        String str;
        str = "First Name: "+getFirstName()+"\n"+
              "Last Name : "+ getLastName()+"\n"+
              "Address   : "+ getStreetAddress()+"\n"+
              "\t    "+getCity()+", "+getState()+" "+getZip();
        
        return str;
                
                
               
    }
    
    
}
