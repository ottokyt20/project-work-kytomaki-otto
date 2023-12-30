import java.io.Console;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;

  /**
    * @author Otto Kytömäki
    * This is a basic contacts application. User can create, delete and update contacts. There are six types of contact info stored: first name,
    * last name, phone umber, email address, address (street name and house number) and personal id (finnish).
    * {@code ContactsApp} class is where the app fuctions and other methods are called determined by the user input.
    */

   /**
 * The {@code ContactsApp} class is the main class of the app. Main functions are here, for example loop for the control panel and 
 * different methods.
 */

public class ContactsApp {
    
    /**
     * List of contacts. Static variable, it can be accessed from different classes.
     */
    static ArrayList<Contact> contactlist = new ArrayList<>(); //static, so all methods can access this variable (even from different class)
    /**
     * File path where contact info is stored.
     */
    static final String CSV_FILE_PATH = "ListOfContacts.csv";

    public static void main(String[] args) {
        /**
         * Files are loaded from the csv -file using the {@code LoadFile} method.
         */
        System.out.println();
        LoadFile();

    /**
     * Main part of the app is this while-loop. App will do different things based on user input, which is validated.
     */
        while (true) {
            System.out.println();
            System.out.println("Control panel");
            System.out.println("1: Create a new contact");
            System.out.println("2: Delete an existing contact");
            System.out.println("3: Update an existing contact");
            System.out.println("4: Show saved contacts");
            System.out.println("5: Quit");
            System.out.println();

            Console c = System.console();
            System.out.println("Choose a number to do an action!");
            int number = Integer.parseInt(c.readLine());
            System.out.println();

            if (number == 1) {
                CreateContact();
                System.out.println();
            } else if (number == 2) {
                RemoveContact();
                System.out.println();
            } else if (number == 3) {
                UpdateContact();
                System.out.println();
            } else if (number == 4) {
                DisplayAllContacts();
                System.out.println();
            } else if (number == 5) {
                SaveFile();
                System.out.println("Quitting the app, see you later :)"); //if user input is 5, loop will end, so the app shuts down.
                break;
            } else {
                System.out.println("Not an option, please enter a number between 1-5 to do an action!");
                System.out.println();
            }
        }
    }

    /**
     * {@code CreateContact} method creates a new contact based on user input. Validation methods are called, 
     * making sure that the userinput is validated.
     */
    public static void CreateContact() {
        
        Console c = System.console();

        System.out.println();
        System.out.println("Create a new contact");
        System.out.println();
        System.out.println("Start by giving a first name");
        String firstname = c.readLine();

        while(Valid.FirstNameValidation(firstname) == false) {
            System.out.println();
            System.out.println("Please enter a valid first name");
            firstname = c.readLine();
        }

        System.out.println();
        System.out.println("Give last name");
        String lastname = c.readLine();

        while(Valid.LastNameValidation(lastname) == false) {
            System.out.println();
            System.out.println("Please enter a valid last name");
            lastname = c.readLine(); 
        }

        System.out.println();
        System.out.println("Give a phonenumber (international format)");
        String phonenumber = c.readLine();

        while (Valid.PhoneNumberValidation(phonenumber) == false) {
            System.out.println();
            System.out.println("Give a valid phonenumber (international format)");
            phonenumber = c.readLine();
        }

        System.out.println();
        System.out.println("Give an email address");
        String email = c.readLine();

        while (Valid.EmailValidation(email) == false) {
            System.out.println();
            System.out.println("Give a valid email address");
            email = c.readLine();
        }

        System.out.println();
        System.out.println("Give an address (street name and house number, for example 'Pohjolankatu 21')");
        String address = c.readLine();

        while (Valid.AddressValidation(address) == false) {
            System.out.println();
            System.out.println("Give an valid address");
            address = c.readLine();
        }

        System.out.println();
        System.out.println("Give personal id");
        String idnumber = c.readLine();

        while (Valid.IdNumberValidation(idnumber) == false) {
            System.out.println();
            System.out.println("Give a valid personal id");
            idnumber = c.readLine();
        }

        Contact contact = new Contact();
        contact.SetFirstName(firstname);
        contact.SetLastName(lastname);
        contact.SetPhone(phonenumber);
        contact.SetEmail(email);
        contact.SetAddress(address);
        contact.SetID(idnumber);
        contactlist.add(contact);
    }

