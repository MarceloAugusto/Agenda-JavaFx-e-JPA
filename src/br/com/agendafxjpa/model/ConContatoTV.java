/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marcelo
 */
public class ConContatoTV {
    LongProperty codigo;
    StringProperty nome, empresa, municipio, estado;
    Contato contato;

    public ConContatoTV(Contato contato) {
        this.contato = contato;
        codigo = new SimpleLongProperty();
        codigo.set(contato.getId());
        nome = new SimpleStringProperty();
        nome.set(contato.getNome());
        empresa = new SimpleStringProperty();
        empresa.set(contato.getEmpresa());
        municipio = new SimpleStringProperty();
        municipio.set(contato.getMunicipio());
        estado = new SimpleStringProperty();
        estado.set(contato.getEstado());
        
    }
    
    

    public LongProperty codigoProperty() {
        return codigo;
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public StringProperty empresaProperty() {
        return empresa;
    }

    public StringProperty municipioProperty() {
        return municipio;
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public Contato getContato() {
        return contato;
    }

    public boolean filtrar(String text) {
        String dados = codigo.get()+nome.get()+empresa.get()+municipio.get()+estado.get();
        if(dados.toUpperCase().contains(text.toUpperCase())){
            return true;
        }else{
            return false;
        }
    }
    
    
}
