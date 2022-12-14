package br.com.qualifylead.lead;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		    .antMatchers("/", "/home").permitAll()
//	    .antMatchers("/").permitAll()
			.anyRequest().authenticated();
			
	        http
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/login?error")
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .logoutSuccessUrl("/login?logout")
            .permitAll();
			
//		.and()
//		.formLogin(form -> form
//				.loginPage("/login")
//				.defaultSuccessUrl("/home", true)
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll());

}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		UserDetails user =
//				 User.builder()
//					.username("master")
//					.password(encoder.encode("123"))
//					.roles("ADM")
//					.build();
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);
//			.withUser(user);
	}
	

}