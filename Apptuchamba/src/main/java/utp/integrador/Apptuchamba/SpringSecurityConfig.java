package utp.integrador.Apptuchamba;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/img/**","/vendor/**").permitAll()
		.antMatchers("/AdmHome").hasAnyRole("administrador").anyRequest().
		authenticated().
		and()
		.formLogin().loginPage("/login").
		permitAll()
		.and()
		.logout().permitAll();
	}


	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		build.jdbcAuthentication().
		dataSource(dataSource).
		passwordEncoder(passEncoder).
		usersByUsernameQuery("select username, password,status from users where username=?")
		.authoritiesByUsernameQuery("SELECT users.username,authorities.authority from authorities inner join users ON authorities.user_id=users.id where users.username=?");
	}

}
