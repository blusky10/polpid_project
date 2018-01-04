package polpid.spring.client.account.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polpid.spring.client.account.repository.AccountRepository;
import polpid.spring.client.domain.Account;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/all")
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

//    @RequestMapping("/accounts")
//    public String findAccount(Model model){
//        List<Account> accounts = accountRepository.findAll();
//        model.addAttribute("accounts", accounts);
//        return "index";
//    }
}
