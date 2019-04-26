package pruebas.mvc.LoginJFoenix.controller;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pruebas.mvc.LoginJFoenix.Main;
import pruebas.mvc.LoginJFoenix.modelo.dao.ClientesDao;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;

public class PantallasController {

	public void cambiarPantalla(Parent window){
		//Se crea una escena con la pantalla anidada
		Scene newScene = new Scene(window);
		
		//Se declara un Stage y se le pasa el valor del stage actual
		Stage mainWindow;
		mainWindow = Main.primaryStage;
		
		//Se le otorga el valor de la escena deseada al stage
		mainWindow.setScene(newScene);
	}
	
	public JFXDialog crearDialog(Node tittle, Node body, StackPane stackPane, JFXButton button) {
		//Se crea un DialogLayout para los detalles del Dialog
		JFXDialogLayout layout = new JFXDialogLayout();
		
		//Se le da un titulo al Dialog
		layout.setHeading(tittle);
		
		//Se le da un Body al Dialog
		layout.setBody(body);
		
		//Se establece el Dialog con los detalles del Dialog
		JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
		
		//Se le atribuye un boton al Dialog 
		layout.setActions(button);
		
		return dialog;
		
	}
	
	public void nuevaVentana(Parent window) {
		
		Stage stage = new Stage();
		stage.setScene(new Scene(window));
		stage.show();
		
	}
	
	//Metodo para comparar dos strings introducidos por inputs con dos string de bbdd
	public boolean validacionEntrada(String nombre, String pass) {
		ClientesDao helpers = new ClientesDao();
		List<Cliente> clientes = helpers.obtenerClientes();
		boolean succesfull = false;
		
		for(Cliente c : clientes) {
			if(nombre.equals(c.getNombreUsuario()) && pass.equals(c.getEmail())) {
				succesfull = true;
			}
		}
		return succesfull;
	}

	
}
