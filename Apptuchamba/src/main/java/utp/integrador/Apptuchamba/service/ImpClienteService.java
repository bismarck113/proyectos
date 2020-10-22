package utp.integrador.Apptuchamba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import utp.integrador.Apptuchamba.DAO.IClienteDao;
import utp.integrador.Apptuchamba.DAO.IRoleDao;
import utp.integrador.Apptuchamba.DAO.IUserDao;
import utp.integrador.Apptuchamba.models.Cliente;
import utp.integrador.Apptuchamba.models.Users;

@Service
public class ImpClienteService implements ClienteService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	IRoleDao rolrepository;
	@Autowired
	IClienteDao clirepository;
	@Override
	public void guardarCliente(Cliente cliente) {
	
	}

	@Override
	public boolean usuarioExistetente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

}
