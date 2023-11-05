package contacts;

import java.time.LocalDateTime;
public abstract class Contact {

    private  String name;
    private  String surname;
    private String number;
    private LocalDateTime lastEditedTime;
    private final LocalDateTime createdTime;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.createdTime = LocalDateTime.now();
        this.lastEditedTime = LocalDateTime.now();
    }

    public Contact(String number) {
        this.number = number;
        this.createdTime = LocalDateTime.now();
        this.lastEditedTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return name + " " + surname + ", "+ number;
    }

    abstract public String printInfo();

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getLastEditedTime() {
        return lastEditedTime;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (Action.checkValidityPhoneNumber(number)) {
            this.number = number;
        } else {
            System.out.print("Wrong number format!\n");
            this.number = "[no number]";
        }

        lastEditedTime = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
        lastEditedTime = LocalDateTime.now();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        lastEditedTime = LocalDateTime.now();
    }

    public void setLastEditedTime(LocalDateTime lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    public static boolean isPerson(Contact contact) {
        return contact.getClass() == Person.class;
    }
}
