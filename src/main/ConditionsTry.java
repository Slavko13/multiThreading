package main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionsTry {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountBalance(18);
        AccountBalancePlus plusThread = new AccountBalancePlus();
        AccountBalanceMinus minusThread = new AccountBalanceMinus();
        plusThread.setAccount(account);
        minusThread.setAccount(account);
        plusThread.start();
        minusThread.start();
    }

    static public class Account {
        private int accountBalance;

        public int getAccountBalance() {
            return accountBalance;
        }

        public void setAccountBalance(int accountBalance) {
            this.accountBalance = accountBalance;
        }
    }

    static public class AccountBalanceMinus extends Thread {
        private Account account;

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            if (account.getAccountBalance() < 30) {
                try {
                    lock.lock();
                    System.out.println("account before await " + account.getAccountBalance());
                    condition.signal();
                    condition.await();
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.lock();
            account.setAccountBalance(account.getAccountBalance()-8);
            System.out.println("account after minus " + account.getAccountBalance());
            condition.signal();
            lock.unlock();
        }
    }

    static public class AccountBalancePlus extends Thread{
        private Account account;

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            while (account.getAccountBalance() < 50) {
                lock.lock();
                account.setAccountBalance(account.getAccountBalance() + 11);
                System.out.println("account after plus " + account.getAccountBalance());
                condition.signal();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

}
