package app.services.interfaces;

import app.domain.dtos.JSON.importDtos.AccountJsonImportDto;
import app.domain.dtos.XML.export.AccountXmlExportDto;
import app.domain.dtos.XML.importXml.AccountImportXmlDto;
import app.domain.dtos.XML.importXml.AccountsImportXmlDto;
import app.domain.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */
@Service
public interface AccountService {
    void addAccount(Account account);

    void removeAccount(Account account);

    void addAccount(AccountJsonImportDto accountDto);

    void addAccount(AccountImportXmlDto accountDto);

    AccountsImportXmlDto findAll();
}
