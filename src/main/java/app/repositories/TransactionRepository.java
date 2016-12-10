package app.repositories;

import app.domain.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krisitown on 09.12.16.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
