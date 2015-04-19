/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Marcelo
 */
public class Navegacao {

    public void navegacao(String telas) {
        Parent root; //= FXMLLoader.load(getClass().getResource("view/Principal.fxml"));

        switch (telas) {
            case "cadcontato":
                try {
                    CadContatoController.CONTATO = null;
                    root = FXMLLoader.load(getClass().getResource("/br/com/agendafxjpa/view/CadContato.fxml"));
                    PrincipalController.CONTEUDO.getChildren().clear();
                    PrincipalController.CONTEUDO.getChildren().add(root);
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Navegacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "concontato":
                try {
                    root = FXMLLoader.load(getClass().getResource("/br/com/agendafxjpa/view/ConContato.fxml"));
                    PrincipalController.CONTEUDO.getChildren().clear();
                    PrincipalController.CONTEUDO.getChildren().add(root);
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Navegacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "cadcontatoalterar":
                try {
                    root = FXMLLoader.load(getClass().getResource("/br/com/agendafxjpa/view/CadContato.fxml"));
                    PrincipalController.CONTEUDO.getChildren().clear();
                    PrincipalController.CONTEUDO.getChildren().add(root);
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Navegacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "cadgrupocontato":
                try {
                    //Parent root = FXMLLoader.load(getClass().getResource("view/Principal.fxml"));
                    //root = FXMLLoader.load(getClass().getResource("br/com/agendafxjpa/view/CadGrupoContato.fxml"));
                    root = FXMLLoader.load(getClass().getResource("/br/com/agendafxjpa/view/CadGrupoContato.fxml"));
                    PrincipalController.CONTEUDO.getChildren().clear();
                    PrincipalController.CONTEUDO.getChildren().add(root);
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(Navegacao.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

    }

}
