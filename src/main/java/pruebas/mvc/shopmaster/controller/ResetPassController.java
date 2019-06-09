package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.IClientesDaoService;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;

@Component
public class ResetPassController implements Initializable {

	@FXML
	private JFXTextField mail;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXButton bRecuperar;

	@FXML
	private StackPane stackPane;

	@Autowired
	private IClientesDaoService dao;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private PantallasController pantallasController;

	@Autowired
	private Validaciones validar;

	boolean succesfull = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		mail.setStyle("-fx-text-inner-color: white");
		username.setStyle("-fx-text-inner-color: white");

	}

	@FXML
	void recuperarPass(ActionEvent event) {

		List<Cliente> clientes = dao.obtenerClientes();

		String usernameInput = username.getText();
		String mailInput = mail.getText();

		for (Cliente c : clientes) {
			if (usernameInput.equals(c.getNombreUsuario()) && mailInput.equals(c.getEmail())) {
				Text contra = new Text(c.getPassword());
				JFXButton ok = new JFXButton("Iniciar Sesion");
				JFXDialog dialog = pantallasController.crearDialog(new Text("Su contraseña es:"), contra, stackPane,
						ok);

				ok.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							FXMLLoader loader = new FXMLLoader(
									getClass().getClassLoader().getResource("view/Login.fxml"));
							loader.setControllerFactory(applicationContext::getBean);
							Parent root = loader.load();
							pantallasController.cambiarPantalla(root);

						} catch (IOException e) {
							e.printStackTrace();
							System.err.println("FALLO AL CARGAR LA PANTALLA DE LOGIN");
						}
					}
				});
				dialog.show();
				succesfull = true;
			}
		}
//		 si ningun email introducido ni nombre de usuario coinciden
//		 se imprime un mensaje de error
		if (succesfull == !true) {
			JFXButton ok = new JFXButton("OK");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Error a la hora de recuperar la contraseña"),
					new Text("No existe ninguna cuenta con estos datos o los campos requeridos están vacíos"), stackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					dialog.close();
				}
			});
			dialog.show();
		}

	}

	@FXML
	void goCambiarContra(ActionEvent event) throws IOException {

		List<Cliente> clientes = dao.obtenerClientes();

		for (Cliente c : clientes) {
			if (validar.esIgual(c.getNombreUsuario(), username.getText()) == true
					&& validar.esIgual(c.getEmail(), mail.getText()) == true) {

				succesfull = true;
				LoginController.currentCliente = c;

				FXMLLoader loader = new FXMLLoader(
						getClass().getClassLoader().getResource("view/CambiarContrasenha.fxml"));
				loader.setControllerFactory(applicationContext::getBean);
				Parent root = loader.load();
				pantallasController.cambiarPantalla(root);
			}
		}

		if (succesfull == !true) {
			JFXButton ok = new JFXButton("OK");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Error"),
					new Text("No existe ninguna cuenta con estos datos o los campos requeridos están vacíos"), stackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialog.close();
				}
			});
			dialog.show();
		}

	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);

	}

}
