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
@Table(name = "CES_TIPO_ADMIN_MED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesTipoAdminMed.findAll", query = "SELECT c FROM CesTipoAdminMed c")
    , @NamedQuery(name = "CesTipoAdminMed.findByTipoAdmId", query = "SELECT c FROM CesTipoAdminMed c WHERE c.tipoAdmId = :tipoAdmId")
    , @NamedQuery(name = "CesTipoAdminMed.findByTipoAdmDescripcion", query = "SELECT c FROM CesTipoAdminMed c WHERE c.tipoAdmDescripcion = :tipoAdmDescripcion")
    , @NamedQuery(name = "CesTipoAdminMed.findByTipoAdmVigencia", query = "SELECT c FROM CesTipoAdminMed c WHERE c.tipoAdmVigencia = :tipoAdmVigencia")})
public class CesTipoAdminMed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ADM_ID")
    private Short tipoAdmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO_ADM_DESCRIPCION")
    private String tipoAdmDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ADM_VIGENCIA")
    private Character tipoAdmVigencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAdmId")
    private List<CesMedicamento> cesMedicamentoList;

    public CesTipoAdminMed() {
    }

    public CesTipoAdminMed(Short tipoAdmId) {
        this.tipoAdmId = tipoAdmId;
    }

    public CesTipoAdminMed(Short tipoAdmId, String tipoAdmDescripcion, Character tipoAdmVigencia) {
        this.tipoAdmId = tipoAdmId;
        this.tipoAdmDescripcion = tipoAdmDescripcion;
        this.tipoAdmVigencia = tipoAdmVigencia;
    }

    public Short getTipoAdmId() {
        return tipoAdmId;
    }

    public void setTipoAdmId(Short tipoAdmId) {
        this.tipoAdmId = tipoAdmId;
    }

    public String getTipoAdmDescripcion() {
        return tipoAdmDescripcion;
    }

    public void setTipoAdmDescripcion(String tipoAdmDescripcion) {
        this.tipoAdmDescripcion = tipoAdmDescripcion;
    }

    public Character getTipoAdmVigencia() {
        return tipoAdmVigencia;
    }

    public void setTipoAdmVigencia(Character tipoAdmVigencia) {
        this.tipoAdmVigencia = tipoAdmVigencia;
    }

    @XmlTransient
    public List<CesMedicamento> getCesMedicamentoList() {
        return cesMedicamentoList;
    }

    public void setCesMedicamentoList(List<CesMedicamento> cesMedicamentoList) {
        this.cesMedicamentoList = cesMedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAdmId != null ? tipoAdmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesTipoAdminMed)) {
            return false;
        }
        CesTipoAdminMed other = (CesTipoAdminMed) object;
        if ((this.tipoAdmId == null && other.tipoAdmId != null) || (this.tipoAdmId != null && !this.tipoAdmId.equals(other.tipoAdmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesTipoAdminMed[ tipoAdmId=" + tipoAdmId + " ]";
    }
    
}
