// Bank.java
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Initial deposit must be positive");
        }
        int newAccountNumber = accounts.size() + 1;
        BankAccount newAccount = new BankAccount(newAccountNumber, accountName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws NegativeAmountException, InsufficientFundsException, AccountNotFoundException {
        if (amount < 0) {
            throw new NegativeAmountException("Amount must be positive");
        }
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
