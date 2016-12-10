package app.domain.dtos.JSON.importDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by krisitown on 09.12.16.
 */
public class BankJsonImportDto implements Serializable{

    @Expose
    private String name;

    public BankJsonImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
