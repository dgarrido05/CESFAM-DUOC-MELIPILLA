/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CES_TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesTipoUsuario.findAll", query = "SELECT c FROM CesTipoUsuario c")
    , @NamedQuery(name = "CesTipoUsuario.findByTipoUsuarioId", query = "SELECT c FROM CesTipoUsuario c WHERE c.tipoUsuarioId = :tipoUsuarioId")
    , @NamedQuery(name = "CesTipoUsuario.findByTipoUsuarioDescripcion", query = "SELECT c FROM CesTipoUsuario c WHERE c.tipoUsuarioDescripcion = :tipoUsuarioDescripcion")
    , @NamedQuery(name = "CesTipoUsuario.findByTipoUsuarioVigencia", query = "SELECT c FROM CesTipoUsuario c WHERE c.tipoUsuarioVigencia = :tipoUsuarioVigencia")})
public class CesTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_USUARIO_ID")
    private Short tipoUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO_USUARIO_DESCRIPCION")
    private String tipoUsuarioDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_USUARIO_VIGENCIA")
    private Character tipoUsuarioVigencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuarioId")
    private List<CesUsuario> cesUsuarioList;

    public CesTipoUsuario() {
    }

    public CesTipoUsuario(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public CesTipoUsuario(Short tipoUsuarioId, String tipoUsuarioDescripcion, Character tipoUsuarioVigencia) {
        this.tipoUsuarioId = tipoUsuarioId;
        this.tipoUsuarioDescripcion = tipoUsuarioDescripcion;
        this.tipoUsuarioVigencia = tipoUsuarioVigencia;
    }

    public Short getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setTipoUsuarioId(Short tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
    }

    public String getTipoUsuarioDescripcion() {
        return tipoUsuarioDescripcion;
    }

    public void setTipoUsuarioDescripcion(String tipoUsuarioDescripcion) {
        this.tipoUsuarioDescripcion = tipoUsuarioDescripcion;
    }

    public Character getTipoUsuarioVigencia() {
        return tipoUsuarioVigencia;
    }

    public void setTipoUsuarioVigencia(Character tipoUsuarioVigencia) {
        this.tipoUsuarioVigencia = tipoUsuarioVigencia;
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
        hash += (tipoUsuarioId != null ? tipoUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesTipoUsuario)) {
            return false;
        }
        CesTipoUsuario other = (CesTipoUsuario) object;
        if ((this.tipoUsuarioId == null && other.tipoUsuarioId != null) || (this.tipoUsuarioId != null && !this.tipoUsuarioId.equals(other.tipoUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesTipoUsuario[ tipoUsuarioId=" + tipoUsuarioId + " ]";
    }
    
}
