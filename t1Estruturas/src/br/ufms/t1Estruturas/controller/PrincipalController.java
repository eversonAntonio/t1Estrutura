/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.controller;

import br.ufms.t1Estruturas.model.BubbleSort;
import br.ufms.t1Estruturas.model.HeapSort;
import br.ufms.t1Estruturas.model.MergeSort;
import br.ufms.t1Estruturas.model.QuickSort;
import br.ufms.t1Estruturas.model.Tela;
import br.ufms.t1Estruturas.model.TextoASerSalvo;
import br.ufms.t1Estruturas.model.Vetor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    @FXML
    private TextArea mostraResult;
    @FXML
    private Button btn30x;
    @FXML
    private Button btnBubble;
    @FXML
    private Button btnQuick;
    @FXML
    private Button btnMerge;
    @FXML
    private Button btnHeap;
    @FXML
    private TextField editValor;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnLimpar;

    /**
     * Initializes the controller class.
     *
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
            oblv.add(lv.indexOf(v) + " | " + v.getTamanho());
            listaVetores.setItems(oblv);
        });

        btn1024.setOnAction((ActionEvent event) -> {
            Vetor v = new Vetor(1024);
            lv.add(v);
            ObservableList<String> oblv = listaVetores.getItems();
            oblv.add(lv.indexOf(v) + " | " + v.getTamanho());
            listaVetores.setItems(oblv);
        });

        btn4096.setOnAction((ActionEvent event) -> {
            Vetor v = new Vetor(4096);
            lv.add(v);
            ObservableList<String> oblv = listaVetores.getItems();
            oblv.add(lv.indexOf(v) + " | " + v.getTamanho());
            listaVetores.setItems(oblv);
        });

        listaVetores.setOnEditStart((EditEvent<String> event) -> {
            mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
        });
        btn30x.setOnAction((ActionEvent event) -> {
            if (lv.isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Adicione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else if (listaVetores.getEditingIndex() == -1) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Selecione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                BubbleSort.comparacoes = 0;
                QuickSort.comparacoes = 0;
                MergeSort.comparacoes = 0;
                HeapSort.comparacoes = 0;
                for (int x = 0; x < 30; x++) {
                    BubbleSort.ordenaVetor(lv.get(listaVetores.getEditingIndex()).getV());
                    QuickSort.ordenaVetor(lv.get(listaVetores.getEditingIndex()).getV(),
                            0,
                            lv.get(listaVetores.getEditingIndex()).getV().length - 1);
                    MergeSort.mergeSort(lv.get(listaVetores.getEditingIndex()).getV(),
                            0,
                            lv.get(listaVetores.getEditingIndex()).getV().length - 1);
                    HeapSort.ordenacaoHeap(lv.get(listaVetores.getEditingIndex()).getV());
                }
                lv.get(listaVetores.getEditingIndex()).setOrdenado(true);
                mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
                String s = "TESTE EXAUSTIVO";
                s += "\nTamanho do vetor: " + lv.get(listaVetores.getEditingIndex()).getTamanho();
                s += "\nMédia das comparações realizadas (BUBBLE): ";
                s += (BubbleSort.comparacoes / 30);
                s += "\nMédia das comparações realizadas (QUICK): ";
                s += (QuickSort.comparacoes / 30);
                s += "\nMédia das comparações realizadas (MERGE): ";
                s += (MergeSort.comparacoes / 30);
                s += "\nMédia das comparações realizadas (HEAP): ";
                s += (HeapSort.comparacoes / 30);
                s += "\n----------------------------------------\n";
                mostraResult.setText(mostraResult.getText() + s);
            }
        });

        btnBubble.setOnAction((ActionEvent event) -> {
            if (lv.isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Adicione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else if (listaVetores.getEditingIndex() == -1) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Selecione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                BubbleSort.comparacoes = 0;
                BubbleSort.trocas = 0;
                BubbleSort.ordenaVetor(lv.get(listaVetores.getEditingIndex()).getV());
                lv.get(listaVetores.getEditingIndex()).setOrdenado(true);
                mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
                String s = "MÉTODO BUBBLE SORT";
                s += "\nTamanho do vetor: " + lv.get(listaVetores.getEditingIndex()).getTamanho();
                s += "\nQuantidade de comparações realizadas: ";
                s += BubbleSort.comparacoes
                        + "\nQuantidade de trocas realizadas: " + BubbleSort.trocas
                        + "\n----------------------------------------\n";
                mostraResult.setText(mostraResult.getText() + s);
            }
        });

        btnHeap.setOnAction((ActionEvent event) -> {
            if (lv.isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Adicione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else if (listaVetores.getEditingIndex() == -1) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Selecione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                HeapSort.comparacoes = 0;
                HeapSort.trocas = 0;
                HeapSort.ordenacaoHeap(lv.get(listaVetores.getEditingIndex()).getV());
                lv.get(listaVetores.getEditingIndex()).setOrdenado(true);
                mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
                String s = "MÉTODO HEAP SORT";
                s += "\nTamanho do vetor: " + lv.get(listaVetores.getEditingIndex()).getTamanho();
                s += "\nQuantidade de comparações realizadas: ";
                s += HeapSort.comparacoes
                        + "\nQuantidade de trocas realizadas: " + HeapSort.trocas
                        + "\n----------------------------------------\n";
                mostraResult.setText(mostraResult.getText() + s);
            }
        });

        btnMerge.setOnAction((ActionEvent event) -> {
            if (lv.isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Adicione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else if (listaVetores.getEditingIndex() == -1) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Selecione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                MergeSort.comparacoes = 0;
                MergeSort.trocas = 0;
                MergeSort.mergeSort(lv.get(listaVetores.getEditingIndex()).getV(),
                        0,
                        lv.get(listaVetores.getEditingIndex()).getV().length - 1);
                lv.get(listaVetores.getEditingIndex()).setOrdenado(true);
                mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
                String s = "MÉTODO MERGE SORT";
                s += "\nTamanho do vetor: " + lv.get(listaVetores.getEditingIndex()).getTamanho();
                s += "\nQuantidade de comparações realizadas: ";
                s += MergeSort.comparacoes
                        + "\nQuantidade de trocas realizadas: " + MergeSort.trocas
                        + "\n----------------------------------------\n";
                mostraResult.setText(mostraResult.getText() + s);
            }
        });

        btnQuick.setOnAction((ActionEvent event) -> {
            if (lv.isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Adicione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else if (listaVetores.getEditingIndex() == -1) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Selecione um vetor!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                QuickSort.comparacoes = 0;
                QuickSort.trocas = 0;
                QuickSort.ordenaVetor(lv.get(listaVetores.getEditingIndex()).getV(),
                        0,
                        lv.get(listaVetores.getEditingIndex()).getV().length - 1);
                lv.get(listaVetores.getEditingIndex()).setOrdenado(true);
                mostraVetores.setText(Vetor.imprimeVetor(lv.get(listaVetores.getEditingIndex()).getV()));
                String s = "MÉTODO QUICK SORT";
                s += "\nTamanho do vetor: " + lv.get(listaVetores.getEditingIndex()).getTamanho();
                s += "\nQuantidade de comparações realizadas: ";
                s += QuickSort.comparacoes
                        + "\nQuantidade de trocas realizadas: " + QuickSort.trocas
                        + "\n----------------------------------------\n";
                mostraResult.setText(mostraResult.getText() + s);
            }

        });

        btnBuscar.setOnAction((ActionEvent event) -> {
            if (editValor.getText().isEmpty()) {
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setContentText("Digite um valor a ser buscado!");
                dialogoErro.setHeaderText("");
                dialogoErro.showAndWait();
            } else {
                try {
                    if ((Integer.parseInt(editValor.getText()) > 1000)
                            || (Integer.parseInt(editValor.getText()) < 0)) {
                        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                        dialogoErro.setTitle("Erro");
                        dialogoErro.setContentText("Valor inválido! O valor deve"
                                + " ser um número inteiro de 0 até 1000.");
                        dialogoErro.setHeaderText("");
                        dialogoErro.showAndWait();
                    } else if (listaVetores.getEditingIndex() == -1) {
                        Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                        dialogoErro.setTitle("Erro");
                        dialogoErro.setContentText("Selecione um vetor!");
                        dialogoErro.setHeaderText("");
                        dialogoErro.showAndWait();
                    } else if (lv.get(listaVetores.getEditingIndex()).isOrdenado()) {
                        mostraResult.setText(mostraResult.getText() + Vetor.buscaBinaria(
                                lv.get(listaVetores.getEditingIndex()).getV(),
                                Integer.parseInt(editValor.getText())));
                    } else {
                        mostraResult.setText(mostraResult.getText() + Vetor.buscaSequencial(
                                lv.get(listaVetores.getEditingIndex()).getV(),
                                Integer.parseInt(editValor.getText())));
                    }
                } catch (Exception e) {
                    Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                    dialogoErro.setTitle("Erro");
                    dialogoErro.setContentText("Valor inválido! Digite somente números inteiros.");
                    dialogoErro.setHeaderText("");
                    dialogoErro.showAndWait();
                }

            }
        });

        btnSalvar.setOnAction((ActionEvent event) -> {
            try {
                TextoASerSalvo.mostraVetores = mostraResult;
                FXMLLoader loader = new FXMLLoader();
                Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                        "br/ufms/t1Estruturas/view/fxml/TelaSalvar.fxml"));

                Scene scene = new Scene(root);

                Tela.tela.setScene(scene);
                Tela.tela.showAndWait();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        });

        btnLimpar.setOnAction((ActionEvent event) -> {
            mostraResult.setText("");
        });
    }

}
