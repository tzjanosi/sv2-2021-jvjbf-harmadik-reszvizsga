package vehiclerental;

public class User implements Comparable<User>{
    private String userName;
    private String email;
    private int amount;

    public User(String userName, String email, int amount) {
        this.userName = userName;
        this.email = email;
        this.amount = amount;
    }

    public void minusBalance(int amount){
        this.amount-=amount;
    }

    @Override
    public int compareTo(User o) {
        return userName.compareTo(o.userName);
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return amount;
    }
}
