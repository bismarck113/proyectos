package utp.integrador.Apptuchamba.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utp.integrador.Apptuchamba.models.Authorities;

@Repository
public interface IRoleDao extends JpaRepository<Authorities, Integer> {
	
	public Authorities findByAuthority(String authority);	


}
