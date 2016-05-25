package com.gurubelli.surya.concurrency;

public class Deadlock {
    double balance;
    int id;
     
    Deadlock(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }
     
    void withdraw(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance -= amount;
    }
     
    void deposit(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance += amount;
    }
     
    static void transfer(Deadlock from, Deadlock to, double amount) {
        synchronized(from) {
            from.withdraw(amount);
            synchronized(to) {
                to.deposit(amount);
            }
        }
    }
     
    public static void main(String[] args) {
        final Deadlock fooAccount = new Deadlock(1, 100d);
        final Deadlock barAccount = new Deadlock(2, 100d);
         
        new Thread() {
            public void run() {
                Deadlock.transfer(fooAccount, barAccount, 10d);
            }
        }.start();
         
        new Thread() {
            public void run() {
                Deadlock.transfer(barAccount, fooAccount, 10d);
            }
        }.start();
         
    }
}

// Deadlock avoidance ... lock ordering ..type name = new type(arguments);
//OpenCalls .. calls with no lock held
//Deadlock avoidance and diagnosis
//10.2.1 : Timed Lock Attempts 
// Deadlock analysis with thread dumps
//10.3 :  Starvation : due to improper use of thread priorities , executing non terminating threads
//Poor responsiveness : 