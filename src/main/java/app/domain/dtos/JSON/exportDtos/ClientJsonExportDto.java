package app.domain.dtos.JSON.exportDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by krisitown on 09.12.16.
 */
public class ClientJsonExportDto implements Serializable {
    @Expose
    private String name;

    @Expose
    private String bankName;

    @Expose String town;

    @Expose
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
