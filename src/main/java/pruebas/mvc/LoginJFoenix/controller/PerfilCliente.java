package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PerfilCliente implements Initializable {

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
	
	PantallasController p = new PantallasController();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			p.cargarDrawer(menuDrawer);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}

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
		
		//Obtener datos del cliente
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
		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/EditarPerfil.fxml"));
		p.cambiarPantalla(window);
    }

}
