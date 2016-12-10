package app.services.interfaces;

import app.domain.dtos.JSON.importDtos.BankJsonImportDto;
import app.domain.dtos.XML.importXml.BankImportXmlDto;
import app.domain.models.Bank;
import org.springframework.stereotype.Service;

/**
 * Created by krisitown on 09.12.16.
 */
@Service
public interface BankService {
    void addBank(Bank bank);

    void removeBank(Bank bank);

    void addBank(BankJsonImportDto bankDto);

    void addBank(BankImportXmlDto bankDto);
}
