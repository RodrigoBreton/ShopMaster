package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pruebas.mvc.LoginJFoenix.Main;
import pruebas.mvc.LoginJFoenix.modelo.dao.ClientesDao;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;

public class PantallasController {

	public void cambiarPantalla(Parent window){
		
		Scene newScene = new Scene(window); //Se crea una escena con la pantalla anidada
		//Se declara un Stage y se le pasa el valor del stage actual
		Stage mainWindow;
		mainWindow = Main.primaryStage;
		mainWindow.setScene(newScene); //Se le otorga el valor de la escena deseada al stage
	}
	
	public JFXDialog crearDialog(Node tittle, Node body, StackPane stackPane, JFXButton button) {
		
		JFXDialogLayout layout = new JFXDialogLayout(); //Se crea un DialogLayout para los detalles del Dialog
		layout.setHeading(tittle);//Se le da un titulo al Dialog
		layout.setBody(body); //Se le da un Body al Dialog
		//Se establece el Dialog con los detalles del Dialog
		JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
		layout.setActions(button); //Se le atribuye un boton al Dialog 
		
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
	
	//Metodo para cargar el contenido del Drawer
	public void cargarDrawer(JFXDrawer menuDrawer) throws IOException {
		VBox box = FXMLLoader.load(getClass().getClassLoader().getResource("view/ContentPrincipalDrawer.fxml"));
		menuDrawer.setSidePane(box);
		
	}
	
}
