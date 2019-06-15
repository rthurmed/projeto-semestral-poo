/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm.main.app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Arthur
 */
public class Crm extends Application {
    
    private static Stage stage;
    
    public static void trocaTela(String caminho){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(Crm.class.getResource(caminho));
        } catch (IOException ex) {
            System.out.println("ERRO AO CARREGAR O FXML");
            Logger.getLogger(Crm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Crm.stage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
