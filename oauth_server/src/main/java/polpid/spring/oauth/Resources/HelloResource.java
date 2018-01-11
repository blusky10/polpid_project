package polpid.spring.oauth.Resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @GetMapping("/principal")
    public Principal getUser(Principal principal){
        return principal;
    }

    @GetMapping
    public String hello(){
        return "hello";
    }
}
