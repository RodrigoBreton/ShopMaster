package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.entidades.Direccion;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Component
public class NewAccountController implements Initializable {

	@Autowired
	private ApplicationContext applicationContext;

	@FXML
	private JFXTextField newNombre;

	@FXML
	private JFXTextField newApellidos;

	@FXML
	private JFXDatePicker newFechaNacimiento;

	@FXML
	private JFXTextField newNombreUsuario;

	@FXML
	private JFXTextField newCorreo;

	@FXML
	private JFXPasswordField newPassword;

	@FXML
	private JFXPasswordField repeatPassword;

	@FXML
	private JFXTextField newCalle;

	@FXML
	private JFXTextField newPortal;

	@FXML
	private JFXTextField newPiso;

	@FXML
	private JFXTextField newCodPostal;

	@FXML
	private JFXTextField newCiudad;

	@FXML
	private JFXButton buttonCrear;

	@FXML
	private StackPane stackPane;

	@FXML
	private ImageView volverAtrás;

	@Autowired
	private IClientesDaoService dao;

	@Autowired
	private PantallasController pantallasController;

	@Autowired
	private Validaciones validar;

	@FXML
	void crearCliente(ActionEvent event) {

		// COMPROBACION DE QUE NO HAY NINGUN CAMPO VACIO
		if (validar.validarCampoVacio(newNombre) == true || validar.validarCampoVacio(newApellidos) == true
				|| validar.validarCampoVacio(newNombreUsuario) == true || validar.validarCampoVacio(newCorreo) == true
				|| validar.validarCampoVacio(newPassword) == true || validar.validarCampoVacio(repeatPassword) == true
				|| validar.validarCampoVacio(newCalle) == true || validar.validarCampoVacio(newPortal) == true
				|| validar.validarCampoVacio(newPiso) == true || validar.validarCampoVacio(newCodPostal) == true
				|| validar.validarCampoVacio(newCiudad) == true) {

			// En caso de estar algun campo vacio sale un mensage de error
			JFXButton ok = new JFXButton("OK");
			JFXDialog error = pantallasController.crearDialog(new Text("Error"),
					new Text("Hay que rellenar todos los campos que se piden"), stackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					error.close();
				}
			});
			error.show();
		} else {

			// En caso de estar todo correcto se procede a la parte de insercion en bbdd
			String contra = newPassword.getText();
			String repeatContra = repeatPassword.getText();

			// Si las contraseñas coinciden se insertan los datos y se muestra un dialog de
			// confirmacion
			if (contra.equals(repeatContra)) {

				String calle = newCalle.getText();
				String portal = newPortal.getText();
				String piso = newPiso.getText();
				int codPostal = Integer.parseInt(newCodPostal.getText());
				String ciudad = newCiudad.getText();
				System.out.println(codPostal);

				Direccion d = new Direccion(calle, portal, piso, codPostal, ciudad);

				String nombre = newNombre.getText();
				String apellidos = newApellidos.getText();
				String correo = newCorreo.getText();
				String usuario = newNombreUsuario.getText();

				Cliente c = new Cliente(d, nombre, apellidos, correo, usuario, contra);
				dao.guardarCliente(c);

				JFXButton singUp = new JFXButton("Iniciar sesión");
				JFXDialog correcto = pantallasController.crearDialog(new Text("Todo listo!"),
						new Text("Se creó la cuenta correctamente"), stackPane, singUp);

				// Se le da una funcion al boton singUp
				singUp.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						// Vuelve a la pantalla de Login para iniciar sesion
						try {
							FXMLLoader loader = new FXMLLoader(
									getClass().getClassLoader().getResource("view/Login.fxml"));
							loader.setControllerFactory(applicationContext::getBean);
							Parent root = loader.load();
							pantallasController.cambiarPantalla(root);
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("-----ERROR AL VOLVER A LA PANTALLA DE LOGIN-----");
						}
					}
				});
				correcto.show();

				// Si no coinciden se muestra un dialog en conforme no coinciden las contraseñas
			} else {
				System.out.println("No coinciden las contraseñas");

				JFXButton button = new JFXButton("Okay");
				JFXDialog error = pantallasController.crearDialog(new Text("Error"),
						new Text("Las contraseñas no coinciden"), stackPane, button);

				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						error.close();
					}
				});
				error.show();
			}
		}

	}

	@FXML
	void volverALogin(MouseEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		newNombre.setStyle("-fx-text-inner-color: white");
		newApellidos.setStyle("-fx-text-inner-color: white");
		
		newNombreUsuario.setStyle("-fx-text-inner-color: white");
		newCorreo.setStyle("-fx-text-inner-color: white");
		newPassword.setStyle("-fx-text-inner-color: white");
		repeatPassword.setStyle("-fx-text-inner-color: white");

		newCalle.setStyle("-fx-text-inner-color: white");
		newCiudad.setStyle("-fx-text-inner-color: white");
		newCodPostal.setStyle("-fx-text-inner-color: white");
		newPiso.setStyle("-fx-text-inner-color: white");
		newPortal.setStyle("-fx-text-inner-color: white");

	}
}
