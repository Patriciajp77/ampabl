package com.ampa.bl.bl.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsServiceImpl uds;
		
			
		//Para enciptar:
		@Bean
		public BCryptPasswordEncoder encriptar() {
			return new BCryptPasswordEncoder();
		}
		

		// programo la autenticacion (¿Quién eres?), sobre los usuarios de la base de datos
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {			
			auth.userDetailsService(uds).passwordEncoder(encriptar());

		}

		// programo la autorizacion (Una vez identificado, ¿A qué recursos tengo acceso?)

		@Override
			protected void configure(HttpSecurity http) throws Exception {	
			
			http
			.authorizeRequests()
				.antMatchers("/","/webjars/**","/public/**","/static/**","/css/**","/public/**","/auth/**","/files/**").permitAll()
				.antMatchers("/","/index").permitAll()
				.antMatchers("/","/user/**").hasAnyRole("USER","ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")
				
				.and()
			.formLogin()
				.loginPage("/login")
		
				.defaultSuccessUrl("/zonaprivada",true)
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout()
				.permitAll()
				.logoutSuccessUrl("/login?logout");
			// Cuando un usuario no tenga permiso para un recurso

			http.exceptionHandling().accessDeniedPage("/403");
			http.csrf().disable();
			http.headers().frameOptions().disable();
			
			
			
			/**
			//Qué url o recursos serán públicos o de acceso por autenticación
			http.authorizeRequests().antMatchers("/webjars/**","/static/**","/css/**").permitAll(); //Para que todos puedan visualizar los estilos
			http.authorizeRequests().antMatchers("/user/**").hasAnyRole("USER","ADMIN");
			http.authorizeRequests().antMatchers("/admin/**","/src/**").hasRole("ADMIN");
		// Para usar un formulario personalizado. Una vez logueado el recurso que devuelve es gestion.html, si no, lanza el error.	
			
		http.formLogin().loginPage("/login").defaultSuccessUrl("/zonaprivada",true).failureUrl("/login?logout");
			
		/

		// Cuando te desconectes, muestra el recurso logout de despedida

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");							
		http.csrf().disable();
		http.headers().frameOptions().disable();
			*/
			}

}
