package br.com.qualifylead.lead;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
@Controller
@SpringBootApplication
public class LeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadApplication.class, args);
	}
	@Bean
	   public LocaleResolver localeResolver(){
	      return new FixedLocaleResolver(new Locale("pt", "BR"));
	   }
}
