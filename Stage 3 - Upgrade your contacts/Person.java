package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person extends Contact {
    private String birthDay;
    private String gender;

    public Person(String name, String surname, String number, String  birthDay, String gender) {
        super(name, surname, number);
        this.birthDay = birthDay;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSurname();
    }

    @Override
    public String printInfo() {
        if (!birthDay.equals("[no data]")) {
            LocalDateTime dateTime = LocalDateTime.parse(birthDay);
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            birthDay = dateTime.format(formatter);
        }

        String lastEditedTime = super.getLastEditedTime().format(DateTimeFormatter.ISO_DATE_TIME);
        String createdTime = super.getCreatedTime().format(DateTimeFormatter.ISO_DATE_TIME);

        return String.format("""
                        Name: %s
                        Surname: %s
                        Birth date: %s
                        Gender: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s
                        """, super.getName(), super.getSurname(),
                birthDay, gender, super.getNumber(), createdTime, lastEditedTime);
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
        super.setLastEditedTime(LocalDateTime.now());
    }

    public void setGender(String gender) {
        this.gender = gender;
        super.setLastEditedTime(LocalDateTime.now());
    }
}
