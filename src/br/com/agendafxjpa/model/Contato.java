/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "contato")
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")})
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nome", length = 60)
    private String nome;
    @Column(name = "municipio", length = 120)
    private String municipio;
    @Column(name = "estado", length = 2)
    private String estado;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "emailcomercial", length = 255)
    private String emailcomercial;
    @Column(name = "empresa", length = 255)
    private String empresa;
    @OneToMany(mappedBy = "contato")
    private List<Fone> foneList;
    @JoinColumn(name = "grupocontato", referencedColumnName = "id")
    @ManyToOne
    private Grupocontato grupocontato;

    public Contato() {
    }

    public Contato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailcomercial() {
        return emailcomercial;
    }

    public void setEmailcomercial(String emailcomercial) {
        this.emailcomercial = emailcomercial;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public List<Fone> getFoneList() {
        return foneList;
    }

    public void setFoneList(List<Fone> foneList) {
        this.foneList = foneList;
    }

    public Grupocontato getGrupocontato() {
        return grupocontato;
    }

    public void setGrupocontato(Grupocontato grupocontato) {
        this.grupocontato = grupocontato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agendafxjpa.Contato[ id=" + id + " ]";
    }
    
}
