package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import pruebas.mvc.LoginJFoenix.modelo.dao.ClientesDao;

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

	ClientesDao helpers = new ClientesDao();
	PantallasController p = new PantallasController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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

		// Se actualizan los datos
		helpers.actualizarCliente(LoginController.currentCliente);

		// Se crea un dialog para indicar que se realizo la actualizacion correctamente
		// y para redirigir a la pagina de PerfilCliente
		JFXButton ok = new JFXButton("okay");
		JFXDialog actCompletada = p.crearDialog(new Text("¡Correcto!"),
				new Text("Se han actualizado correctamente los datos"), stackPane, ok);

		ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
					p.cambiarPantalla(window);
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

		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
		p.cambiarPantalla(window);

	}

}
