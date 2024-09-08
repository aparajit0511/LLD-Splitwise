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

    public void callSplitwise(User user1,int total_users, float amount, List<User> users, Expense expense,List<Float> contri,float[] percent) throws InvalidAmountException {
        Map<String,Float> userShare = new HashMap<>();
        if (contri != null && !contri.isEmpty()){
            int  i = 0;

            for (User user:users){
                userShare.put(user.getUserId(), contri.get(i));
                i += 1;
            }
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
                float sum = 0;
                for (String key:userMap.keySet()){
                    if(userShare.containsKey(key)){
                        float checkbalance = (amount - userShare.get(key));
                        float balance = (amount - userShare.get(key)) + userMap.get(key);
                        sum += checkbalance;
                        userMap.put(key,balance);
                    }
                }
                if (sum != amount) {
                    throw new InvalidAmountException("Please enter the correct amount");
                }

        } else if (expense == Expense.PERCENT) {
            float sum = 0;
            for (String key:userMap.keySet()){
                if (userShare.containsKey(key)){
                    float checkbalance = (amount * (userShare.get(key) / 100));
                    float balance = (amount * (userShare.get(key) / 100)) + userMap.get(key);
                    float roundedValue = Math.round(checkbalance * 100) / 100f;
                    sum += checkbalance;
                    userMap.put(key,balance);
                }
            }
            if(sum != amount){
                throw new InvalidAmountException("Please enter the correct percent");
            }
        }

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
