/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CES_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesUsuario.findAll", query = "SELECT c FROM CesUsuario c")
    , @NamedQuery(name = "CesUsuario.findByUsuId", query = "SELECT c FROM CesUsuario c WHERE c.usuId = :usuId")
    , @NamedQuery(name = "CesUsuario.findByUsuNombreUsuario", query = "SELECT c FROM CesUsuario c WHERE c.usuNombreUsuario = :usuNombreUsuario")
    , @NamedQuery(name = "CesUsuario.findByUsuClave", query = "SELECT c FROM CesUsuario c WHERE c.usuClave = :usuClave")
    , @NamedQuery(name = "CesUsuario.findByUsuVigencia", query = "SELECT c FROM CesUsuario c WHERE c.usuVigencia = :usuVigencia")})
public class CesUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ID")
    private Short usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USU_NOMBRE_USUARIO")
    private String usuNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "USU_CLAVE")
    private String usuClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_VIGENCIA")
    private Character usuVigencia;
    @JoinColumn(name = "PER_RUT", referencedColumnName = "PER_RUT")
    @ManyToOne(optional = false)
    private CesPersona perRut;
    @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "TIPO_USUARIO_ID")
    @ManyToOne(optional = false)
    private CesTipoUsuario tipoUsuarioId;

    public CesUsuario() {
    }

    public CesUsuario(Short usuId) {
        this.usuId = usuId;
    }

    public CesUsuario(Short usuId, String usuNombreUsuario, String usuClave, Character usuVigencia) {
        this.usuId = usuId;
        this.usuNombreUsuario = usuNombreUsuario;
        this.usuClave = usuClave;
        this.usuVigencia = usuVigencia;
    }

    public Short getUsuId() {
        return usuId;
    }

    public void setUsuId(Short usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombreUsuario() {
        return usuNombreUsuario;
    }

    public void setUsuNombreUsuario(String usuNombreUsuario) {
        this.usuNombreUsuario = usuNombreUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    public Character getUsuVigencia() {
        return usuVigencia;
    }

    public void setUsuVigencia(Character usuVigencia) {
        this.usuVigencia = usuVigencia;
    }

    public CesPersona getPerRut() {
        return perRut;
    }

    public void setPerRut(CesPersona perRut) {
        this.perRut = perRut;
    }

    public CesTipoUsuario getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(CesTipoUsuario tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesUsuario)) {
            return false;
        }
        CesUsuario other = (CesUsuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesUsuario[ usuId=" + usuId + " ]";
    }
    
}
