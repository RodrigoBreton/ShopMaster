package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
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
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Component
public class EditarPerfilController implements Initializable {

	@FXML
	private JFXTextField nombre;

	@FXML
	private JFXTextField nombreUsuario;

	@FXML
	private JFXTextField apellidos;

	@FXML
	private JFXTextField correo;

	@FXML
	private JFXTextField calle;

	@FXML
	private JFXTextField portal;

	@FXML
	private JFXTextField piso;

	@FXML
	private JFXTextField codPostal;

	@FXML
	private JFXTextField ciudad;

	@FXML
	private StackPane stackPane;

	@Autowired
	private IClientesDaoService dao;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private PantallasController pantallasController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//Letras blancas del input
		nombre.setStyle("-fx-text-inner-color: white");
		apellidos.setStyle("-fx-text-inner-color: white");
		nombreUsuario.setStyle("-fx-text-inner-color: white");
		correo.setStyle("-fx-text-inner-color: white");
		
		calle.setStyle("-fx-text-inner-color: white");
		portal.setStyle("-fx-text-inner-color: white");
		piso.setStyle("-fx-text-inner-color: white");
		codPostal.setStyle("-fx-text-inner-color: white");
		ciudad.setStyle("-fx-text-inner-color: white");

		// Rellenar los inputs con los valores iniciales del perfil
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
	public void updateCliente(ActionEvent event) {

		// Se obtienen los datos de los inputs
		String updateNombre = nombre.getText();
		String updateApellidos = apellidos.getText();
		String updateNombreUsuario = nombreUsuario.getText();
		String updateCorreo = correo.getText();

		String updateCalle = calle.getText();
		String updatePortal = portal.getText();
		String updatePiso = piso.getText();
		int updateCodPostal = Integer.parseInt(codPostal.getText());
		String updateCiudad = ciudad.getText();

		// Se setean los datos obtenidos de los inputs
		LoginController.currentCliente.setNombre(updateNombre);
		LoginController.currentCliente.setApellidos(updateApellidos);
		LoginController.currentCliente.setNombreUsuario(updateNombreUsuario);
		LoginController.currentCliente.setEmail(updateCorreo);

		LoginController.currentCliente.getDireccion().setCalle(updateCalle);
		LoginController.currentCliente.getDireccion().setPortal(updatePortal);
		LoginController.currentCliente.getDireccion().setPiso(updatePiso);
		LoginController.currentCliente.getDireccion().setCodPostal(updateCodPostal);
		LoginController.currentCliente.getDireccion().setCiudad(updateCiudad);

		dao.actualizarCliente(LoginController.currentCliente);

		// Se crea un dialog para indicar que se realizo la actualizacion correctamente
		JFXButton ok = new JFXButton("OK");
		JFXDialog actCompletada = pantallasController.crearDialog(new Text("¡Correcto!"),
				new Text("Se han actualizado correctamente los datos"), stackPane, ok);

		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
					loader.setControllerFactory(applicationContext::getBean);
					Parent root = loader.load();
					pantallasController.cambiarPantalla(root);
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("------ ERROR AL DIRIGIRSE A LA PGINA DE PERFIL DEL CLIENTE ------");
				}
			}
		});
		actCompletada.show();
	}

	@FXML
	void volverPerfilCliente(MouseEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);

	}

}
