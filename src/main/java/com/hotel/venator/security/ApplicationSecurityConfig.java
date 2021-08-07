package com.hotel.venator.security;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.hotel.venator.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable().
			authorizeRequests().
			antMatchers("/", "index", "/css/**", "/images/**", "/javascript/**", "/v1/booking/**", "/v1/comment/**").permitAll()
			.antMatchers("/api/**").hasRole(BASICUSER.name()).
			anyRequest().
			authenticated().
			and().
			formLogin()
				.loginPage("/login").
				permitAll().
				defaultSuccessUrl("/courses", true).
				passwordParameter("password").
				usernameParameter("username").
			and().
			rememberMe()
				.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).
				key("somethingverysecured").
				rememberMeParameter("remember-me").
			and().
			logout().
				logoutUrl("/logout").
				logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).
				clearAuthentication(true).
				invalidateHttpSession(true).
				deleteCookies("JSESSIONID", "remember-me").
				logoutSuccessUrl("/login");
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails aliceSmith = User.builder().username("AliceS").password(passwordEncoder.encode("test1"))
				.authorities(BASICUSER.getGrantedAuthorities()).build();

		UserDetails johnDoe = User.builder().username("JohnD").password(passwordEncoder.encode("password123"))
				.authorities(ADMIN.getGrantedAuthorities()).build();

		return new InMemoryUserDetailsManager(aliceSmith, johnDoe);

	}

}
