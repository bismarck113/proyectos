package utp.integrador.Apptuchamba;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	protected void  handle(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException {
		
		String targeturl=DetRedirecionUrl(authentication);
		if(response.isCommitted()) {
			return;
			
		}
		RedirectStrategy re = new DefaultRedirectStrategy();
		re.sendRedirect(request, response, targeturl);
	}

	protected String DetRedirecionUrl(Authentication aut) {
		
		String url="/login?error=true";
		
		Collection<? extends GrantedAuthority> authorities =aut.getAuthorities();
		List<String> roles= new ArrayList<String>();
		for(GrantedAuthority a :authorities) {
			
			roles.add(a.getAuthority());
		}
		if(roles.contains("administrador")) {
			url="/adm";
		}
		if(roles.contains("proveedor")) {
			url="/proveedor";
		}
		if(roles.contains("cliente")) {
			url="/cliente";
		}
		return url;
		
		
	}
}

