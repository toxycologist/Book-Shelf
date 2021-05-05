package pl.kiepura.Book.Shelf.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static pl.kiepura.Book.Shelf.security.ApplicationUserPermission.BOOK_MODIFY;
import static pl.kiepura.Book.Shelf.security.ApplicationUserRole.GUEST;
import static pl.kiepura.Book.Shelf.security.ApplicationUserRole.OWNER;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/books/all").permitAll()
                .antMatchers("/api/books/authors").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/**").hasAuthority(BOOK_MODIFY.getPermission())
                .antMatchers(HttpMethod.POST, "/api/**").hasAuthority(BOOK_MODIFY.getPermission())
                .antMatchers(HttpMethod.PUT, "/api/**").hasAuthority(BOOK_MODIFY.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/api/books/all")
                .and()
                .httpBasic();
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin1"))
                .authorities(OWNER.getGrantedAuthority())
                .build();

        UserDetails guest = User.builder()
                .username("guest")
                .password(passwordEncoder.encode("guest1"))
                .roles(GUEST.name())
                .build();

        return new InMemoryUserDetailsManager(
                admin, guest
        );

    }
}
