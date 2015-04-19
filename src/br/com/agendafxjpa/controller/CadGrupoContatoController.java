/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller;

import br.com.agendafxjpa.controller.dao.JpaController;
import br.com.agendafxjpa.controller.design.CadastroController;
import br.com.agendafxjpa.interfaces.CadastroInterface;
import br.com.agendafxjpa.model.Grupocontato;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author Marcelo
 */
public class CadGrupoContatoController implements Initializable, CadastroInterface {

    @FXML
    private TextField tfNomeGrupo;

    @FXML
    private FlowPane fpCabecalho;

    @FXML
    private TextField tfCodigo;
    
    @FXML
    private CadastroController cadastroController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cadastroController.setInterface(this);
    }

    JpaController<Grupocontato> jpa = new JpaController<>();
    
    @Override
    public void salvar() {
        Grupocontato grupo = new Grupocontato();
        grupo.setDescricao(tfNomeGrupo.getText());
        jpa.create(grupo);
        tfCodigo.setText(grupo.getId()+"");
        
        
    }

}
