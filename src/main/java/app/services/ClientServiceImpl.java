package app.services;

import app.domain.dtos.JSON.exportDtos.ClientJsonExportDto;
import app.domain.dtos.JSON.importDtos.ClientJsonImportDto;
import app.domain.dtos.XML.importXml.ClientImportXmlDto;
import app.domain.models.Client;
import app.repositories.AccountRepository;
import app.repositories.ClientRepository;
import app.services.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void register(Client client) {
        if(client.getName().isEmpty()){
            throw new IllegalArgumentException("EI SHTI IBA MAIKATA MUHLIO.");
        }
        clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void register(ClientJsonImportDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setTown(clientDto.getTown());
        client.setAccount(accountRepository.findOneByAccountName(clientDto.getAccount()));
        clientRepository.save(client);
    }

    @Override
    public void register(ClientImportXmlDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setTown(clientDto.getTown());
        clientRepository.save(client);
    }

    @Override
    public List<ClientJsonExportDto> getClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientJsonExportDto> clientDtos = new ArrayList<>();

        for (Client client : clients) {
            ClientJsonExportDto clientDto = new ClientJsonExportDto();
            clientDto.setName(client.getName());
            clientDto.setBalance(client.getAccount().getBalance());
            clientDto.setTown(client.getTown());
            clientDto.setBankName(client.getAccount().getBank().getName());

            clientDtos.add(clientDto);
        }

        return clientDtos;
    }


}
