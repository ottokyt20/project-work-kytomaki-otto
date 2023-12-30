/**
 * The {@code Contact} class is for object creation, "contact" objects are stored in an arraylist.
 */
public class Contact { //own class for object creation

    String firstname = "";
    String lastname = "";
    String phonenumber = "";
    String email = "";
    String address = ""; 
    String idnumber = "";
    
    /**
     * @param firstname the first name that is set.
     */
    public void SetFirstName(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return returns the first name that was set.
     */
    public String GetFirstName() {
        return firstname;
    }

     /**
     * @param lastname the last name that is set.
     */
    public void SetLastName(String lastname) {
        this.lastname = lastname;
    }

     /**
     * @return returns the last name that was set.
     */
    public String GetLastName() {
        return lastname;
    }

     /**
     * @param phonenumber the phone number that is set.
     */
    public void SetPhone(String phonenumber) {
        this.phonenumber = phonenumber;
    }

     /**
     * @return returns the phone number that was set.
     */
    public String GetPhone() {
        return phonenumber;
    }

     /**
     * @param email the e-mail that is set.
     */
    public void SetEmail (String email) {
        this.email = email;
    }

     /**
     * @return returns the e-mail that was set.
     */
    public String GetEmail() {
        return email;
    }

     /**
     * @param address the address that is set.
     */
    public void SetAddress(String address) {
        this.address = address;
    }

     /**
     * @return returns the address that was set.
     */
    public String GetAddress() {
        return address;
    }

     /**
     * @param idnumber the personal id that is set.
     */
    public void SetID(String idnumber) {
        this.idnumber = idnumber;
    }

     /**
     * @return returns the personal id that was set.
     */
    public String GetID() {
        return idnumber;
    }

     /**
     * {@code AddToFile} method adds contact information to the csv-file.
     */    
    public String AddToFile() { 
        return String.join(", ",firstname, lastname, phonenumber, email, address, idnumber);
    }

     /**
     * {@code GetFromFile} method loads contact information from the csv-file.
     */
    public static Contact GetFromFile(String String) {
        String [] table = String.split(",");
        Contact contact = new Contact();
        contact.SetFirstName(table[0]);
        contact.SetLastName(table[1]);     
        contact.SetPhone(table[2]);
        contact.SetEmail(table[3]);
        contact.SetAddress(table[4]);
        contact.SetID(table[5]);
        return contact;       
    }
}      
    





