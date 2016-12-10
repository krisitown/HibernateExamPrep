package app.repositories;

import app.domain.models.Bank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krisitown on 09.12.16.
 */
@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
    @Query("SELECT b FROM Bank AS b WHERE SIZE(b.accounts) > 0")
    Iterable<Bank> findAllBanksWithAccounts();

    Bank findOneByName(String name);
}
