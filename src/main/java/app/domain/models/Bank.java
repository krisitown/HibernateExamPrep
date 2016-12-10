package app.domain.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krisitown on 09.12.16.
 */

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    private Collection<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }
}
