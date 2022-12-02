package br.com.qualifylead.lead;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication(scanBasePackages = { "br.com.qualifylead.lead", "br.com.qualifylead.lead.domain", "br.com.qualifylead.lead.EntityDao "})
//@EnableJpaRepositories(basePackages = { "br.com.qualifylead "}) @EntityScan(basePackages = { "br.com.qualifylead" })
public class LeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadApplication.class, args);
	}
	@Bean
	   public LocaleResolver localeResolver(){
	      return new FixedLocaleResolver(new Locale("pt", "BR"));
	   }
}
