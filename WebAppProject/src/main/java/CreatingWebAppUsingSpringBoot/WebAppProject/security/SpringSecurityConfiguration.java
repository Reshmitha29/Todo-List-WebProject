package CreatingWebAppUsingSpringBoot.WebAppProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService; // Note: In newer Spring Security, InMemoryUserDetailsManager implements UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) { // Inject PasswordEncoder
        UserDetails user1 = User.builder()
                               .username("Reshu")
                               .password(passwordEncoder.encode("pass")) // Encode password here , passwordEncoder.encode() is called to hash the passwords before they are stored.
                               .roles("USER", "ADMIN")
                               .build();

        UserDetails user2 = User.builder()
                               .username("User2")
                               .password(passwordEncoder.encode("2pass"))
                               .roles("USER")
                               .build();

        return new InMemoryUserDetailsManager(user1, user2); // Pass multiple users
        //InMemoryUserDetailsManager stores these users in memory. When a user tries to log in, Spring Security will check against these in-memory users.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}