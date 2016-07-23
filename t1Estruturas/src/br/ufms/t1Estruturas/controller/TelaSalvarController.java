/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.controller;

import br.ufms.t1Estruturas.model.Salvador;
import br.ufms.t1Estruturas.model.Tela;
import br.ufms.t1Estruturas.model.TextoASerSalvo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class TelaSalvarController implements Initializable {

    @FXML
    private TextField editNome;
    @FXML
    private TextField editCaminho;
    @FXML
    private Button btnSalvar;

    private TextArea mostraVetores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mostraVetores = TextoASerSalvo.mostraVetores;

        btnSalvar.setOnAction((ActionEvent event) -> {
            try {
                Salvador s = new Salvador();
                s.salvar(editCaminho.getText(), editNome.getText(), mostraVetores.getText());
                Tela.tela.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });
    }

    /**
     * @param mostraVetores the mostraVetores to set
     */
    public void setMostraVetores(TextArea mostraVetores) {
        this.mostraVetores = mostraVetores;
    }

}
