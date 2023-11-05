package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Organization extends Contact {
    private String organizationName;
    private String address;

    public Organization(String organizationName, String address, String number) {
        super(number);
        this.organizationName = organizationName;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.organizationName;
    }

    @Override
    public String printInfo() {

        String lastEditedTime = super.getLastEditedTime().format(DateTimeFormatter.ISO_DATE_TIME);
        String createdTime = super.getCreatedTime().format(DateTimeFormatter.ISO_DATE_TIME);

        return String.format(
                """
                        Organization name: %s
                        Address: %s
                        Number: %s
                        Time created: %s
                        Time last edit: %s
                        """, organizationName, address, super.getNumber(),
                createdTime, lastEditedTime
        );
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        super.setLastEditedTime(LocalDateTime.now());
    }

    public void setAddress(String address) {
        this.address = address;
        super.setLastEditedTime(LocalDateTime.now());
    }
}
