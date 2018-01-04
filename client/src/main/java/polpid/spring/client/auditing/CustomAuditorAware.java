package polpid.spring.client.auditing;



import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import polpid.spring.client.domain.Account;

public class CustomAuditorAware implements AuditorAware<Account> {

    @Override
    public Account getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication || !authentication.isAuthenticated()) {
            return null;
        }
        return (Account) authentication.getPrincipal(); }
}
