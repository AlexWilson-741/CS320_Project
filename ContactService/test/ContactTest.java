import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testCreateContact() {
        Contact contact = new Contact("001", "Harry", "Potter", "1234567890", "4 Privet Drive");

        // Updated test method to include assertAll
        assertAll(
                () -> assertNotNull(contact),
                () -> assertEquals("001", contact.getContactId()),
                () -> assertEquals("Harry", contact.getFirstName()),
                () -> assertEquals("Potter", contact.getLastName()),
                () -> assertEquals("1234567890", contact.getPhoneNumber()),
                () -> assertEquals("4 Privet Drive", contact.getAddress())
        );
    }

    @Test
    public void testCreateContactWithInvalidIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Harry", "Potter", "1234567890", "4 Privet Drive");
        });
    }

    @Test //test for first name length validation
    public void testCreateContactWithLongFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "ThisFirstNameIsTooLong", "Potter", "1234567890", "4 Privet Drive");
        });
    }

    @Test //test for last name length validation
    public void testCreateContactWithLongLastNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", "ThisLastNameIsTooLong", "1234567890", "4 Privet Drive");
        });
    }

    @Test //test for phone number length validation
    public void testCreateContactWithInvalidPhoneNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", "Potter", "12345", "4 Privet Drive");
        });
    }


    @Test //test for address length validation
    public void testCreateContactWithLongAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", "Potter", "1234567890", "This address is way too long to be valid");
        });
    }

    @Test //test for null first name validation
    public void testCreateContactWithNullFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", null, "Potter", "1234567890", "4 Privet Drive");
        });
    }

    @Test //test for null last name validation
    public void testCreateContactWithNullLastNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", null, "1234567890", "4 Privet Drive");
        });
    }

    @Test //test for null phone number validation
    public void testCreateContactWithNullPhoneNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", "Potter", null, "4 Privet Drive");
        });
    }

    @Test //test for null address validation
    public void testCreateContactWithNullAddressThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "Harry", "Potter", "1234567890", null);
        });
    }
}
