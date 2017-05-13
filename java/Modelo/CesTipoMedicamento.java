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
@Table(name = "CES_TIPO_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesTipoMedicamento.findAll", query = "SELECT c FROM CesTipoMedicamento c")
    , @NamedQuery(name = "CesTipoMedicamento.findByTipoMedId", query = "SELECT c FROM CesTipoMedicamento c WHERE c.tipoMedId = :tipoMedId")
    , @NamedQuery(name = "CesTipoMedicamento.findByTipoMedDescripcion", query = "SELECT c FROM CesTipoMedicamento c WHERE c.tipoMedDescripcion = :tipoMedDescripcion")
    , @NamedQuery(name = "CesTipoMedicamento.findByTipoMedVigencia", query = "SELECT c FROM CesTipoMedicamento c WHERE c.tipoMedVigencia = :tipoMedVigencia")})
public class CesTipoMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_MED_ID")
    private Short tipoMedId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TIPO_MED_DESCRIPCION")
    private String tipoMedDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_MED_VIGENCIA")
    private Character tipoMedVigencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMedId")
    private List<CesMedicamento> cesMedicamentoList;

    public CesTipoMedicamento() {
    }

    public CesTipoMedicamento(Short tipoMedId) {
        this.tipoMedId = tipoMedId;
    }

    public CesTipoMedicamento(Short tipoMedId, String tipoMedDescripcion, Character tipoMedVigencia) {
        this.tipoMedId = tipoMedId;
        this.tipoMedDescripcion = tipoMedDescripcion;
        this.tipoMedVigencia = tipoMedVigencia;
    }

    public Short getTipoMedId() {
        return tipoMedId;
    }

    public void setTipoMedId(Short tipoMedId) {
        this.tipoMedId = tipoMedId;
    }

    public String getTipoMedDescripcion() {
        return tipoMedDescripcion;
    }

    public void setTipoMedDescripcion(String tipoMedDescripcion) {
        this.tipoMedDescripcion = tipoMedDescripcion;
    }

    public Character getTipoMedVigencia() {
        return tipoMedVigencia;
    }

    public void setTipoMedVigencia(Character tipoMedVigencia) {
        this.tipoMedVigencia = tipoMedVigencia;
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
        hash += (tipoMedId != null ? tipoMedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesTipoMedicamento)) {
            return false;
        }
        CesTipoMedicamento other = (CesTipoMedicamento) object;
        if ((this.tipoMedId == null && other.tipoMedId != null) || (this.tipoMedId != null && !this.tipoMedId.equals(other.tipoMedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesTipoMedicamento[ tipoMedId=" + tipoMedId + " ]";
    }
    
}
