package app.domain.dtos.JSON.importDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by krisitown on 09.12.16.
 */
public class ClientJsonImportDto implements Serializable {
    @Expose
    private String name;

    @Expose
    private String town;

    @Expose
    private String account;

    public ClientJsonImportDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
