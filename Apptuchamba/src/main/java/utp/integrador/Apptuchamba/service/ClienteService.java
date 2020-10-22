package utp.integrador.Apptuchamba.service;

import utp.integrador.Apptuchamba.models.Cliente;

public interface ClienteService {
	
	public void guardarCliente(Cliente cliente);
	
	public boolean usuarioExistetente(Cliente cliente);

}
