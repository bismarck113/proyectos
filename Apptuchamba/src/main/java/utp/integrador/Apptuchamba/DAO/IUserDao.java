/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp.integrador.Apptuchamba.DAO;

import org.springframework.data.repository.CrudRepository;

import utp.integrador.Apptuchamba.models.Users;

/**
 *
 * @author Usuario
 */
public interface IUserDao extends CrudRepository<Users,Integer>{
	public Users findByUsername(String username);
    
}
