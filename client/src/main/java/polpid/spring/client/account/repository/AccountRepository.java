package polpid.spring.client.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polpid.spring.client.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByLoginId(String loginId);
}
