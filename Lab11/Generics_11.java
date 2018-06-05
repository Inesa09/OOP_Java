import user.*;

public class Generics_11 {
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

        GenericLinkedList<User> collection = new GenericLinkedList<>(User.class);
        collection.add(inesa);
        collection.add(nazar);
        System.out.println("Collection created: " + collection);
        System.out.println("First element: " + collection.get(0));

        collection.deleteAll();
        System.out.println("Collection cleared: " + collection);

        collection.add(inesa);
        collection.add(nazar);
        User arr [] = new User[collection.size()];
        collection.toArray(arr);
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(collection.getType());
    }
}

class GenericLinkedList<T> {
    Node start, end;
    private Class<T> type;

    public Class<T> getType() {
        return type;
    }

    public GenericLinkedList (Class<T> type) {
        this.type = type;
    }
    public GenericLinkedList () {
    }

    public void add(T data) {
        Node current = new Node();
        current.setData(data);
        if(start == null || end == current)
            start = current;
        else end.setNext(current);
        end = current;
    }

    public T get(int index) {
        if (this.size() <= index || index < 0) return null;
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (T) current.getData();
    }

    public boolean delete(int index) {
        if (this.size() <= index || index < 0) return false;
        if (index == 0) {
            start = start.getNext();
            if (start == null) end = null;
        } else {
            Node current = start;
            for (int i = 0; i < index - 1; i++) current = current.getNext();
            current.setNext(current.getNext().getNext());
            if (current.getNext() == null) end = current;
        }
        return true;
    }

    public boolean deleteAll(){
        if(this.size() == 0)
            return false;
        start = null;
        return true;
    }

    public int size() {
        if (start == null) return 0;
        Node current = start;
        int size = 1;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        if (this.size() == 0)
            return "[]";
        StringBuffer result = new StringBuffer("[" + this.get(0).toString());
        for (int i = 1; i < this.size(); i++) {
            result = result.append("\n" + this.get(i).toString());
        }
        result.append("]");
        return result.toString();
    }

    public T[] toArray(T [] arr) {
        for (int i = 0; i < this.size(); i++)
            arr[i] = this.get(i);
        return arr;
    }

    public boolean contains(T item) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).equals(item)) {
                return true;
            }
        }
        return false;
    }
}

class Node<T> {
    private Node next;
    private T data;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}