import java.io.*;
import java.util.*;

public class Nine {
    public static void main(String[] args) {
        MyArrayList<String> collection = new MyArrayList<String>();
        collection.add("a");
        collection.add("b");
        System.out.println("Collection created: " + collection);

        collection.clear();
        System.out.println("Collection cleared: " +collection);

        collection.add("bk");
        collection.add("cf");
        collection.add("d");
        collection.add("al");
        System.out.println("New collection created: " + collection);

        System.out.println("Remove 'd' from collection: " + collection.remove("d"));

        ArrayList<String> list = new ArrayList<String>();
        list.add("cf");
        list.add("bk");
        System.out.println("Collection contains all list: " + collection.containsAll(list));

        Iterator<String> iterator = collection.iterator();
        System.out.print("Work of iterator: ");
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println(iterator.next());

        try {
            String fileName = collection.serialize(collection);
            MyArrayList<String> newCollection = collection.deserialize(fileName);
            System.out.println("Deserialized collection: " + newCollection);
        } catch (IOException e) {
            System.out.println("IOException detected!");
        } catch ( ClassNotFoundException e) {
            System.out.println("ClassNotFoundException detected!");
        }
    }
}

class MyArrayList<T> implements Serializable {
    private final int SIZE = 2;
    private String[] array = new String[SIZE];
    private int pointer = 0;
    private int position = 0;

    @Override
    public String toString() {
        if (array[0] == null)
            return "[]";
        StringBuffer result = new StringBuffer("[" + array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null)
                break;
            result = result.append(" " + array[i]);
        }
        result.append("]");
        return result.toString();
    }

    public String[] toArray() {
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                position = i;
                break;
            }
        } return Arrays.copyOf(array, position);
    }

    public void add(String item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public String get(int index) {
        return array[index];
    }

    public boolean contains(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                position = i;
                return true;
            }
        } return false;
    }

    public boolean containsAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            if (!contains((String)iterator.next()))
                return false;
        }
        return true;
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
    }

    public boolean remove(String item) {
        if (contains(item)) {
            remove(position);
            return true;
        } return false;
    }

    public void clear() {
        for (int i = 0; i < array.length - 1; i++)
            array[i] = null;
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                if (position == array.length-1)
                    return false;
                return true;
            }

            @Override
            public String next() {
                String current = array[position];
                if (hasNext()) {
                    position++;
                    if (current == null)
                        return "";
                    return current;
                }
                return "Collection is empty!";
            }

            @Override
            public void remove () {
                for (int i = position-1; i < pointer; i++)
                    array[i] = array[i + 1];
                array[pointer] = null;
                pointer--;
                position--;
            }
        };
    }

    public String serialize (MyArrayList<String> collection) throws IOException {
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

    public MyArrayList<String> deserialize (String name) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File(name));
        ObjectInputStream oin = new ObjectInputStream(fis);
        Serializor ser = (Serializor)oin.readObject();
        return ser.getObject();
    }
}

class Serializor implements Serializable {
    private MyArrayList<String> object;
    public void setObject (MyArrayList<String> object) {
        this.object = object;
    }
    public MyArrayList<String> getObject (){
        return object;
    }

}