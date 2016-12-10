package app.domain.dtos.XML.importXml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by krisitown on 10.12.16.
 */

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountImportXmlDto implements Serializable {

    @XmlAttribute(name = "account-name")
    private String accountName;

    @XmlAttribute(name = "balance")
    private double balance;

    @XmlElement(name = "owner")
    private ClientImportXmlDto owner;

    @XmlElement(name = "bank")
    private BankImportXmlDto bank;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public ClientImportXmlDto getOwner() {
        return owner;
    }

    public void setOwner(ClientImportXmlDto owner) {
        this.owner = owner;
    }

    public BankImportXmlDto getBank() {
        return bank;
    }

    public void setBank(BankImportXmlDto bank) {
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
