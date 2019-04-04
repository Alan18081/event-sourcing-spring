package com.alex.eventsourcingspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class AccountEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String accountNumber;
    private AccountEventType accountEventType = AccountEventType.PENDING;
    private long timestamp;

    public AccountEvent() {
        timestamp = new Date().getTime();
    }

    public AccountEvent(AccountEventType accountEventType) {
        this.accountEventType = accountEventType;
    }

    public AccountEvent(String accountNumber, AccountEventType accountEventType) {
        this.accountNumber = accountNumber;
        this.accountEventType = accountEventType;
    }

    public AccountEventType getAccountEventType() {
        return accountEventType;
    }

    public void setAccountEventType(AccountEventType accountEventType) {
        this.accountEventType = accountEventType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
