package app.repositories;

import app.domain.models.Account;
import app.domain.models.Bank;
import app.domain.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by krisitown on 09.12.16.
 */

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findOneByOwner(Client owner);
    Iterable<Account> findAllByBank(Bank bank);
    Account findOneByAccountName(String account);
    List<Account> findAll();
}
