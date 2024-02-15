package org.example;

import org.example.Entity.Expense;
import org.example.Entity.ExpenseType;
import org.example.Entity.User;
import org.example.Service.ExpenseService;
import org.example.Service.ExpenseServiceImpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user1 = new User("1","Hitansh","hitansh@gmail.com","1234567890");
        User user2 = new User("2","Hitansh1","hitansh@gmail.com","1234567890");
        User user3 = new User("3","Hitansh2","hitansh@gmail.com","1234567890");

        ExpenseServiceImpl expenseServiceImpl = new ExpenseServiceImpl();
        expenseServiceImpl.addUser(user1);
        expenseServiceImpl.addUser(user2);
        expenseServiceImpl.addUser(user3);

        Map<User,Double> userShare = new HashMap<>();
        userShare.put(user1,30.0);
        userShare.put(user2,20.0);
        userShare.put(user3,50.0);

        Expense expense = new Expense(user2, Arrays.asList(user1,user2,user3), ExpenseType.EXACT,100.0,userShare);

        expenseServiceImpl.addExpense(expense);

        expenseServiceImpl.showBalance();
    }
}