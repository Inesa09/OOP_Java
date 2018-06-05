package user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    public Name name;
    public Surname surname;
    public BirthDate birthDate;
    public Address address;
    public Phone phones;
    public Date creationDate;

    public User() {
        name = new Name();
        surname = new Surname();
        birthDate = new BirthDate();
        address = new Address();
        phones = new Phone();
        this.creationDate = new Date();
    }

    public User(Name name, Surname surname, BirthDate birthDate, Address address, Phone phones) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.phones = phones;
        this.creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void getInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("{" + name.toString() + " | " + surname.toString() + " | " + birthDate.toString() + " | "
                + address.toString() + " | " + phones.toString() + " | " + "CreationDate: " + getCreationDate().toString() + "}");
        return result.toString();
    }

    public boolean isAddress(String address) {
        if (this.address.getAddress().equals(address))
            return true;
        else
            return false;
    }

    public boolean isBirthDate(String birthDate) {
        if (this.birthDate.getBirthDate().equals(birthDate))
            return true;
        else
            return false;
    }

    public boolean isPhone(int phone) {
        for (int i = 0; i < this.phones.getAllPhones().length; i++) {
            if (this.phones.getPhone(i) == phone)
                return true;
        }
        return false;
    }
}
