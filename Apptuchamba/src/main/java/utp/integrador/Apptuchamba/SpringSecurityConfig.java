package utp.integrador.Apptuchamba;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import utp.integrador.Apptuchamba.service.JpaUserDetailService;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private CustomLoginSuccessHandler successHandler;
	
	@Autowired
	private JpaUserDetailService userDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/","/css/**","/js/**","/img/**","/vendor/**","/layout").permitAll().and().
		authorizeRequests().antMatchers("/h2-console/**").permitAll()
		.antMatchers("/AdmHome").hasAnyRole("administrador")
		.antMatchers("/UserView").hasAnyRole("usuario")
		.antMatchers("/ProveedorHome").hasAnyRole("Proveedor")
		.anyRequest().
		authenticated().
		and()
		.formLogin().loginPage("/login")
		.failureUrl("/login?error=true")
		.successHandler(successHandler)
		.permitAll()
		.and()
		.logout().permitAll();
		
		 http.csrf().disable();
	     http.headers().frameOptions().disable();
	}


	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		build.userDetailsService(userDetailService).passwordEncoder(passEncoder);
		
		/*build.jdbcAuthentication().
		dataSource(dataSource).
		passwordEncoder(passEncoder).
		usersByUsernameQuery("select username, password,status from users where username=?")
		.authoritiesByUsernameQuery("SELECT users.username,authorities.authority from authorities inner join users ON authorities.user_id=users.id where users.username=?");*/
	}

}
