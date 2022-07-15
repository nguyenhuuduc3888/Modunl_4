package all.repository;

import all.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@123");
        u1.setPassword("123");
        userList.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Duc");
        u2.setAccount("duc");
        u2.setEmail("duc@123");
        u2.setPassword("123");
        userList.add(u2);

        User u3 = new User();
        u3.setAge(20);
        u3.setName("Son");
        u3.setAccount("son");
        u3.setEmail("son@123");
        u3.setPassword("123");
        userList.add(u3);
    }


    @Override
    public List<User> getData() {
        return userList;
    }
}
