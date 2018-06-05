package user;

import java.io.*;
import java.util.ArrayList;

public class Serializor implements Serializable {
    private ArrayList<User> object;

    public void setObject(ArrayList<User> object) {
        this.object = object;
    }

    public ArrayList<User> getObject() {
        return object;
    }

    public static String serialize(ArrayList<User> collection) throws IOException {
        String fileName = "output.txt";
        FileOutputStream fos = new FileOutputStream(new File(fileName));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Serializor ser = new Serializor();
        ser.setObject(collection);

        oos.writeObject(ser);
        oos.flush();
        oos.close();
        System.out.println("Serialization complete!");
        return fileName;
    }

    public static ArrayList<User> deserialize(String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(name));
        ObjectInputStream oin = new ObjectInputStream(fis);
        Serializor ser = (Serializor) oin.readObject();
        return ser.getObject();
    }
}
