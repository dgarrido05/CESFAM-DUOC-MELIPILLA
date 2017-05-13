/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CES_PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesPersona.findAll", query = "SELECT c FROM CesPersona c")
    , @NamedQuery(name = "CesPersona.findByPerRut", query = "SELECT c FROM CesPersona c WHERE c.perRut = :perRut")
    , @NamedQuery(name = "CesPersona.findByPerDv", query = "SELECT c FROM CesPersona c WHERE c.perDv = :perDv")
    , @NamedQuery(name = "CesPersona.findByPerNombres", query = "SELECT c FROM CesPersona c WHERE c.perNombres = :perNombres")
    , @NamedQuery(name = "CesPersona.findByPerApellidoPaterno", query = "SELECT c FROM CesPersona c WHERE c.perApellidoPaterno = :perApellidoPaterno")
    , @NamedQuery(name = "CesPersona.findByPerApellidoMaterno", query = "SELECT c FROM CesPersona c WHERE c.perApellidoMaterno = :perApellidoMaterno")
    , @NamedQuery(name = "CesPersona.findByPerNombreCompleto", query = "SELECT c FROM CesPersona c WHERE c.perNombreCompleto = :perNombreCompleto")
    , @NamedQuery(name = "CesPersona.findByPerSexo", query = "SELECT c FROM CesPersona c WHERE c.perSexo = :perSexo")
    , @NamedQuery(name = "CesPersona.findByPerFechaNacimiento", query = "SELECT c FROM CesPersona c WHERE c.perFechaNacimiento = :perFechaNacimiento")
    , @NamedQuery(name = "CesPersona.findByPerFechaRegistro", query = "SELECT c FROM CesPersona c WHERE c.perFechaRegistro = :perFechaRegistro")
    , @NamedQuery(name = "CesPersona.findByPerTelefono", query = "SELECT c FROM CesPersona c WHERE c.perTelefono = :perTelefono")
    , @NamedQuery(name = "CesPersona.findByPerEmail", query = "SELECT c FROM CesPersona c WHERE c.perEmail = :perEmail")
    , @NamedQuery(name = "CesPersona.findByPerVigencia", query = "SELECT c FROM CesPersona c WHERE c.perVigencia = :perVigencia")})
public class CesPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_RUT")
    private Integer perRut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_DV")
    private Character perDv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PER_NOMBRES")
    private String perNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PER_APELLIDO_PATERNO")
    private String perApellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PER_APELLIDO_MATERNO")
    private String perApellidoMaterno;
    @Size(max = 110)
    @Column(name = "PER_NOMBRE_COMPLETO")
    private String perNombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_SEXO")
    private Character perSexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaNacimiento;
    @Column(name = "PER_FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date perFechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_TELEFONO")
    private int perTelefono;
    @Size(max = 100)
    @Column(name = "PER_EMAIL")
    private String perEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_VIGENCIA")
    private Character perVigencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perRut")
    private List<CesUsuario> cesUsuarioList;

    public CesPersona() {
    }

    public CesPersona(Integer perRut) {
        this.perRut = perRut;
    }

    public CesPersona(Integer perRut, Character perDv, String perNombres, String perApellidoPaterno, String perApellidoMaterno, String perNombreCompleto, Character perSexo, Date perFechaNacimiento, Date perFechaReg, int perTelefono, String perEmail, Character perVigencia) {
        this.perRut = perRut;
        this.perDv = perDv;
        this.perNombres = perNombres;
        this.perApellidoPaterno = perApellidoPaterno;
        this.perApellidoMaterno = perApellidoMaterno;
        this.perNombreCompleto = perNombreCompleto;
        this.perSexo = perSexo;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perFechaRegistro = perFechaReg;
        this.perTelefono = perTelefono;
        this.perEmail = perEmail;
        this.perVigencia = perVigencia;
    }

    public Integer getPerRut() {
        return perRut;
    }

    public void setPerRut(Integer perRut) {
        this.perRut = perRut;
    }

    public Character getPerDv() {
        return perDv;
    }

    public void setPerDv(Character perDv) {
        this.perDv = perDv;
    }

    public String getPerNombres() {
        return perNombres;
    }

    public void setPerNombres(String perNombres) {
        this.perNombres = perNombres;
    }

    public String getPerApellidoPaterno() {
        return perApellidoPaterno;
    }

    public void setPerApellidoPaterno(String perApellidoPaterno) {
        this.perApellidoPaterno = perApellidoPaterno;
    }

    public String getPerApellidoMaterno() {
        return perApellidoMaterno;
    }

    public void setPerApellidoMaterno(String perApellidoMaterno) {
        this.perApellidoMaterno = perApellidoMaterno;
    }

    public String getPerNombreCompleto() {
        return perNombreCompleto;
    }

    public void setPerNombreCompleto(String perNombreCompleto) {
        this.perNombreCompleto = perNombreCompleto;
    }

    public Character getPerSexo() {
        return perSexo;
    }

    public void setPerSexo(Character perSexo) {
        this.perSexo = perSexo;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public Date getPerFechaRegistro() {
        return perFechaRegistro;
    }

    public void setPerFechaRegistro(Date perFechaRegistro) {
        this.perFechaRegistro = perFechaRegistro;
    }

    public int getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(int perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public Character getPerVigencia() {
        return perVigencia;
    }

    public void setPerVigencia(Character perVigencia) {
        this.perVigencia = perVigencia;
    }

    @XmlTransient
    public List<CesUsuario> getCesUsuarioList() {
        return cesUsuarioList;
    }

    public void setCesUsuarioList(List<CesUsuario> cesUsuarioList) {
        this.cesUsuarioList = cesUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perRut != null ? perRut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesPersona)) {
            return false;
        }
        CesPersona other = (CesPersona) object;
        if ((this.perRut == null && other.perRut != null) || (this.perRut != null && !this.perRut.equals(other.perRut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesPersona[ perRut=" + perRut + " ]";
    }
    
}
