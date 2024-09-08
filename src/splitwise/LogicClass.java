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

    public String callSplitwise(User user1,int total_users, float amount, List<User> users, Expense expense,List<Float> contri,float[] percent){
        Map<String,Float> userShare = new HashMap<>();
        if (contri != null && !contri.isEmpty()){
            int  i = 0;

            for (User user:users){
                userShare.put(user.getUserId(), contri.get(i));
                i += 1;
            }
            System.out.println("User Shares"+ userShare);
        }
        else if (percent != null){
            int i = 0;
            for(User user:users){
                userShare.put(user.getUserId(), (float) percent[i]);
                i+= 1;
            }
        }
        if(expense == Expense.EQUAL){
            float balance = amount / users.size();
            for (String key:userMap.keySet()){
                if(!Objects.equals(key, user1.getUserId())){
                    userMap.put(key,balance);
                }
            }
        } else if (expense == Expense.EXACT) {
            for (String key:userMap.keySet()){
                if(userShare.containsKey(key)){
                    float balance = (amount - userShare.get(key)) + userMap.get(key);
                    userMap.put(key,balance);
                }
            }
        } else if (expense == Expense.PERCENT) {
            for (String key:userMap.keySet()){
                if (userShare.containsKey(key)){
                    float balance = (amount * (userShare.get(key) / 100)) + userMap.get(key);
                    userMap.put(key,balance);
                }
            }
        }
        System.out.println(userMap);

        return "Call Splitwise";
    }

    public String showBalance(String show){
        if( userMap.values().stream().allMatch(value -> value == 0)){
            return "No Balance";
        }else{
            for(Map.Entry<String,Float> entry:userMap.entrySet()){
                String key = entry.getKey();
                Float value = entry.getValue();
                System.out.println("Balance for " + key + " is " + "Rs. " + value);
            }
        }
        return "";
    }

}
