/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.t1Estruturas.app;

import br.ufms.t1Estruturas.model.QuickSort;
import br.ufms.t1Estruturas.model.Vetor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class T1Estruturas extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        // Carrega arquivo fxml do pacote view.fxml
        Parent root = (Parent) loader.load(getClass().getClassLoader().getResourceAsStream(
                "br/ufms/t1Estruturas/view/fxml/Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
