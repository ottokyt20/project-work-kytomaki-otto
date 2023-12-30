    /**
    * The {@code Valid} class is for methods, that check if certain piece of contact information is valid or not
    */
public class Valid {

    /**
     * @param firstname first name that will be validated
     * @return {@code true} if first tname is valid, {@code false} if first name is not valid
     */
    public static boolean FirstNameValidation(String firstname) {
        boolean check = firstname.length() >= 2 && Character.isUpperCase(firstname.charAt(0));
        return check;
    }

    /**
     * @param lastname last name that will be validated
     * @return {@code true} if last name is valid, {@code false} if last name is not valid
     */
    public static boolean LastNameValidation(String lastname) {
        boolean check = lastname.length() >= 2 && Character.isUpperCase(lastname.charAt(0));
        return check;
    }
    
     /**
     * @param idnumber personal id that will be validated
     * @return {@code true} if personal id is valid, {@code false} if pesonal id is not valid
     */
    public static boolean IdNumberValidation(String idnumber) {
        boolean check = idnumber.length() == 11 && (idnumber.charAt(6) == '-' || idnumber.charAt(6) == 'A' || idnumber.charAt(6) == '+')
                        && (idnumber.charAt(10) == '0' || idnumber.charAt(10) == '1' || idnumber.charAt(10) == '2' || idnumber.charAt(10) == '3'
                        || idnumber.charAt(10) == '4' || idnumber.charAt(10) == '5' || idnumber.charAt(10) == '6' || idnumber.charAt(10) == '7' 
                        || idnumber.charAt(10) == '8' || idnumber.charAt(10) == '9' || idnumber.charAt(10) == 'A' || idnumber.charAt(10) == 'B'
                        || idnumber.charAt(10) == 'C' || idnumber.charAt(10) == 'D' || idnumber.charAt(10) == 'E' || idnumber.charAt(10) == 'H'
                        || idnumber.charAt(10) == 'J' || idnumber.charAt(10) == 'K' || idnumber.charAt(10) == 'L' || idnumber.charAt(10) == 'M'
                        || idnumber.charAt(10) == 'N' || idnumber.charAt(10) == 'P' || idnumber.charAt(10) == 'R' || idnumber.charAt(10) == 'S'
                        || idnumber.charAt(10) == 'T' || idnumber.charAt(10) == 'U' || idnumber.charAt(10) == 'V' || idnumber.charAt(10) == 'W'
                        || idnumber.charAt(10) == 'X' || idnumber.charAt(10) == 'Y');
        return check;
    }
      
     /**
     * @param phonenumber phone number that will be validated
     * @return {@code true} if personal id is valid, {@code false} if pesonal id is not valid
     */ 
    public static boolean PhoneNumberValidation(String phonenumber) {
        boolean check = 15 >= phonenumber.length() && phonenumber.length() >=7  && phonenumber.charAt(0) == '+';
        return check;
    }
       
     /**
     * @param email email address that will be validated
     * @return {@code true} if email address is valid, {@code false} if email address is not valid
     */
    public static boolean EmailValidation(String email) {
        boolean check = email.contains("@") && email.contains(".") && email.length() > 4;
        return check;
    }

    /**
     * @param address address that will be validated
     * @return {@code true} if address is valid, {@code false} if address is not valid
     */
    public static boolean AddressValidation(String address) {
        boolean check = Character.isUpperCase(address.charAt(0)) && address.contains(" ");
        return check;
    } 
}