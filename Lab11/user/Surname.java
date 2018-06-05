package user;

import java.io.Serializable;

public class Surname implements Serializable {
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Surname: " + getSurname();
    }
}
