package org.example.Service;

import org.example.Entity.Expense;
import org.example.Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {
    private List<User> userList;
    private List<Expense> expenseList;
    private Map<User, Map<User, Double>> balances;

    public ExpenseServiceImpl() {
        userList = new ArrayList<>();
        expenseList = new ArrayList<>();
        balances = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void addExpense(Expense expense) {
        expenseList.add(expense);
        updateBalance(expense);
    }

    public void updateBalance(Expense expense) {
        User paidBy = expense.getPaidBy();
        double totalAmount = expense.getAmount();
        Map<User, Double> userShares = expense.getUserShare();

        for (User user : expense.getUserInvolved()) {
            double share = userShares.getOrDefault(user, 0.0);
            double amountPaidByUser;

            switch (expense.getExpenseType()) {
                case PERCENT:
                    double sharePercentage = share / 100.0;
                    amountPaidByUser = totalAmount * sharePercentage;
                    break;
                case EXACT:
                    amountPaidByUser = totalAmount - share;
                    break;
                case EQUAL:
                    amountPaidByUser = totalAmount / expense.getUserInvolved().size();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid expense type");
            }

            if (user.equals(paidBy)) {
                amountPaidByUser = totalAmount - amountPaidByUser; // Subtracting the share for the payer
            } else {
                amountPaidByUser = amountPaidByUser; // Others owe the payer their respective share
            }

            balances.computeIfAbsent(user, k -> new HashMap<>());
            balances.computeIfAbsent(paidBy, k -> new HashMap<>());
            balances.get(user).put(paidBy, balances.get(user).getOrDefault(paidBy, 0.0) + amountPaidByUser);
        }
    }

    @Override
    public void showBalance() {
        for (User user : userList) {
            Map<User, Double> userBalance = balances.getOrDefault(user, new HashMap<>());
            for (Map.Entry<User, Double> entry : userBalance.entrySet()) {
                User personGiving = entry.getKey();
                double amount = entry.getValue();
                if (!personGiving.equals(user) && Math.abs(amount) > 0.01) { // Check for rounding errors
                    System.out.println(user.getName() + " owes " + personGiving.getName() + " : " + String.format("%.2f", amount));
                }
            }
        }
    }

    @Override
    public void showBalanceForUser(User user) {
        Map<User, Double> userBalance = balances.getOrDefault(user, new HashMap<>());
        for (Map.Entry<User, Double> entry : userBalance.entrySet()) {
            User personGiving = entry.getKey();
            double amount = entry.getValue();
            System.out.println(user.getName() + " owes " + personGiving.getName() + " : " + String.format("%.2f", amount));
        }
    }
}
