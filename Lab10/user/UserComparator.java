package user;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        int length1 = u1.name.getName().length();
        int length2 = u2.name.getName().length();
        if (length1 > length2)
            return 1;
        else if (length1 < length2)
            return -1;
        else {
            length1 = u1.surname.getSurname().length();
            length2 = u2.surname.getSurname().length();
            if (length1 > length2)
                return 1;
            else
                return -1;
        }
    }
}
