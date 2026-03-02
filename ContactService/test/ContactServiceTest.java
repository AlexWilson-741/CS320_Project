import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private Map<String, Contact> contacts;
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contacts = new HashMap<>();
        contactService = new ContactService(contacts);
    }

    @Test //test adding a new contact
    void testAddContact() {
        Contact contact = new Contact("001", "Sherlock", "Holmes", "0123456789", "221B Baker St");
        contactService.addContact(contact);

        Contact stored = contacts.get("001");
        assertNotNull(stored);
        assertEquals("001", stored.getContactId());
        assertEquals("Sherlock", stored.getFirstName());
        assertEquals("Holmes", stored.getLastName());
        assertEquals("0123456789", stored.getPhoneNumber());
        assertEquals("221B Baker St", stored.getAddress());
    }

    @Test //test deleting a contact
    void testDeleteContact() {
        Contact contact = new Contact("001", "Sherlock", "Holmes", "0123456789", "221B Baker St");
        contactService.addContact(contact);

        contactService.deleteContact("001");
        assertFalse(contacts.containsKey("001"));
    }

    @Test //test deleting a contact
    void testUpdateContact() {
        Contact contact = new Contact("001", "Sherlock", "Holmes", "0123456789", "221B Baker St");
        contactService.addContact(contact);

        contactService.updateContact("001", "John", "Watson", "0987654321", "10 Downing St");

        Contact updated = contacts.get("001");

        // Updated test method to include assertAll
        assertAll(
                () -> assertNotNull(updated),
                () -> assertEquals("001", updated.getContactId()),
                () -> assertEquals("John", updated.getFirstName()),
                () -> assertEquals("Watson", updated.getLastName()),
                () -> assertEquals("0987654321", updated.getPhoneNumber()),
                () -> assertEquals("10 Downing St", updated.getAddress())
        );
    }

    @Test //test adding a duplicate contact
    void testAddDuplicateContactThrowsException() {
        Contact contact1 = new Contact("001", "Sherlock", "Holmes", "0123456789", "221B Baker St");
        Contact contact2 = new Contact("001", "John", "Watson", "0987654321", "10 Downing St");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

    @Test //test deleting a non-existent contact
    void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("999"));
    }

    @Test //test updating a non-existent contact
    void testUpdateNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("999", "John", "Watson", "0987654321", "10 Downing St"));
    }

    @Test //test partial update of a contact
    void testPartialUpdateContact() {
        Contact contact = new Contact("001", "Sherlock", "Holmes", "0123456789", "221B Baker St");
        contactService.addContact(contact);

        // Only update lastName and address
        contactService.updateContact("001", null, "Watson", null, "10 Downing St");

        Contact updated = contacts.get("001");

        // Updated test method to include assertAll
        assertAll(
                () -> assertNotNull(updated),
                () -> assertEquals("001", updated.getContactId()),
                () -> assertEquals("Sherlock", updated.getFirstName()), // unchanged
                () -> assertEquals("Watson", updated.getLastName()),   // updated
                () -> assertEquals("0123456789", updated.getPhoneNumber()), // unchanged
                () -> assertEquals("10 Downing St", updated.getAddress())  // updated
        );

    }
}
