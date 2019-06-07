package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Component
public class PerfilClienteController implements Initializable {

	@FXML
	private JFXDrawer menuDrawer;

	@FXML
	private JFXHamburger menuHamburger;

	@FXML
	private Label nombre;

	@FXML
	private Label nombreUsuario;

	@FXML
	private Label apellidos;

	@FXML
	private Label correo;

	@FXML
	private Label calle;

	@FXML
	private Label portal;

	@FXML
	private Label piso;

	@FXML
	private Label codPostal;

	@FXML
	private Label ciudad;

	@FXML
	private JFXButton btEditar;

	@FXML
	private StackPane stackPane;

	@Autowired
	private PantallasController pantallasController;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IClientesDaoService clienteService;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}

		// Obtener datos del cliente
		nombre.setText(LoginController.currentCliente.getNombre());
		apellidos.setText(LoginController.currentCliente.getApellidos());
		nombreUsuario.setText(LoginController.currentCliente.getNombreUsuario());
		correo.setText(LoginController.currentCliente.getEmail());
		calle.setText(LoginController.currentCliente.getDireccion().getCalle());
		portal.setText(LoginController.currentCliente.getDireccion().getPortal());
		piso.setText(LoginController.currentCliente.getDireccion().getPiso());
		codPostal.setText(String.valueOf(LoginController.currentCliente.getDireccion().getCodPostal()));
		ciudad.setText(LoginController.currentCliente.getDireccion().getCiudad());

	}

	@FXML
	void goEditarPerfil(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/EditarPerfil.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
	}

	@FXML
	void eliminarCuenta(ActionEvent event) {

		clienteService.eliminarCliente(LoginController.currentCliente);

		JFXButton ok = new JFXButton("OK");
		JFXDialog dialog = pantallasController.crearDialog(new Text("Se han eliminado los datos"),
				new Text("Se ha eliminado la cuenta exitosamente"), stackPane, ok);

		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
				loader.setControllerFactory(applicationContext::getBean);
				Parent root;
				try {
					root = loader.load();
					pantallasController.cambiarPantalla(root);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		dialog.show();
	}

	@FXML
	void goCambiarCuenta(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/CambiarContraseña.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
	}

}
