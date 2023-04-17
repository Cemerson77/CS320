package src.Test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import src.main.ContactService;
import src.main.Contact;

class ContactServiceTest {
    private static ContactService contactService;

    @BeforeAll
    static void setup() {
        contactService = ContactService.getService();
    }
    @Test
    void testGetContactAndUpdateSuccess() {
        Contact contact = new Contact("123456", "Christine", "Emerson", "6038038231", "139 Chestnut St.");
        assertTrue(contactService.AddContact(contact));

        Contact UpdateContact = contactService.GetContact(contact.getContactId());


        //validating assertions are true for values assigned
        assertTrue(contact.getContactId().equals("123456"));
        assertTrue(contact.getFirstName().equals("Christine"));
        assertTrue(contact.getLastName().equals("Emerson"));
        assertTrue(contact.getPhoneNum().equals("6038038231"));
        assertTrue(contact.getAddress().equals("139 Chestnut St."));

        // testing for update contact
        //removeContact updateContact = contactService.getContact(addContact.getContactId());
        //assertTrue(contactService.setContactId().equals("123456"));
        //first name
        UpdateContact.setFirstName("Chrissi");
        UpdateContact = contactService.GetContact(UpdateContact.getContactId());
        assertTrue(UpdateContact.getFirstName().equals("Christine"));
        //last name
        UpdateContact.setLastName("Emery");
        UpdateContact = contactService.GetContact(UpdateContact.getContactId());
        assertTrue(UpdateContact.getLastName().equals("Emerson"));
        //phone number
        UpdateContact.setPhoneNum("9421231234");
        UpdateContact = contactService.GetContact(UpdateContact.getContactId());
        assertTrue(UpdateContact.getPhoneNum().equals("9421231234"));
        //address
        UpdateContact.setAddress("129 Chestnut St.");
        UpdateContact = contactService.GetContact(UpdateContact.getContactId());
        assertTrue(UpdateContact.getAddress().equals("139 Chestnut St."));

    }
    @Test
    void testDeleteContact(){
        Contact contact1 = new Contact("123456", "Christine", "Emerson", "6038038231", "139 Chestnut St.");
        Contact contact2 = new Contact("123457", "Chrissi", "Emery", "6038038232", "129 Chestnut St.");

        assertTrue(contactService.AddContact(contact1));
        assertTrue(contactService.AddContact(contact2));

        contactService.DeleteContact(contact1.getContactId());

        // assertTrue(contactService.getContact(contact1.getContactId()) == null);
        // assertTrue(contactService.getContact(contact2.getContactId()).equals(contact2));

    }

}
