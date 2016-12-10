package app.services;

import app.domain.dtos.JSON.importDtos.BankJsonImportDto;
import app.domain.dtos.XML.importXml.BankImportXmlDto;
import app.domain.models.Bank;
import app.repositories.BankRepository;
import app.services.interfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by krisitown on 09.12.16.
 */
@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public void addBank(Bank bank) {
        if (bank.getName().isEmpty()){
            throw new IllegalArgumentException("Stiga s tiq banki e");
        }

        bankRepository.save(bank);
    }

    @Override
    public void removeBank(Bank bank) {
        bankRepository.delete(bank);
    }

    @Override
    public void addBank(BankJsonImportDto bankDto) {
        Bank bank = new Bank();
        bank.setName(bankDto.getName());

        bankRepository.save(bank);
    }

    @Override
    public void addBank(BankImportXmlDto bankDto) {
        Bank bank = new Bank();

        bank.setName(bankDto.getName());

        bankRepository.save(bank);
    }

}
