import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookSystem {
    private ArrayList<Contact> contactList = new ArrayList<>();
    private HashMap<String, Contact> nameLookup = new HashMap<>();
    private HashSet<String> phoneSet = new HashSet<>();

    public boolean addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            return false;
        }
        Contact newContact = new Contact(name, phone, email);
        contactList.add(newContact);
        nameLookup.put(name.toLowerCase(), newContact);
        phoneSet.add(phone);
        return true;
    }

    public Contact searchByName(String name) {
        return nameLookup.get(name.toLowerCase());
    }

    public boolean deleteContact(String name) {
        Contact contact = nameLookup.remove(name.toLowerCase());
        if (contact != null) {
            contactList.remove(contact);
            phoneSet.remove(contact.phone);
            return true;
        }
        return false;
    }

    public void displaySorted() {
        Collections.sort(contactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookSystem book = new AddressBookSystem();
        book.addContact("Charlie", "9876543210", "charlie@email.com");
        book.addContact("Alice", "1234567890", "alice@email.com");
        book.addContact("Bob", "5555555555", "bob@email.com");
        book.addContact("Duplicate", "1234567890", "dup@email.com");

        System.out.println("--- Sorted Contacts ---");
        book.displaySorted();

        System.out.println("\n--- Search Result ---");
        Contact found = book.searchByName("Alice");
        System.out.println(found != null ? found : "Not found");

        System.out.println("\n--- Deleting Bob ---");
        book.deleteContact("Bob");

        System.out.println("\n--- Sorted Contacts After Deletion ---");
        book.displaySorted();
    }
}