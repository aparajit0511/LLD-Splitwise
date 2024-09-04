package splitwise;

public class User {
    private String userId;
    private String name;
    private String email;
    private int phNumber;

    public User(String userId,String name,String email,int phNumber){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phNumber = phNumber;
    }

    public void getUserDetails(){
        System.out.println("UserId " + userId + " " + name + " having email " + email + " with contact number " + phNumber);
    }
}
