package utp.integrador.Apptuchamba.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utp.integrador.Apptuchamba.DAO.IUserDao;
import utp.integrador.Apptuchamba.models.Authorities;
import utp.integrador.Apptuchamba.models.Users;


@Service("jpaUserDetailService")
public class JpaUserDetailService implements UserDetailsService {


	
	@Autowired
	private IUserDao usuarioDao;
	private Logger logger=LoggerFactory.getLogger(JpaUserDetailService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users usuario = usuarioDao.findByUsername(username);
		
		if(usuario==null) {
			logger.error("Error login:no existe usuario ' "+username+" ' ");
			throw new UsernameNotFoundException("Nombre de Usuario"+ username+"no existe en el sistema");
		}
		
		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Authorities role: usuario.getAuthoritiesList()) {

			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		if(authorities.isEmpty()) {
			logger.error("Error login:' "+username+" 'No tiene Rol asignado ");
			throw new UsernameNotFoundException("Nombre de Usuario"+ username+"no tiene un rol asigando");
		}
		return new User(username, usuario.getPassword(), usuario.getStatus(), true, true, true, authorities);
		
	
	}

}
