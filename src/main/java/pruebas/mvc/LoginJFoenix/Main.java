package pruebas.mvc.LoginJFoenix;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.controller.LoginController;
import pruebas.mvc.LoginJFoenix.controller.NewAccountController;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Stage primaryStage;	

	public void start(Stage stage) throws Exception {
		
		primaryStage = stage; 
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
		
		Scene scene = new Scene(root);
	
		stage.setScene(scene);
		stage.show();
	}
	
    public static void main( String[] args ) {
    	launch(args);
    	
    }

}

