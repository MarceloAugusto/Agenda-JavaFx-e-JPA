/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller;

import br.com.agendafxjpa.model.Fone;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Marcelo
 */
public class PrincipalController implements Initializable {

    @FXML
    private MenuItem miGrupoCadastro;

    @FXML
    private MenuItem miCadastrar;

    @FXML
    private MenuItem miConsultar;

    @FXML
    private Button bContato;

    @FXML
    private Button bGrupoContato;

    @FXML
    private MenuBar mbMenu;

    @FXML
    private AnchorPane apConteudo;

    //verificar a necessidade de se criar uma constante statica
    public static AnchorPane CONTEUDO;

    Navegacao nv = new Navegacao();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CONTEUDO = apConteudo;
        //("cadcontato")
            miCadastrar.setOnAction(event -> nv.navegacao("cadcontato"));
            miConsultar.setOnAction(event -> nv.navegacao("concontato"));
            miGrupoCadastro.setOnAction(event -> nv.navegacao("cadgrupocontato"));
            
            //bGrupoContato.setOnAction(event -> nv.navegacao("cadgrupocontato"));
            bGrupoContato.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nv.navegacao("cadgrupocontato");
            }
        });
            bContato.setOnAction(event -> nv.navegacao("concontato"));
            
        

       
    }

}
