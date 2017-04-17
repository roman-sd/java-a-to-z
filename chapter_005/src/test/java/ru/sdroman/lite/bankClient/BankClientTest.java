package ru.sdroman.lite.bankClient;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.lite.bankClient.Exception.AccountNotFoundException;
import ru.sdroman.lite.bankClient.Exception.InsufficientFundsException;
import ru.sdroman.lite.bankClient.Exception.UserNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test BankClient class.
 *
 * @author sdroman
 * @since 04.17
 */
public class BankClientTest {

    /**
     * BankClient instance.
     */
    private BankClient bClient;

    /**
     * User.
     */
    private User user;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        bClient = new BankClient();
        user = new User("user", "passport");
    }

    /**
     * Test addUser method.
     */
    @Test
    public void whenAddUserThenAddUserInMap() {
        bClient.addUser(user);
        assertTrue(bClient.getMap().containsKey(user));
    }

    /**
     * Test deleteUser method.
     *
     * @throws UserNotFoundException exception
     */
    @Test
    public void whenDeleteUserThenRemoveUserFromMap() throws UserNotFoundException {
        bClient.addUser(user);
        bClient.deleteUser(user);
        assertFalse(bClient.getMap().containsKey(user));
    }

    /**
     * Test UserNotFoundException in deleteUser.
     *
     * @throws UserNotFoundException exception
     */
    @Test(expected = UserNotFoundException.class)
    public void whenDeleteUserThenThrowException() throws UserNotFoundException {
        BankClient bc = new BankClient();
        bc.deleteUser(user);
    }

    /**
     * Test addAccountToUser method.
     *
     * @throws UserNotFoundException    exception
     * @throws AccountNotFoundException exception
     */
    @Test
    public void whenAddAccountToUserThenAddAccount() throws UserNotFoundException, AccountNotFoundException {
        final double amount = 100;
        Account account = new Account(amount, "001");
        bClient.addUser(user);
        bClient.addAccountToUser(user, account);
        List<Account> expected = Collections.singletonList(account);
        assertThat(bClient.getUserAccount(user), is(expected));
    }

    /**
     * Test UserNotFoundException in addAccountToUser.
     *
     * @throws UserNotFoundException exception
     */
    @Test(expected = UserNotFoundException.class)
    public void whenAddAccountToUserThenThrowException() throws UserNotFoundException {
        final double amount = 100;
        Account account = new Account(amount, "001");
        bClient.addAccountToUser(user, account);
    }

    /**
     * Test deleteAccountFromUser method.
     *
     * @throws UserNotFoundException    exception
     * @throws AccountNotFoundException exception
     */
    @Test
    public void whenDeleteAccountFromUserThenRemoveAccount() throws UserNotFoundException, AccountNotFoundException {
        final double amount = 100;
        Account account = new Account(amount, "001");
        bClient.addUser(user);
        bClient.addAccountToUser(user, account);
        bClient.deleteAccountFromUser(user, account);
        assertThat(bClient.getUserAccount(user), is(Collections.emptyList()));
    }

    /**
     * Test UserNotFoundException in deleteAccountFromUser.
     *
     * @throws UserNotFoundException    exception
     * @throws AccountNotFoundException exception
     */
    @Test(expected = UserNotFoundException.class)
    public void whenDeleteAccountFromUserThenThrowUserNotFoundException() throws UserNotFoundException, AccountNotFoundException {
        final double amount = 100;
        Account account = new Account(amount, "001");
        bClient.deleteAccountFromUser(user, account);
    }

    /**
     * Test AccountNotFoundException in deleteAccountFromUser.
     *
     * @throws UserNotFoundException    exception
     * @throws AccountNotFoundException exception
     */
    @Test(expected = AccountNotFoundException.class)
    public void whenDeleteAccountFromUserThenThrowAccountNotFoundException() throws UserNotFoundException, AccountNotFoundException {
        final double amount = 100;
        Account account = new Account(amount, "001");
        bClient.addUser(user);
        bClient.deleteAccountFromUser(user, account);
    }

    /**
     * Test getUserAccount method.
     *
     * @throws UserNotFoundException exception
     */
    @Test
    public void thenGetUserAccountThenReturnAccountsList() throws UserNotFoundException {
        final double amount = 100;
        Account firstAccount = new Account(amount, "001");
        Account secondAccount = new Account(amount, "002");
        bClient.addUser(user);
        bClient.addAccountToUser(user, firstAccount);
        bClient.addAccountToUser(user, secondAccount);
        List<Account> expected = Arrays.asList(firstAccount, secondAccount);
        assertThat(bClient.getUserAccount(user), is(expected));
    }

    /**
     * Test UserNotFoundException in getUserAccount.
     *
     * @throws UserNotFoundException exception
     */
    @Test(expected = UserNotFoundException.class)
    public void whenGetUserAccountThenUserNotFoundException() throws UserNotFoundException {
        bClient.getUserAccount(user);
    }

    /**
     * Test transferMoney method.
     *
     * @throws UserNotFoundException      exception
     * @throws InsufficientFundsException exception
     * @throws AccountNotFoundException   exception
     */
    @Test
    public void whenTransferMoneyThenTransferMoney()
            throws UserNotFoundException, InsufficientFundsException, AccountNotFoundException {
        final double firstMoney = 400;
        final double secondMoney = 100;
        final double transferMoney = 200;
        User firstUser = new User("user1", "passport1");
        Account firstAccount = new Account(firstMoney, "001");
        bClient.addUser(firstUser);
        bClient.addAccountToUser(firstUser, firstAccount);
        User secondUser = new User("user2", "passport2");
        Account secondAccount = new Account(secondMoney, "002");
        bClient.addUser(secondUser);
        bClient.addAccountToUser(secondUser, secondAccount);
        bClient.transferMoney(firstUser, firstAccount, secondUser, secondAccount, transferMoney);
        double actualFirstUser = bClient.getUserAccount(firstUser).get(0).getValue();
        double actualSecondUser = bClient.getUserAccount(secondUser).get(0).getValue();
        final double expected = 100;
        assertThat(actualSecondUser - actualFirstUser, is(expected));
    }

    /**
     * Test transferMoney method.
     *
     * @throws InsufficientFundsException exception
     * @throws AccountNotFoundException   exception
     * @throws UserNotFoundException      exception
     */
    @Test
    public void whenTransferMoneyThenReturnFalse()
            throws InsufficientFundsException, AccountNotFoundException, UserNotFoundException {
        final double firstMoney = 100;
        final double secondMoney = 500;
        final double transferMoney = 200;
        User firstUser = new User("user1", "passport1");
        Account firstAccount = new Account(firstMoney, "001");
        bClient.addUser(firstUser);
        bClient.addAccountToUser(firstUser, firstAccount);
        User secondUser = new User("user2", "passport2");
        Account secondAccount = new Account(secondMoney, "002");
        bClient.addUser(secondUser);
        bClient.addAccountToUser(secondUser, secondAccount);
        assertFalse(bClient.transferMoney(firstUser, firstAccount, secondUser, secondAccount, transferMoney));
    }

    /**
     * Test transferMoney method.
     *
     * @throws InsufficientFundsException exception
     * @throws AccountNotFoundException   exception
     * @throws UserNotFoundException      exception
     */
    @Test
    public void whenTransferMoneyThenReturnFalse2()
            throws InsufficientFundsException, AccountNotFoundException, UserNotFoundException {
        final double firstMoney = 100;
        final double secondMoney = 500;
        final double transferMoney = 200;
        User firstUser = new User("user1", "passport1");
        Account firstAccount = new Account(firstMoney, "001");
        bClient.addUser(firstUser);
        bClient.addAccountToUser(firstUser, firstAccount);
        User secondUser = new User("user2", "passport2");
        Account secondAccount = new Account(secondMoney, "002");
        assertFalse(bClient.transferMoney(firstUser, firstAccount, secondUser, secondAccount, transferMoney));
    }

    /**
     * Test transferMoney method.
     *
     * @throws InsufficientFundsException exception
     * @throws AccountNotFoundException   exception
     * @throws UserNotFoundException      exception
     */
    @Test
    public void whenTransferMoneyThenReturnFalse3()
            throws InsufficientFundsException, AccountNotFoundException, UserNotFoundException {
        final double firstMoney = 100;
        final double secondMoney = 500;
        final double transferMoney = 200;
        User firstUser = new User("user1", "passport1");
        Account firstAccount = new Account(firstMoney, "001");
        bClient.addUser(firstUser);
        bClient.addAccountToUser(firstUser, firstAccount);
        User secondUser = new User("user2", "passport2");
        Account secondAccount = new Account(secondMoney, "002");
        bClient.addUser(secondUser);
        assertFalse(bClient.transferMoney(firstUser, firstAccount, secondUser, secondAccount, transferMoney));
    }
}
