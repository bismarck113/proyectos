package utp.integrador.Apptuchamba.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utp.integrador.Apptuchamba.models.Authorities;
import utp.integrador.Apptuchamba.models.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {
	
	
}
