/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp.integrador.Apptuchamba.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "proveedores")
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findByIdproveedor", query = "SELECT p FROM Proveedores p WHERE p.idproveedor = :idproveedor")
    , @NamedQuery(name = "Proveedores.findByUsuario", query = "SELECT p FROM Proveedores p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "Proveedores.findByContrase\u00f1a", query = "SELECT p FROM Proveedores p WHERE p.contrase\u00f1a = :contrase\u00f1a")
    , @NamedQuery(name = "Proveedores.findByEmail", query = "SELECT p FROM Proveedores p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedores.findByApellido", query = "SELECT p FROM Proveedores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Proveedores.findByDni", query = "SELECT p FROM Proveedores p WHERE p.dni = :dni")
    , @NamedQuery(name = "Proveedores.findByCiudad", query = "SELECT p FROM Proveedores p WHERE p.ciudad = :ciudad")
    , @NamedQuery(name = "Proveedores.findByDistrito", query = "SELECT p FROM Proveedores p WHERE p.distrito = :distrito")
    , @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Proveedores.findByCelular", query = "SELECT p FROM Proveedores p WHERE p.celular = :celular")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_proveedor")
    private Integer idproveedor;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "Dni")
    private int dni;
    @Basic(optional = false)
    @Column(name = "Ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "Distrito")
    private String distrito;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "Celular")
    private String celular;
    @JoinColumn(name = "id_Profesion", referencedColumnName = "id_profesion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesiones idProfesion;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userId;

    public Proveedores() {
    }

    public Proveedores(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Proveedores(Integer idproveedor, String usuario, String contraseña, String email, String nombre, String apellido, int dni, String ciudad, String distrito, String direccion, String celular) {
        this.idproveedor = idproveedor;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.direccion = direccion;
        this.celular = celular;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Profesiones getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Profesiones idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utp.integrador.Apptuchamba.Proveedores[ idproveedor=" + idproveedor + " ]";
    }
    
}