    /**
     * {@code RemoveContact} method removes a contact object, user will input details that determine which contact will be deleted. 
     * User input is validated.
     */
    public static void RemoveContact() {  

        if (contactlist.isEmpty()) {
            System.out.println("No contacts currently saved! If you create some contacts, you can delete them here");
            } else {
            
            DisplayAllContacts();

            Console c = System.console();
            System.out.println("Which contact do you want to remove(index)? If you want to remove all contacts, type: -1");
            int removeChoice = Integer.parseInt(c.readLine());

            while (removeChoice >= contactlist.size()) {
                System.out.println();
                System.out.println("Give valid index");
                removeChoice = Integer.parseInt(c.readLine());
            }
            
            if (removeChoice == -1) {
                System.out.println("You chose to remove all currently saved contacts, proceeding...");
                contactlist.clear();
            } else {
                System.out.println("You chose to delete contact in index " + removeChoice);
                contactlist.remove(removeChoice);
                }
            }
        }
    /**
     * {@code UpdateContact} method is used to update a contact which already exists. Index and new contact information is asked.
     * Information is validated. 
     */
   public static void UpdateContact() {
    
    if (contactlist.isEmpty()) { // Java's own method for arraylist, it is checking if the list is empty or not.
        System.out.println("No contacts currently saved! If you create some contacts, you can update them here");
        } else {
            
            DisplayAllContacts();

            Console c = System.console();
    
            System.out.println("Give the index of the contact you want to update");
            int updateChoice = Integer.parseInt(c.readLine());
            
            while (updateChoice >= contactlist.size()) {
                System.out.println();
                System.out.println("Give a valid index");
                updateChoice = Integer.parseInt(c.readLine());
            }

            Contact contact = contactlist.get(updateChoice);
            System.out.println();

            System.out.println("You chose to update contact in index " + updateChoice);
            System.out.println();
            System.out.println("Start by giving a new first name");
            String firstname = c.readLine();

            while (Valid.FirstNameValidation(firstname) == false) {
                System.out.println();
                System.out.println("Please enter a valid first name");
                firstname = c.readLine();        
            }
   
            System.out.println();
            System.out.println("Give new last name");
            String lastname = c.readLine();

            while (Valid.LastNameValidation(lastname) == false) {
                System.out.println();
                System.out.println("Please enter a valid last name");
                lastname = c.readLine();
            }

            System.out.println();
            System.out.println("Give new phone number (international format)");
            String phonenumber = c.readLine();

            while (Valid.PhoneNumberValidation(phonenumber) == false) {
                System.out.println();
                System.out.println("Give a valid phonenumber (international format)");
                phonenumber = c.readLine();
            }
            
            System.out.println();
            System.out.println("Give a new email-address");
            String email = c.readLine();

            while (Valid.EmailValidation(email) == false) {
                System.out.println();
                System.out.println("Give a valid email-address");
                email = c.readLine();
            }

            System.out.println();
            System.out.println("Give a new address (street name and house number, for example 'Pohjolankatu 21')");
            String address = c.readLine();

            while (Valid.AddressValidation(address) == false) {
                System.out.println();
                System.out.println("Give a valid address");
                address = c.readLine();
            }

            System.out.println();
            System.out.println("Give a new personal id");
            String idnumber = c.readLine();
            
            while (Valid.IdNumberValidation(idnumber) == false) {
                System.out.println();
                System.out.println("Give a valid id");
                idnumber = c.readLine();
            }

            contact.SetFirstName(firstname);
            contact.SetLastName(lastname);
            contact.SetPhone(phonenumber);
            contact.SetEmail(email);
            contact.SetAddress(address);
            contact.SetID(idnumber);
        }
    }
    /**
     * {@code DisplayAllContacts} method displays all contacts, it loops through the existing arraylist.
     */
    public static void DisplayAllContacts() {
        if (contactlist.isEmpty()) { // Java's own method for arraylist, it is checking if the list is empty or not.
            System.out.println("No contacts currently saved! If you create some contacts, they will be displayed here");
            System.out.println();
            } else {
                System.out.println("These are the contacts currently saved: ");
                System.out.println();
                for (int i = 0; i < contactlist.size(); i++) {
                    PrintContact(i, contactlist.get(i));
                }
            }
        }

    /**
     * This method prints the existing contact info and index.
     * @param index the index of the given contact object from the {@code DisplayAllContacts} method.
     * @param contact given object from the {@code DisplayAllContacts} method.
     */
    public static void PrintContact(int index, Contact contact) {
            System.out.println("index: " + index);
            System.out.println("first name: " + contact.GetFirstName());
            System.out.println("last name: " + contact.GetLastName());
            System.out.println("phone number: " + contact.GetPhone());
            System.out.println("email: " + contact.GetEmail());
            System.out.println("address: " + contact.GetAddress());
            System.out.println("personal ID: " + contact.GetID()); 
            System.out.println();
            }


    /**
     * {@code SaveFile} method saves the arraylist (contacts to a csv-file).
     */
    public static void SaveFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (int i = 0; i < contactlist.size(); i++) {
                Contact contact = contactlist.get(i);
                writer.write(contact.AddToFile());
                writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Can't save contacts, file not existing yet!");
            }
        }

    /**
     * {@code LoadFile} method is used to load contact info from the file, so the data doesn't disappear when the app shuts down and
     * is started again.
     */
    public static void LoadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String textline = "";
            while ((textline = reader.readLine()) != null) {
                contactlist.add(Contact.GetFromFile(textline));
            }
        } catch (IOException e) {
            System.out.println("Can't load contacts, file not existing yet or no contacts saved!");
        }
    }       
}
 