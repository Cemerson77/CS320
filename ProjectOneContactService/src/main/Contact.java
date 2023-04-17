/*
 *	============================================================================
 *	Name        : ContactService
 *	Author      : Christine Emerson
 *	Version     : 1.0
 *	Copyright   : Copyright © 2023 Christine Emerson
 *	Description : ContactService in Java with jUnit5
 *	//============================================================================
 *
 *  Contact class requirements:
 *  The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
 *  The contact ID shall not be null and shall not be updatable.
 *  The contact object shall have a required firstName String field that cannot be longer than 10 characters.
 *  The firstName field shall not be null.
 *  The contact object shall have a required lastName String field that cannot be longer than 10 characters.
 *  The lastName field shall not be null.
 *  The contact object shall have a required phone String field that must be exactly 10 digits. The phone
 *  field shall not be null.
 *  The contact object shall have a required address field that must be no longer than 30 characters. The
 *  address field shall not be null.
 */
package src.main;


public class Contact {
    //Declare variables all must not be null
    private final String contactId; // 10 char or less and not updatable
    private String firstName;	// 10 char or less
    private String lastName;	// 10 char or less
    private String phoneNum;	// must equal 10 char
    private String address;		// 30 char or less

    //Method to check if null to throw exception
    public Contact(String contactId, String firstName, String lastName,String phoneNum, String address) {
        if(contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }

        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }

        if(phoneNum == null || phoneNum.length() != 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }

        //Set variable to the name of the object
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    //Getters
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    /*
     * Setters
     *
     * Not needed because contact id should not be updatable
     * public void setContactId(String contactId) {
     * this.contactId = contactId;
     * }
     */

    // Method to validate  the requirements
    private boolean validateInput(String item, int length){
        if(item.length() > length || item == null) {
            throw new IllegalArgumentException("Invalid " + item);
        }
        return false;
    }

    public boolean setFirstName(String firstName) {
        //verify first name is not greater than 10 char and not null
        boolean IsValid = validateInput(firstName, 10);
        if(IsValid) {
            this.firstName = firstName;
        }
        return IsValid;
    }

    public boolean setLastName(String lastName) {
        //verify last name is not greater than 10 char and not null
        boolean IsValid = validateInput(lastName,10);
        if(IsValid) {
            this.lastName = lastName;
        }
        return IsValid;

    }

    public boolean setPhoneNum(String phoneNum) {
        boolean IsValid = phoneNum.matches(".*\\d{10}.*");
        if(IsValid) {
            this.phoneNum = phoneNum;
        }
        return IsValid;
    }
    public boolean setAddress (String address) {
        //verify address is not greater than 30 and not null
        boolean IsValid = validateInput(address, 30);
        if(IsValid) {
            this.address= address;
        }
        return IsValid;
    }

}
