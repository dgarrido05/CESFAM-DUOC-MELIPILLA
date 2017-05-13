/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name = "CES_MEDICAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CesMedicamento.findAll", query = "SELECT c FROM CesMedicamento c")
    , @NamedQuery(name = "CesMedicamento.findByMedId", query = "SELECT c FROM CesMedicamento c WHERE c.medId = :medId")
    , @NamedQuery(name = "CesMedicamento.findByMedNombre", query = "SELECT c FROM CesMedicamento c WHERE c.medNombre = :medNombre")
    , @NamedQuery(name = "CesMedicamento.findByMedFechaElaboracion", query = "SELECT c FROM CesMedicamento c WHERE c.medFechaElaboracion = :medFechaElaboracion")
    , @NamedQuery(name = "CesMedicamento.findByMedFechaVencimiento", query = "SELECT c FROM CesMedicamento c WHERE c.medFechaVencimiento = :medFechaVencimiento")
    , @NamedQuery(name = "CesMedicamento.findByMedLaboratorio", query = "SELECT c FROM CesMedicamento c WHERE c.medLaboratorio = :medLaboratorio")
    , @NamedQuery(name = "CesMedicamento.findByMedComentarios", query = "SELECT c FROM CesMedicamento c WHERE c.medComentarios = :medComentarios")
    , @NamedQuery(name = "CesMedicamento.findByMedVigencia", query = "SELECT c FROM CesMedicamento c WHERE c.medVigencia = :medVigencia")})
public class CesMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MED_ID")
    private Integer medId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MED_NOMBRE")
    private String medNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MED_FECHA_ELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date medFechaElaboracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MED_FECHA_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date medFechaVencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MED_LABORATORIO")
    private String medLaboratorio;
    @Size(max = 200)
    @Column(name = "MED_COMENTARIOS")
    private String medComentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MED_VIGENCIA")
    private Character medVigencia;
    @JoinColumn(name = "EST_ID", referencedColumnName = "EST_ID")
    @ManyToOne(optional = false)
    private CesEstadoMedicamento estId;
    @JoinColumn(name = "TIPO_ADM_ID", referencedColumnName = "TIPO_ADM_ID")
    @ManyToOne(optional = false)
    private CesTipoAdminMed tipoAdmId;
    @JoinColumn(name = "TIPO_MED_ID", referencedColumnName = "TIPO_MED_ID")
    @ManyToOne(optional = false)
    private CesTipoMedicamento tipoMedId;

    public CesMedicamento() {
    }

    public CesMedicamento(Integer medId) {
        this.medId = medId;
    }

    public CesMedicamento(Integer medId, String medNombre, Date medFechaElaboracion, Date medFechaVencimiento, String medLaboratorio, Character medVigencia) {
        this.medId = medId;
        this.medNombre = medNombre;
        this.medFechaElaboracion = medFechaElaboracion;
        this.medFechaVencimiento = medFechaVencimiento;
        this.medLaboratorio = medLaboratorio;
        this.medVigencia = medVigencia;
    }

    public Integer getMedId() {
        return medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    public String getMedNombre() {
        return medNombre;
    }

    public void setMedNombre(String medNombre) {
        this.medNombre = medNombre;
    }

    public Date getMedFechaElaboracion() {
        return medFechaElaboracion;
    }

    public void setMedFechaElaboracion(Date medFechaElaboracion) {
        this.medFechaElaboracion = medFechaElaboracion;
    }

    public Date getMedFechaVencimiento() {
        return medFechaVencimiento;
    }

    public void setMedFechaVencimiento(Date medFechaVencimiento) {
        this.medFechaVencimiento = medFechaVencimiento;
    }

    public String getMedLaboratorio() {
        return medLaboratorio;
    }

    public void setMedLaboratorio(String medLaboratorio) {
        this.medLaboratorio = medLaboratorio;
    }

    public String getMedComentarios() {
        return medComentarios;
    }

    public void setMedComentarios(String medComentarios) {
        this.medComentarios = medComentarios;
    }

    public Character getMedVigencia() {
        return medVigencia;
    }

    public void setMedVigencia(Character medVigencia) {
        this.medVigencia = medVigencia;
    }

    public CesEstadoMedicamento getEstId() {
        return estId;
    }

    public void setEstId(CesEstadoMedicamento estId) {
        this.estId = estId;
    }

    public CesTipoAdminMed getTipoAdmId() {
        return tipoAdmId;
    }

    public void setTipoAdmId(CesTipoAdminMed tipoAdmId) {
        this.tipoAdmId = tipoAdmId;
    }

    public CesTipoMedicamento getTipoMedId() {
        return tipoMedId;
    }

    public void setTipoMedId(CesTipoMedicamento tipoMedId) {
        this.tipoMedId = tipoMedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medId != null ? medId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesMedicamento)) {
            return false;
        }
        CesMedicamento other = (CesMedicamento) object;
        if ((this.medId == null && other.medId != null) || (this.medId != null && !this.medId.equals(other.medId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CesMedicamento[ medId=" + medId + " ]";
    }
    
}
