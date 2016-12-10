package app.domain.dtos.XML.importXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krisitown on 10.12.16.
 */

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountsImportXmlDto {
    @XmlElement(name = "account")
    private List<AccountImportXmlDto> accounts;

    public AccountsImportXmlDto() {
        this.accounts = new ArrayList<>();
    }

    public List<AccountImportXmlDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountImportXmlDto> accounts) {
        this.accounts = accounts;
    }
}
