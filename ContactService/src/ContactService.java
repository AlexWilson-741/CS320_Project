import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    // Constructor initializes the contact map
    public ContactService(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    // Add new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with this ID already exists."); }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID does not exist.");
        }
        contacts.remove(contactId);
    }

    // Update contact details; only non-null parameters will be updated
    public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with this ID does not exist.");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNumber != null) {
            contact.setPhoneNumber(phoneNumber);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }
}
