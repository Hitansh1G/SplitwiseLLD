package org.example.Service;

import org.example.Entity.Expense;
import org.example.Entity.User;

public interface ExpenseService {
    public void addUser(User user);
    public void addExpense(Expense expense);
    public void showBalance();
    public void showBalanceForUser(User user);

}
