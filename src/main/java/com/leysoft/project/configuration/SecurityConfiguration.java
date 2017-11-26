package com.leysoft.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("myUsername").password("myPassword").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/login").anonymous()
			.antMatchers("/logout").authenticated()
		.and().formLogin().loginPage("/login").usernameParameter("username")
			.passwordParameter("password").defaultSuccessUrl("/")
		.and().rememberMe().rememberMeParameter("remenber-me").tokenValiditySeconds(846000)
			.rememberMeCookieName("my-cookie").key("my-key")
		.and().csrf()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
		.and().exceptionHandling().accessDeniedPage("/denied");
	}
}