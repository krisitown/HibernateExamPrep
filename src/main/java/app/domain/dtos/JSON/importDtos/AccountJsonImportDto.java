package app.domain.dtos.JSON.importDtos;

import app.domain.models.Account;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by krisitown on 09.12.16.
 */

public class AccountJsonImportDto implements Serializable {
    @Expose
    @SerializedName("account_name")
    private String accountName;

    @Expose
    private String bank;

    @Expose
    private String owner;

    @Expose
    private double balance;

    public AccountJsonImportDto() {

    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
