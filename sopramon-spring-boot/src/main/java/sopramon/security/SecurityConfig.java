package sopramon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/**").hasAnyRole("ADMIN", "USER")
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/perform_login")
		.defaultSuccessUrl("/home", true)
		.failureUrl("/login?error=true")
		.permitAll()
		.and()
		.logout()
		.logoutSuccessUrl("/logout")
		.permitAll();
		}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	
	return new BCryptPasswordEncoder();
	}
}
