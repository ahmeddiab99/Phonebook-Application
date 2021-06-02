/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

/**
 *
 * @author Ahmed Diab, Fengnan Zhang.
 */
public class Contact {
    private int id;
    private String name;
    private String Address;
    private String city;
    private String phoneNumber;
    private String state;

    /**
     * default constructor.
     */
    public Contact() {

        this.name = "";
        this.id = 0;
        this.phoneNumber = "";
        this.city = "";
        this.state = "";
        this.Address = "";

    }
    
    /**
     * Constructor.
     * @param id
     * @param name
     * @param address
     * @param city
     * @param phoneNumber
     * @param state 
     */
    public Contact(int id, String name, String address, String city, String state, String phoneNumber) {
        super();
        this.id = id;
        this.name = name;
        Address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }
    
    /**
     * get Id.
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * get Name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * get Address.
     * @return 
     */
    public String getAddress() {
        return Address;
    }
    
    /**
     * get City.
     * @return 
     */
    public String getCity() {
        return city;
    }
    
    /**
     * get Phone Number.
     * @return 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * get state.
     * @return 
     */
    public String getState() {
        return state;
    }
    
    /**
     * set state.
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * set id.
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * set Name.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * set Address.
     * @param Address 
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    /**
     * set City.
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * set Phone Number.
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * set Contact.
     * @param contact 
     */
    public void setContact(Contact contact) {

        setId(contact.getId());
        setName(contact.getName());
        setAddress(contact.getAddress());
        setCity(contact.getCity());
        setState(contact.getState());
        setPhoneNumber(contact.getPhoneNumber());
    }

    /**
     * return contact information.
     * @return 
     */
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", Address=" + Address + ", city=" + city + ", state="
                + state + ", phoneNumber=" + phoneNumber + "]";
    }

}
