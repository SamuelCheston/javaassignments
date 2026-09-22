import java.util.Date;
public class ba {
    int accNum;
    double accBal;
    double interestRate;
    Date dateCreated;

    public static void main(String[] args) {
    }

    public ba(int id, double initBal, double rate) {
        accNum = id;
        accBal = initBal;
        interestRate = rate;
        dateCreated = new Date();
    }

    public void Deposit(double amount) {
        accBal += amount;
    }

    public boolean Withdraw(double amount) {
        if (amount > accBal) {
            System.out.println("Insufficient funds");
            return false;
        } else {
        accBal -= amount;
        return true;
        }
    }

    public void EditRate(double rate) {
        if (rate < 0) {
            System.out.println("Interest rate cannot be negative");
        } else if (rate > 1) {
            System.out.println("Interest rate cannot be greater than 1");
        } else {
            interestRate = rate;
        }
    }
}