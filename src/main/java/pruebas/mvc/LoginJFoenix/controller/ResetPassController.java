package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pruebas.mvc.LoginJFoenix.modelo.dao.repository.ClientesDaoRepo;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IClientesDaoService;

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

	PantallasController p = new PantallasController();

	@FXML
	void recuperarPass(ActionEvent event) {

		String usernameInput = username.getText();
		String mailInput = mail.getText();
		
		List<Cliente> clientes = dao.obtenerClientes();
		
		boolean succesfull = false;
//		Validacion usando el metodo de PantallasController
//		boolean succesfull = p.validacionEntrada(usernameInput, mailInput);
//		

//		
//		if(succesfull == true ) {
//			System.out.println("Datos correctos");
//		} else {
//			System.out.println("Datos incorrectos");
//		}

		for (Cliente c : clientes) {
			if (usernameInput.equals(c.getNombreUsuario()) && mailInput.equals(c.getEmail())) {
				Text contra = new Text(c.getPassword());
				JFXButton ok = new JFXButton("Iniciar Sesion");
				JFXDialog dialog = p.crearDialog(new Text("Su contraseña es:"), contra, stackPane, ok);

				ok.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
							p.cambiarPantalla(window);
							// Conseguir cerar la ventana
//							Stage resetStage = LoginController.resetPassWindow;
//							resetStage.close();

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
//		 se imprime un mensaje de erro a la hora de querer recuperar la contraseña
		if (succesfull == !true) {
			JFXButton ok = new JFXButton("okay");
			JFXDialog dialog = p.crearDialog(new Text("Error a la hora de recuperar la contraseña"),
					new Text("No existe ninguna cuenta con esos datos"), stackPane, ok);

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
