package user;

import java.io.Serializable;

public class Address implements Serializable {
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address: " + getAddress();
    }
}
