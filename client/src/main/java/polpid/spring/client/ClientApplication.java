package polpid.spring.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextListener;

import java.security.Principal;

@SpringBootApplication
@RestController
public class ClientApplication {

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
