/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller.design;

import br.com.agendafxjpa.interfaces.CadastroInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author Marcelo
 */
public class CadastroController implements Initializable {

    @FXML
    private FlowPane fpRodape;

    @FXML
    private Button bSalvar;
    
    private CadastroInterface cadastro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bSalvar.setOnAction(event -> cadastro.salvar());
    }
    
    public void setInterface(CadastroInterface cadastro){
        this.cadastro = cadastro;
    }

}
