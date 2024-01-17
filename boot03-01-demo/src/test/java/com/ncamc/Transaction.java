package com.ncamc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


class Transaction {
    private int id;
    private LocalDate entryDate;

    public Transaction(int id, LocalDate entryDate) {
        this.id = id;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }
}