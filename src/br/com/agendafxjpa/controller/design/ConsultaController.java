/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller.design;

import br.com.agendafxjpa.interfaces.ConsultarInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Marcelo
 */
public class ConsultaController implements Initializable {
    
    @FXML
    private Button bAlterar;

    @FXML
    private Button bRemover;

    @FXML
    private Button bNovo;

    private ConsultarInterface consulta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        bNovo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                consulta.novo();
            }
        });
        
        bAlterar.setOnAction(event -> consulta.alterar());
        bRemover.setOnAction(event -> consulta.remover());
    }    
    
    public void setInterface(ConsultarInterface consulta){
        this.consulta = consulta;
    }
    
    public void setStatus(boolean novo, boolean alterar, boolean remover){
        bNovo.setDisable(!novo);
        bAlterar.setDisable(!alterar);
        bRemover.setDisable(!remover);
        
    }
    
}
