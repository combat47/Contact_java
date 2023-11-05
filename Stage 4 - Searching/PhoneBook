package contacts;

import java.util.ArrayList;

public class PhoneBook {
    private final ArrayList<Contact> phoneBooks;

    public PhoneBook() {
        this.phoneBooks = new ArrayList<>();
    }

    public void addPhoneBook (Contact contact) {
        phoneBooks.add(contact);
    }

    public int lengthOfPhoneBook() {
        return phoneBooks.size();
    }

    public ArrayList<Contact> getContacts() {
        return phoneBooks;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lengthOfPhoneBook(); i++) {
            str.append(String.format("%d. %s\n", i + 1, phoneBooks.get(i).toString()));
        }
        return str.toString();
    }
}
