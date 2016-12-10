package app.domain.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by krisitown on 09.12.16.
 */
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double balance;

    @Column(name = "account_name")
    private String accountName;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private Client owner;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
