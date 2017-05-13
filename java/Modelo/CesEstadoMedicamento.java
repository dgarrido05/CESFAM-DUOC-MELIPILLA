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
@Table(name = "CES_ESTADO_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesEstadoMedicamento.findAll", query = "SELECT c FROM CesEstadoMedicamento c")
    , @NamedQuery(name = "CesEstadoMedicamento.findByEstId", query = "SELECT c FROM CesEstadoMedicamento c WHERE c.estId = :estId")
    , @NamedQuery(name = "CesEstadoMedicamento.findByEstDescripcion", query = "SELECT c FROM CesEstadoMedicamento c WHERE c.estDescripcion = :estDescripcion")
    , @NamedQuery(name = "CesEstadoMedicamento.findByEstVigencia", query = "SELECT c FROM CesEstadoMedicamento c WHERE c.estVigencia = :estVigencia")})
public class CesEstadoMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_ID")
    private Short estId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "EST_DESCRIPCION")
    private String estDescripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_VIGENCIA")
    private Character estVigencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private List<CesMedicamento> cesMedicamentoList;

    public CesEstadoMedicamento() {
    }

    public CesEstadoMedicamento(Short estId) {
        this.estId = estId;
    }

    public CesEstadoMedicamento(Short estId, String estDescripcion, Character estVigencia) {
        this.estId = estId;
        this.estDescripcion = estDescripcion;
        this.estVigencia = estVigencia;
    }

    public Short getEstId() {
        return estId;
    }

    public void setEstId(Short estId) {
        this.estId = estId;
    }

    public String getEstDescripcion() {
        return estDescripcion;
    }

    public void setEstDescripcion(String estDescripcion) {
        this.estDescripcion = estDescripcion;
    }

    public Character getEstVigencia() {
        return estVigencia;
    }

    public void setEstVigencia(Character estVigencia) {
        this.estVigencia = estVigencia;
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
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesEstadoMedicamento)) {
            return false;
        }
        CesEstadoMedicamento other = (CesEstadoMedicamento) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesEstadoMedicamento[ estId=" + estId + " ]";
    }
    
}
