public class BankAccount {
    private String clintName;
    private String password;
    private int balance;
    private int maxOverdraft;
    private boolean suspended;

    public BankAccount() {}
    public BankAccount(String clintName, String password, int balance, int maxOverDraft, boolean suspended) {
        this.clintName = clintName;
        this.password = password;
        this.balance = balance;
        this.maxOverdraft = maxOverDraft;
        this.suspended = suspended;
    }


    public void deposit(int amount) {
        if (amount > 0)
            this.balance += amount;
        else
            System.out.println("you cannot deposit less than 0");
    }

    public boolean withdrawals(int amount) {
        boolean allow = this.balance + this.maxOverdraft >= amount;
        if (allow) {
            this.balance -= amount;
            return true;
        }
        else {
            System.out.println("You can't withdrawals more than your max overdraft \n");
            return false;
        }
    }



    public String getClintName() {
        return clintName;
    }
    public String getPassword() {
        return password;
    }
    public int getBalance() {
        return balance;
    }
    public boolean isSuspended() {
        return suspended;
    }
    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
    public int getMaxOverdraft() {
        return maxOverdraft;
    }
    public void setClintName(String clintName){
        this.clintName = clintName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setMaxOverdraft(int maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }



    @Override
    public String toString() {
        return "BankAccount{" +"clintName='" + clintName + '\'' +",   password=" + password +
                "  , currentBalance=" + balance +",   Maximum Overdraft=" + maxOverdraft +",   Suspended=" + suspended + '}';
    }
}
