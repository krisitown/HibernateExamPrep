package app.services;

import app.domain.dtos.JSON.importDtos.AccountJsonImportDto;
import app.domain.dtos.XML.importXml.AccountImportXmlDto;
import app.domain.dtos.XML.importXml.AccountsImportXmlDto;
import app.domain.models.Account;
import app.parser.interfaces.ModelParser;
import app.repositories.AccountRepository;
import app.repositories.BankRepository;
import app.repositories.ClientRepository;
import app.services.interfaces.AccountService;
import app.services.interfaces.BankService;
import app.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private ModelParser modelParser;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BankService bankService;

    @Override
    public void addAccount(Account account) {
        if(account.getBalance() < 0){
            throw new IllegalArgumentException("You are in debt MOTHERFUCKA");
        }

        accountRepository.save(account);
    }

    @Override
    public void removeAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void addAccount(AccountJsonImportDto accountDto) {
        Account account = new Account();
        account.setBalance(accountDto.getBalance());
        account.setAccountName(accountDto.getAccountName());
        account.setOwner(clientRepository.findOneByName(accountDto.getOwner()));
        account.setBank(bankRepository.findOneByName(accountDto.getBank()));
        accountRepository.save(account);
    }

    @Override
    public void addAccount(AccountImportXmlDto accountDto) {
        Account account = new Account();
        account.setAccountName(accountDto.getAccountName());
        clientService.register(accountDto.getOwner());
        bankService.addBank(accountDto.getBank());
        account.setOwner(clientRepository.findOneByName(accountDto.getOwner().getName()));
        account.setBank(bankRepository.findOneByName(accountDto.getBank().getName()));
        accountRepository.save(account);
    }

    @Override
    public AccountsImportXmlDto findAll() {
        List<Account> accounts = accountRepository.findAll();
        AccountsImportXmlDto accountsDto = new AccountsImportXmlDto();
        List<AccountImportXmlDto> accountsDtoList = new ArrayList<>();
        for (Account account : accounts) {
            AccountImportXmlDto accountDto = new AccountImportXmlDto();
            accountDto.setAccountName(account.getAccountName());
            accountDto.setBalance(account.getBalance());
            accountsDtoList.add(accountDto);
        }
        accountsDto.setAccounts(accountsDtoList);
        return accountsDto;
    }


}
