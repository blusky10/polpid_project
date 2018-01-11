//package polpid.spring.client.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import polpid.spring.client.account.service.AccountService;
//import polpid.spring.client.security.CustomUserDetails;
//import polpid.spring.client.security.handler.LoginFailureHandler;
//import polpid.spring.client.security.handler.LoginSuccessHandler;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/login/**").permitAll()
//                .antMatchers("/private/**").authenticated()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .successHandler(new LoginSuccessHandler())
//                .failureHandler(new LoginFailureHandler())
//                .and()
//                .logout().permitAll()
//                .and()
//                .sessionManagement()
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(true);
//    }
//
//    @Autowired
//    private AccountService accountService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> new CustomUserDetails(accountService.get(username)));
//    }
//
//    // CustomUserDetailService 사용할 경우
////    @Autowired
////    private CustomUserDetailService customUserDetailService;
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(this.customUserDetailService);
////    }
//}
//
