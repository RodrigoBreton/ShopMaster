package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pruebas.mvc.shopmaster.Main;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Component
public class PantallasController {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IClientesDaoService dao;
	
	public void cambiarPantalla(Parent window) {

		Scene newScene = new Scene(window); // Se crea una escena con la pantalla anidada
		newScene.setFill(Color.TRANSPARENT);
		// Se declara un Stage y se le pasa el valor del stage actual
		Stage mainWindow;
		mainWindow = Main.primaryStage;
		mainWindow.setScene(newScene); // Se le otorga el valor de la escena deseada al stage
	}

	public JFXDialog crearDialog(Node tittle, Node body, StackPane stackPane, JFXButton button) {

		JFXDialogLayout layout = new JFXDialogLayout(); // Se crea un DialogLayout para los detalles del Dialog
		layout.setHeading(tittle);// Se le da un titulo al Dialog
		layout.setBody(body); // Se le da un Body al Dialog
		// Se establece el Dialog con los detalles del Dialog
		JFXDialog dialog = new JFXDialog(stackPane, layout, JFXDialog.DialogTransition.CENTER);
		layout.setActions(button); // Se le atribuye un boton al Dialog

		return dialog;
	}

	public void nuevaVentana(Parent window) {

		Stage stage = new Stage();
		stage.setScene(new Scene(window));
		stage.show();

	}

	// Metodo para comparar dos strings introducidos por inputs con dos string de
	// bbdd
	public boolean validacionEntrada(String nombre, String pass) {
		List<Cliente> clientes = dao.obtenerClientes();
		boolean succesfull = false;

		for (Cliente c : clientes) {
			if (nombre.equals(c.getNombreUsuario()) && pass.equals(c.getEmail())) {
				succesfull = true;
			}
		}
		return succesfull;
	}

	// Metodo para cargar el contenido del Drawer
	public void cargarDrawerHamburger(JFXDrawer menuDrawer, JFXHamburger menuHamburger) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ContentPrincipalDrawer.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		VBox box = loader.load();
		menuDrawer.setSidePane(box);

		// Animacion del boton hamburger
		HamburgerBackArrowBasicTransition flechaIzq = new HamburgerBackArrowBasicTransition(menuHamburger);
		flechaIzq.setRate(-1);
		menuHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			flechaIzq.setRate(flechaIzq.getRate() * -1);
			flechaIzq.play();

			// Control del menu desplegable
			if (menuDrawer.isOpened()) {
				menuDrawer.close();
			} else {
				menuDrawer.open();
			}
		});

	}

}
