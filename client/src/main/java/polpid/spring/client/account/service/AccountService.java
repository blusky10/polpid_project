package polpid.spring.client.account.service;


import polpid.spring.client.domain.Account;
import polpid.spring.client.domain.Role;

import java.util.List;

public interface AccountService {
    Account get(String loginId);

    List<Account> getAll();

    void update(Account account, Role role);
//
    void create(Account account, Role role);
//
//    void delete(String loginId);

}
