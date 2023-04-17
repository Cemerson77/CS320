package src.main;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactService {

    // maps contactID to Contact object
    private static final ContactService reference = new ContactService();

    private final HashMap<String, Contact> contactMap;

    private ContactService() {
        this.contactMap = new HashMap<>();
        new ArrayList<Contact>();
    }
    //Create a singleton Contact Service

    public static ContactService getService() {
        return reference;
    }

    public Contact GetContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contactMap.get(contactId);
    }

    // adds new contact
    public boolean AddContact(Contact contact) {
        boolean isSuccess = false;
        if (contactMap.containsKey(contact.getContactId())) {
            return isSuccess;
        }
        isSuccess = true;
        contactMap.put(contact.getContactId(), contact);
        return  isSuccess;
    }


    //deletes contact
    public void DeleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contactMap.remove(contactId);
    }

    //updates the info
   /* public void UpdateContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
        //checks if contact id exists
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("ContactID" + contactId + "does not exists");
        }

        // gets the Contact from the Map
        Contact contact = contactMap.get(contactId);

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first Name");
        }

        contact.setFirstName(firstName);

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        contact.setLastName(lastName);

        if (phoneNum == null || phoneNum.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        contact.setPhoneNum(phoneNum);

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        contact.setAddress(address);

    }*/


}