package app.services.interfaces;

import app.domain.dtos.JSON.exportDtos.ClientJsonExportDto;
import app.domain.dtos.JSON.importDtos.ClientJsonImportDto;
import app.domain.dtos.XML.importXml.ClientImportXmlDto;
import app.domain.models.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */
@Service
public interface ClientService {
    void register(Client client);

    void delete(Client client);

    void register(ClientJsonImportDto clientDto);

    void register(ClientImportXmlDto clientDto);

    List<ClientJsonExportDto> getClients();
}
