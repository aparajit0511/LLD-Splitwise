import splitwise.LogicClass;
import splitwise.User;

import java.util.*;

import static splitwise.Expense.*;

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

        System.out.println(logic.showBalance("SHOW"));

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        String result = logic.callSplitwise(user1,4,2000, users, EQUAL,null,null);
       System.out.println(logic.showBalance("show"));
        List<User> users1 = new ArrayList<>();
        users1.add(user2);
        users1.add(user3);
        List<Float> amounts = Arrays.asList(370.00f, 880.00f);
        String result1 = logic.callSplitwise(user1,4,1250.00f,users1,EXACT,amounts,null);
        System.out.println(logic.showBalance("show"));

        float[] percent ={40.00f,20.00f,20.00f,20.00f};
        List<User> users2 = new ArrayList<>();
        users2.add(user1);
        users2.add(user2);
        users2.add(user3);
        users2.add(user4);
        String result2 = logic.callSplitwise(user1,4,1000.00f,users2,PERCENT,null,percent);
        System.out.println(result2);
        System.out.println(logic.showBalance("show"));
    }
}