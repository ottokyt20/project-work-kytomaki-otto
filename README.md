# Introduction to Programming - Project Work - Otto Kytömäki

## About the project and its features

Screencast link: https://youtu.be/EoJJSCD1eRY

This Java project was made during Introduction to Programming course. This project is a simple contacts application. User can create, remove, edit and display contacts. Contact data includes the following: first name, last name, phonenumber, email address, address (street name and house number) and personal id (finnish). Contacts are stored in a csv-file. User input is validated.


## How to use?

App can be compiled and run with the command: 
``` 
cd src && javac *.java && java ContactsApp.java 
```

Application has a command line user interface, so user inputs data in a command line. There is a "control panel" in the app, which guides user:

```
Control panel
1: Create a new contact
2: Delete an existing contact
3: Update an existing contact
4: Show saved contacts
5: Quit
```

## Code Example

```
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
```

In this example it's shown, how user input is gathered for a first name. User input is collected and then validated using different methods. 



## Credits

https://www.geeksforgeeks.org/java/?ref=shm_outind

**Very** helpful site, for example, when learning about Java IO FileReader Class or different Java methods.


