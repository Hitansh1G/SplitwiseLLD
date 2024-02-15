package org.example.Entity;

import java.util.List;
import java.util.Map;

public class Expense {
    private User paidBy;
    private List<User>userInvolved;
    private ExpenseType expenseType;
    private double amount;
    private Map<User, Double>userShare;

    public Expense(User paidBy, List<User> userInvolved, ExpenseType expenseType, double amount, Map<User, Double> userShare) {
        this.paidBy = paidBy;
        this.userInvolved = userInvolved;
        this.expenseType = expenseType;
        this.amount = amount;
        this.userShare = userShare;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getUserInvolved() {
        return userInvolved;
    }

    public void setUserInvolved(List<User> userInvolved) {
        this.userInvolved = userInvolved;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Map<User, Double> getUserShare() {
        return userShare;
    }

    public void setUserShare(Map<User, Double> userShare) {
        this.userShare = userShare;
    }
}
