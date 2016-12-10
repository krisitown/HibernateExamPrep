package app.repositories;

import app.domain.dtos.JSON.exportDtos.ClientJsonExportDto;
import app.domain.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findOneByName(String name);
    List<Client> findAll();
}
