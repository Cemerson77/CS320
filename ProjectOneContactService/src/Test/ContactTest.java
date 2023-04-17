package src.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.main.Contact;

class ContactTest {
    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * Start Test for fields being null
     *
     * ----------------------------------------------------------------------------------------------------
     */

    @Test	//Test for contact Id null
    void testContactIdNullArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Contact( null, "Christine", "Emerson", "6038038231", "139 Chestnut St.");
        });
    }

    @Test	//Test for first name null
    void testContactFirstNameNullArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Contact("123456", null , "Emerson", "6038038231", "139 Chestnut St.");
        });
    }

    @Test	//Test for last name null
    void testContactLastNameNullArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Contact("123456", "Christine", null, "6038038231", "139 Chestnut St.");
        });
    }

    @Test	//Test for phone number null
    void testContactPhoneNumArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Contact("123456", "Christine", "Emerson", null, "139 Chestnut St.");
        });
    }

    @Test	//Test for address null
    void testContactAddressNullArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            new Contact("123456", "Christine", "Emerson", "6038038231", null);
        });
    }

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * End Test for fields being null
     *
     * ----------------------------------------------------------------------------------------------------
     */

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * Start Test for Contact and Getter
     *
     * ----------------------------------------------------------------------------------------------------
     */
    @Test
    void testContact(){
        Contact contact = new Contact("123456", "Christine", "Emerson", "6038038231", "139 Chestnut St.");

        // validating assertions are true for values assigned
        assertTrue(contact.getContactId().equals("123456"));
        assertTrue(contact.getFirstName().equals("Christine"));
        assertTrue(contact.getLastName().equals("Emerson"));
        assertTrue(contact.getPhoneNum().equals("6038038231"));
        assertTrue(contact.getAddress().equals("139 Chestnut St."));

    }

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * End Test for Contact and Getter
     *
     * ----------------------------------------------------------------------------------------------------
     */


    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * Start Test for fields being too long
     *
     * ----------------------------------------------------------------------------------------------------
     */
    @Test	//Contact ID too long
    void testContactIdTooLong() {
        // testing for IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789101112", "Christine", "Emerson","6038038231", "139 Chestnut St.");
        });		}

    @Test	//First name too long
    void testContactFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Christineee", "Emerson","6038038231", "139 Chestnut St.");
        });      }

    @Test	//Last name too long
    void testContactLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Christine", "Emersonnnnn","6038038231", "139 Chestnut St.");
        });      }

    @Test	//Last name too long
    void testContactPhoneNumTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Christine", "Emerson","603803823177", "139 Chestnut St.");
        });      }
    @Test	//Address too long
    void testContactAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Christine", "Emerson","6038038231", "1111111111111111111139 Chestnut St.");
        }); }

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * End Test for fields being too long
     *
     * ----------------------------------------------------------------------------------------------------
     */

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * Start Test for Phone number is not too short
     *
     * ----------------------------------------------------------------------------------------------------
     */

    @Test
    void testContactPhoneNumTooShort() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Christine", "Emerson","60380382", "139 Chestnut St.");
        });
    }
    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * End Test for Phone number is not too short
     *
     * ----------------------------------------------------------------------------------------------------
     */

    /*
     * ----------------------------------------------------------------------------------------------------
     *
     * Start Test for verifying everything is accurate
     *
     * ----------------------------------------------------------------------------------------------------
     */

    //Test Contact create
    @Test
    void testCreateContactSuccess() {
        Contact contact = new Contact("123457", "Christine", "Emerson", "6038038231", "139 Chestnut St.");

        //assertTrue(contact != null);
        assertTrue(contact.getContactId().equals("123457"));
        assertTrue(contact.getFirstName().equals("Christine"));
        assertTrue(contact.getLastName().equals("Emerson"));
        assertTrue(contact.getPhoneNum().equals("6038038231"));
        assertTrue(contact.getAddress().equals("139 Chestnut St."));

        //Test additional new contact with the same ID **(not sure this is right)**
        Contact contact1 = new Contact("123457", "Chris", "Grant", "6038038232", "149 Chestnut St.");

        assertTrue(contact1 != null);
        assertTrue(contact1.getContactId().equals("123457"));
        assertTrue(contact1.getFirstName().equals("Chris"));
        assertTrue(contact1.getLastName().equals("Grant"));
        assertTrue(contact1.getPhoneNum().equals("6038038232"));
        assertTrue(contact1.getAddress().equals("149 Chestnut St."));

    }



}
