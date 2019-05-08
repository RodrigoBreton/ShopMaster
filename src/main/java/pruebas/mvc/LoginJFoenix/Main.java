	package pruebas.mvc.LoginJFoenix;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.controller.LoginController;
import pruebas.mvc.LoginJFoenix.controller.NewAccountController;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static Stage primaryStage;	

	public void start(Stage stage) throws Exception {
		
		primaryStage = stage;
		
		// Quita el marco de la ventana
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("ShopMaster");
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
		Scene scene = new Scene(root);
		
		// No me coge los estilos
//		root.setStyle("-fx-effect: dropshadow( gaussian, rgba(0, 255, 255, 0.4), 10, 0.5, 0.0, 0.0 )");
//		root.setStyle("-fx-padding: 10");
//		root.setStyle("-fx-background-radius: 5");
		
		// Establecer el color de relleno del Scene a transparente
        scene.setFill(Color.TRANSPARENT);
	
     // Agregar el archivo de estilos BorderStyle.css
//        scene.getStylesheets().add(getClass().getResource("BorderStyle.css").toString());
        
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
    public static void main( String[] args ) {
    	launch(args);
    	
    }

}

