import splitwise.LogicClass;
import splitwise.User;

import java.util.ArrayList;
import java.util.List;

import static splitwise.Expense.EQUAL;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        User user1 = new User("user1","tyson","tyson@abc.com",1234567);
        user1.getUserDetails();
        User user2 = new User("user2","kai","kai@abc.com",1234567);
        User user3 = new User("user3","ray","ray@abc.com",1234567);
        User user4 = new User("user4","max","max@abc.com",1234567);
        LogicClass logic = new LogicClass();

        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String result = logic.callSplitwise(user1,4,1000,users,EQUAL);
        System.out.println(result);
    }
}