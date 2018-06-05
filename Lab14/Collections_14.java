import user.*;
import static user.Serializor.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Collections_14 {
    public static void main(String[] args) {
        User inesa = new User();
        inesa.name.setName("Inesa");
        inesa.surname.setSurname("Hermaniuk");
        inesa.birthDate.setBirthDate("09.08.2000");
        inesa.address.setAddress("Lviv");
        inesa.phones.addPhone(1111);

        User nazar =  new User();
        nazar.name.setName("Nazar");
        nazar.surname.setSurname("Mamchur");
        nazar.birthDate.setBirthDate("08.04.2001");
        nazar.address.setAddress("Lviv");
        nazar.phones.addPhone(2222);

        ArrayList<User> users = new ArrayList<>();
        users.add(inesa);
        users.add(nazar);

        System.out.println("Collection created: " + users + "\n");
        System.out.println("First element: " + users.get(0) + "\n");

        users.clear();
        System.out.println("Collection cleared: " + users + "\n");

        users.add(inesa);
        users.add(nazar);
        User arr [] = new User[users.size()];
        users.toArray(arr);
        Arrays.sort(arr, new UserComparator());
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\nContains 'inesa': " + users.contains(inesa) + "\n");

        try {
            String fileName = serialize(users);
            ArrayList<User> newCollection = deserialize(fileName);
            System.out.println("Deserialized collection: " + newCollection);
        } catch (IOException e) {
            System.out.println("IOException detected!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException detected!");
        }

    }
}

