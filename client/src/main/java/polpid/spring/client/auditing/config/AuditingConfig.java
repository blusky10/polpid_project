package polpid.spring.client.auditing.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import polpid.spring.client.auditing.CustomAuditorAware;

@EnableJpaAuditing
@Configuration
public class AuditingConfig {

    @Bean
    CustomAuditorAware auditorAware() {
        return new CustomAuditorAware();
    }
}
