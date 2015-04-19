/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller;

import br.com.agendafxjpa.controller.dao.JpaController;
import br.com.agendafxjpa.controller.design.CadastroController;
import br.com.agendafxjpa.interfaces.CadastroInterface;
import br.com.agendafxjpa.model.Contato;
import br.com.agendafxjpa.model.Fone;
import br.com.agendafxjpa.model.Grupocontato;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author Marcelo
 */
public class CadContatoController implements Initializable, CadastroInterface {

    public static Contato CONTATO;
    public List<Fone> listFones;

    JpaController<Grupocontato> jpaGrupo = new JpaController<>();
    JpaController<Contato> jpaContato = new JpaController<>();
    JpaController<Fone> jpaFone = new JpaController<>();

    @FXML
    private TextField tfCod, ftNome, tfMunicipio, tfEmail, tfEmpresa, tfEmailComercial, tfFone;

    @FXML
    private ComboBox<Grupocontato> cbGrupoContato;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private ComboBox<String> cbOperadora;

    @FXML
    private CheckBox cbComercial;

    @FXML
    private Button bAdicionar, bRemover;

    @FXML
    private ListView<Fone> lvFones;

    @FXML
    private CadastroController cadastroController;

    Navegacao nav = new Navegacao();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cadastroController.setInterface(this);
        
        cbOperadora.getItems().addAll(new String[] {"OI", "TIM", "VIVO", "CLARO", "GVT"});
        cbEstado.getItems().addAll(new String[] {"MG", "SP", "ES", "TO", "AM"});
        
        jpaGrupo.findEntities(jpaGrupo.getQuery("SELECT g FROM Grupocontato g")).forEach(g -> cbGrupoContato.getItems().add(g));
        
        
        if (CONTATO != null) {
            preencher();
            listFones = CONTATO.getFoneList();
            preencheListaFones();
        }
        
        bAdicionar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Fone fone = new Fone();
                fone.setNumero(tfFone.getText());
                fone.setOperadora(cbOperadora.getSelectionModel().getSelectedItem());
                fone.setComercial(cbComercial.isSelected());
                lvFones.getItems().add(fone);
                
            }
        });
        
        bRemover.setOnAction(event -> lvFones.getItems().remove(lvFones.getSelectionModel().getSelectedItem()));
    }

    @Override
    public void salvar() {
        if (CONTATO != null) {
            getCampos();
            if (jpaContato.edit(CONTATO)) {
               
                Query q = jpaFone.getQuery("SELECT f FROM Fone f WHERE f.contato.id="+CONTATO.getId());
                //q.setParameter(1, CONTATO.getId());
                List<Fone> list = jpaFone.findEntities(q);
                for(Fone f:list){
                    jpaFone.destroy(f);
                }
                cadastrarFones();
                nav.navegacao("contato");
            }
        } else {
            CONTATO = new Contato();
            getCampos();
            if (jpaContato.create(CONTATO)) {
                tfCod.setText(CONTATO.getId() + "");
                cadastrarFones();
                nav.navegacao("concontato");
            }
        }
    }

    private void preencher() {
        tfCod.setText(CONTATO.getId() + "");
        ftNome.setText(CONTATO.getNome());
        tfEmail.setText(CONTATO.getEmail());
        tfEmailComercial.setText(CONTATO.getEmailcomercial());
        tfEmpresa.setText(CONTATO.getEmpresa());
        tfMunicipio.setText(CONTATO.getMunicipio());
        cbEstado.getSelectionModel().select(CONTATO.getEstado());
        cbGrupoContato.getSelectionModel().select(CONTATO.getGrupocontato());

    }

    private void getCampos() {
        CONTATO.setEmail(tfEmail.getText());
        CONTATO.setNome(ftNome.getText());
        CONTATO.setEmailcomercial(tfEmailComercial.getText());
        CONTATO.setEmpresa(tfEmpresa.getText());
        CONTATO.setEstado(cbEstado.getSelectionModel().getSelectedItem());
        CONTATO.setMunicipio(tfMunicipio.getText());
        CONTATO.setGrupocontato(cbGrupoContato.getSelectionModel().getSelectedItem());

    }

    private void preencheListaFones() {
        lvFones.getItems().clear();
        for(Fone f:listFones){
             lvFones.getItems().add(f);
        }
       
    }

    private void cadastrarFones() {
        CONTATO.getFoneList().clear();
        for(Fone f: lvFones.getItems()){
            f.setContato(CONTATO);
            jpaFone.create(f);
            CONTATO.getFoneList().add(f);
        }
    }

}
