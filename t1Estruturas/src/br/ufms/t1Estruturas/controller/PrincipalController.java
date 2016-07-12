/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.controller;

import br.ufms.t1Estruturas.model.Vetor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class PrincipalController implements Initializable {

    @FXML
    private Button btn512;
    @FXML
    private Button btn1024;
    @FXML
    private Button btn4096;
    @FXML
    private TextArea mostraVetores;
    @FXML
    private ListView<String> listaVetores;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Vetor> lv = new ArrayList<Vetor>();
        
        btn512.setOnAction((ActionEvent event) -> {
            Vetor v = new Vetor(512);
            lv.add(v);
            ObservableList<String> oblv = listaVetores.getItems();
            oblv.add(lv.indexOf(v)+" | "+v.getTamanho());
            listaVetores.setItems(oblv);
        });
        
        btn1024.setOnAction((ActionEvent event) -> {
            Vetor v = new Vetor(1024);
            lv.add(v);
            ObservableList<String> oblv = listaVetores.getItems();
            oblv.add(lv.indexOf(v)+" | "+v.getTamanho());
            listaVetores.setItems(oblv);
        });
        
        btn4096.setOnAction((ActionEvent event) -> {
            Vetor v = new Vetor(4096);
            lv.add(v);
            ObservableList<String> oblv = listaVetores.getItems();
            oblv.add(lv.indexOf(v)+" | "+v.getTamanho());
            listaVetores.setItems(oblv);
        });
        
        listaVetores.setOnEditStart((EditEvent<String> event) -> {
            Vetor.imprimeVetor(mostraVetores, lv.get(listaVetores.getEditingIndex()).getV());
        });
    }    
    
}
