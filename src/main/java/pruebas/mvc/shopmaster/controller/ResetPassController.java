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
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

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
				JFXDialog dialog = pantallasController.crearDialog(new Text("Su contraseña es:"), contra, stackPane, ok);

				ok.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						try {
							FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
							loader.setControllerFactory(applicationContext::getBean);
							Parent root = loader.load();
							pantallasController.cambiarPantalla(root);
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
//		 se imprime un mensaje de error
		if (succesfull == !true) {
			JFXButton ok = new JFXButton("okay");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Error a la hora de recuperar la contraseña"),
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

		mail.setStyle("-fx-text-inner-color: white");
		username.setStyle("-fx-text-inner-color: white");
	}

}
