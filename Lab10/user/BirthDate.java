package user;

import java.io.Serializable;

public class BirthDate implements Serializable {
    private String birthDate;

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "BirthDate: " + getBirthDate();
    }
}
