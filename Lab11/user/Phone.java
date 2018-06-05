package user;

import java.io.Serializable;

public class Phone implements Serializable {
    private int[] phones = new int[10];
    private int count = 0;

    public void setPhone(int phone, int index) {
        this.phones[index] = phone;
    }

    public void addPhone(int phone) {
        if (count > 9) {
            System.out.println("No place available!");
            return;
        }
        this.phones[count] = phone;
        count++;
    }

    public int getPhone(int index) {
        return phones[index];
    }

    public int[] getAllPhones() {
        return phones;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Phones:");
        for (int i = 0; i < phones.length; i++) {
            if (phones[i] == 0)
                continue;
            result.append(" " + phones[i]);
        }
        return result.toString();
    }
}
