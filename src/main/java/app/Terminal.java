package app;


import app.domain.dtos.JSON.importDtos.AccountJsonImportDto;
import app.domain.dtos.JSON.importDtos.BankJsonImportDto;
import app.domain.dtos.JSON.importDtos.ClientJsonImportDto;
import app.domain.dtos.XML.importXml.AccountImportXmlDto;
import app.domain.dtos.XML.importXml.AccountsImportXmlDto;
import app.io.interfaces.FileIO;
import app.parser.interfaces.FileParser;
import app.services.interfaces.AccountService;
import app.services.interfaces.BankService;
import app.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by krisitown on 02.12.16.
 */
@Component
public class Terminal implements CommandLineRunner {
    @Autowired
    private FileIO fileIO;

    @Autowired
    @Qualifier("JSONParser")
    private FileParser jsonParser;

    @Autowired
    @Qualifier("XMLParser")
    private FileParser xmlParser;

    @Autowired
    private BankService bankService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... strings) throws Exception {
        importBanksFromJson();
        importClientsFromJson();
        importAccountsFromJson();
        exportClientsToJson();
        importAccountsFromXml();
        exportAccountsToXml();
    }

    private void importBanksFromJson() {
        BankJsonImportDto[] bankDtos = null;
        try {
            bankDtos = jsonParser.read(BankJsonImportDto[].class, "/files/jsons/banks.json");
        } catch (Exception exc){
            exc.printStackTrace();
        }

        for (BankJsonImportDto bankDto : bankDtos) {
            bankService.addBank(bankDto);
        }
    }

    private void importClientsFromJson() {
        ClientJsonImportDto[] clientDtos = null;
        try {
            clientDtos = jsonParser.read(ClientJsonImportDto[].class, "/files/jsons/clients.json");
        } catch (Exception exc){
            exc.printStackTrace();
        }

        for (ClientJsonImportDto clientDto : clientDtos) {
            clientService.register(clientDto);
        }
    }

    private void importAccountsFromJson() {
        AccountJsonImportDto[] accountDtos = null;

        try{
            accountDtos = jsonParser.read(AccountJsonImportDto[].class, "/files/jsons/accounts.json");
        }catch(Exception exc){
            exc.printStackTrace();
        }

        for (AccountJsonImportDto accountDto : accountDtos) {
            accountService.addAccount(accountDto);

        }

    }

    private void exportClientsToJson() {
        Object[] clientDtos = clientService.getClients().toArray();
        try {
            jsonParser.write(clientDtos, "src/main/resources/files/jsons/export.json");
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }

    private void importAccountsFromXml(){
        AccountsImportXmlDto accountsDto = null;
        try {
            accountsDto = xmlParser.read(AccountsImportXmlDto.class, "/files/jsons/xmls/account.xml");
        } catch (Exception exc){
            exc.printStackTrace();
        }

        for (AccountImportXmlDto accountDto : accountsDto.getAccounts()) {
            accountService.addAccount(accountDto);
        }

    }

    private void exportAccountsToXml(){
        AccountsImportXmlDto accountsDto = accountService.findAll();

        try{
            xmlParser.write(accountsDto, "src/main/resources/files/jsons/xmls/export.xml");
        } catch (Exception exc){
            exc.printStackTrace();
        }
    }
}