package ru.sdroman.lite.bankClient;

import ru.sdroman.lite.bankClient.Exception.AccountNotFoundException;
import ru.sdroman.lite.bankClient.Exception.InsufficientFundsException;
import ru.sdroman.lite.bankClient.Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class BankClient.
 *
 * @author sdroman
 * @since 04.17
 */
public class BankClient {

    /**
     * Map.
     */
    private Map<User, List<Account>> map;

    /**
     * Constructs a new BankClient object.
     */
    public BankClient() {
        map = new HashMap<>();
    }

    /**
     * Adds users.
     *
     * @param user User
     */
    public void addUser(User user) {
        map.put(user, new ArrayList<>());
    }

    /**
     * Deletes user.
     *
     * @param user User.
     * @throws UserNotFoundException exception
     */
    public void deleteUser(User user) throws UserNotFoundException {
        if (map.containsKey(user)) {
            map.remove(user);
        } else {
            throw new UserNotFoundException("User not found.");
        }
    }

    /**
     * Adds account to user.
     *
     * @param user    User
     * @param account Account
     * @throws UserNotFoundException exception
     */
    public void addAccountToUser(User user, Account account) throws UserNotFoundException {
        if (map.containsKey(user)) {
            map.get(user).add(account);
        } else {
            throw new UserNotFoundException("User not found.");
        }
    }

    /**
     * Deletes account from user.
     *
     * @param user    User
     * @param account Account
     * @throws UserNotFoundException    exception
     * @throws AccountNotFoundException exception
     */
    public void deleteAccountFromUser(User user, Account account)
            throws UserNotFoundException, AccountNotFoundException {
        List<Account> accounts;
        if (map.containsKey(user)) {
            accounts = map.get(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
        if (accounts.contains(account)) {
            accounts.remove(account);
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }

    /**
     * Returns list of user's accounts.
     *
     * @param user User
     * @return List
     * @throws UserNotFoundException exception
     */
    public List<Account> getUserAccount(User user) throws UserNotFoundException {
        if (!map.containsKey(user)) {
            throw new UserNotFoundException("Account not found.");
        }
        return map.get(user);
    }

    /**
     * Transfer.
     *
     * @param account Account
     * @param amount  double
     * @return Account
     * @throws InsufficientFundsException exception
     */
    private Account transfer(Account account, double amount) throws InsufficientFundsException {
        double d = account.getValue() + amount;
        if (d >= 0) {
            account.setValue(d);
        } else {
            throw new InsufficientFundsException("insufficient funds.");
        }
        return account;
    }

    /**
     * Returns index of account in list.
     *
     * @param list    List<Account>
     * @param account Account
     * @return int
     * @throws AccountNotFoundException exception
     */
    private int getIndex(List<Account> list, Account account) throws AccountNotFoundException {
        if (!list.contains(account)) {
            throw new AccountNotFoundException("Account not found.");
        }
        return list.indexOf(account);
    }

    /**
     * Transfer money.
     *
     * @param srcUser    User
     * @param srcAccount Account
     * @param dstUser    User
     * @param dstAccount Account
     * @param amount     double
     * @return boolean
     * @throws InsufficientFundsException exception
     * @throws AccountNotFoundException   exception
     * @throws UserNotFoundException      exception
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount)
            throws InsufficientFundsException, AccountNotFoundException, UserNotFoundException {
        try {
            List<Account> srcList = getUserAccount(srcUser);
            List<Account> dstList = getUserAccount(dstUser);
            int srcIndex = getIndex(srcList, srcAccount);
            int dstIndex = getIndex(dstList, dstAccount);
            srcList.set(srcIndex, transfer(srcList.get(srcIndex), -amount));
            dstList.set(dstIndex, transfer(dstList.get(dstIndex), amount));
        } catch (InsufficientFundsException | AccountNotFoundException | UserNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Returns map.
     *
     * @return HashMap
     */
    public Map<User, List<Account>> getMap() {
        return map;
    }
}
