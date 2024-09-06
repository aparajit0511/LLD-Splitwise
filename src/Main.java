import splitwise.LogicClass;
import splitwise.User;

import java.util.*;

import static splitwise.Expense.EQUAL;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        User user1 = new User("user1","tyson","tyson@abc.com",1234567);
        user1.getUserDetails();
        User user2 = new User("user2","kai","kai@abc.com",1234567);
        User user3 = new User("user3","ray","ray@abc.com",1234567);
        User user4 = new User("user4","max","max@abc.com",1234567);

        Map<String, Float> userMap = new HashMap<>();
        userMap.put(user1.getUserId(), 0.0f);
        userMap.put(user2.getUserId(), 0.0f);
        userMap.put(user3.getUserId(), 0.0f);
        userMap.put(user4.getUserId(), 0.0f);
        LogicClass logic = new LogicClass(userMap);

        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
//        users.add(user4);

//        String result = logic.callSplitwise(user1,4,1000, users, EQUAL,null);
        List<Float> amounts = Arrays.asList(370.00f, 880.00f);
//        String result1 = logic.callSplitwise(user1,4,1000.00f,users,EQUAL,amounts);
//        System.out.println(result1);

        float[] percent ={40.00f,20.00f,20.00f,20.00f};
        String result2 = logic.callSplitwise(user1,4,1000.00f,users,EQUAL,amounts,percent);
        System.out.println(result2);
    }
}