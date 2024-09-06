package splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LogicClass {
    Map<String,Float> userMap;

    public LogicClass(Map userMap){
       this.userMap = userMap;
    }

    public String callSplitwise(User user1,int total_users, float amount, List<User> users, Expense expense,List<Float> contri){
        Map<String,Float> userShare = new HashMap<>();
        if (contri.size() > 0){
            int  i = 0;
            System.out.println(users.size());
            for (User user:users){
                userShare.put(user.getUserId(), contri.get(i));
                i += 1;
            }

        }
        if(expense == Expense.EQUAL){
            float balance = amount / users.size()+1;
            for (String key:userMap.keySet()){
                if(!Objects.equals(key, user1.getUserId())){
                    userMap.put(key,balance);
                }
            }
        } else if (expense == Expense.EXACT) {
            for (String key:userMap.keySet()){
                if(userShare.containsKey(key)){
                    float balance = userShare.get(key) + userMap.get(key);
                    userMap.put(key,balance);
                }
            }
        } else if (expense == Expense.PERCENT) {
            
        }

        return "Call Splitwise";
    }

    public String showBalance(){
        return "";
    }

}
