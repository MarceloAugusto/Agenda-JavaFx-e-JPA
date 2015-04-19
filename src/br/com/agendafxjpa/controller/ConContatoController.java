/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendafxjpa.controller;

import br.com.agendafxjpa.controller.dao.JpaController;
import br.com.agendafxjpa.controller.design.ConsultaController;
import br.com.agendafxjpa.interfaces.ConsultarInterface;
import br.com.agendafxjpa.model.ConContatoTV;
import br.com.agendafxjpa.model.Contato;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author Marcelo
 */
public class ConContatoController implements Initializable, ConsultarInterface {

    @FXML
    private TableView<ConContatoTV> tvConsulta;

    @FXML
    private TableColumn<?, ?> tcNome;

    @FXML
    private FlowPane fpCabecalho;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private TableColumn<?, ?> tcCodigo;

    @FXML
    private TableColumn<?, ?> tcMunicipio;

    @FXML
    private TableColumn<?, ?> tcEmpresa;

    @FXML
    private TableColumn<?, ?> tcEstado;

    @FXML
    private ConsultaController consultaController;

    JpaController<Contato> jpaContato = new JpaController<>();
    Navegacao nav = new Navegacao();
    ObservableList<ConContatoTV> contatos ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consultaController.setInterface(this);
        
        List<Contato> listContato = jpaContato.findEntities(jpaContato.getQuery("SELECT c FROM Contato c"));
        contatos = FXCollections.observableArrayList();
        listContato.forEach(c -> contatos.add(new ConContatoTV(c)));
        FilteredList<ConContatoTV> filteredContatos = new FilteredList(contatos);

        tcCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        tcNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcEmpresa.setCellValueFactory(new PropertyValueFactory("empresa"));
        tcMunicipio.setCellValueFactory(new PropertyValueFactory("municipio"));
        tcEstado.setCellValueFactory(new PropertyValueFactory("estado"));

        tvConsulta.setItems(filteredContatos);

        tfPesquisar.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                filteredContatos.setPredicate(c -> c.filtrar(tfPesquisar.getText()));
            }
        });
        filteredContatos.setPredicate(c -> true);
    }

    @Override
    public void novo() {
        nav.navegacao("cadcontato");
    }

    @Override
    public void alterar() {
        CadContatoController.CONTATO = tvConsulta.getSelectionModel().getSelectedItem().getContato();
        nav.navegacao("cadcontatoalterar");
    }

    @Override
    public void remover() {
        if (jpaContato.destroy(tvConsulta.getSelectionModel().getSelectedItem().getContato())) {
            contatos.remove(tvConsulta.getSelectionModel().getSelectedItem());
        }
    }

}
