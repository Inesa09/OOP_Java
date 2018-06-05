package user;

public class DomainObject_10 {
    public static void main(String[] args) {
        User user = new User();
        user.name.setName("Inesa");
        user.surname.setSurname("Hermaniuk");
        user.birthDate.setBirthDate("09.08.2000");
        user.address.setAddress("Lviv");
        user.phones.addPhone(1111);

        user.getInfo();
        System.out.println(user.isPhone(1245));
        System.out.println(user.isAddress("Lviv"));
        user.name.setName("Maria");
        System.out.println(user.name.getName());
    }
}

