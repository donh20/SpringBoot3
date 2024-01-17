package com.ncamc;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FIFOTransactionAlgorithm {
    public static void executeTransactions(List<Transaction> transactions) {
        int[] dp = new int[101]; // 使用动态规划数组记录每天的交易数量
        int maxHoldingPeriod = 0;

        for (Transaction transaction : transactions) {
            int holdingPeriod = LocalDate.now().compareTo(transaction.getEntryDate()) + 1;

            if (holdingPeriod <= 100) {
                dp[holdingPeriod]++;
                maxHoldingPeriod = Math.max(maxHoldingPeriod, holdingPeriod);
            }
        }

        for (int i = 1; i <= maxHoldingPeriod; i++) {
            System.out.println("Day " + i + ": " + dp[i] + " transaction(s) will expire");
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, LocalDate.of(2022, 1, 1)));
        transactions.add(new Transaction(2, LocalDate.of(2022, 1, 2)));
        transactions.add(new Transaction(3, LocalDate.of(2022, 1, 3)));
        transactions.add(new Transaction(4, LocalDate.of(2022, 1, 4)));
        transactions.add(new Transaction(5, LocalDate.of(2022, 1, 5)));

        // 执行交易
        executeTransactions(transactions);
    }
}