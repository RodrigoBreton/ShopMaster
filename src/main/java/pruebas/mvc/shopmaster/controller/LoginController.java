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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pruebas.mvc.shopmaster.Main;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.IClientesDaoService;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;

@Component
public class LoginController implements Initializable {
	public static Stage resetPassWindow;

	public static Cliente currentCliente;
	
	@Autowired
	private ApplicationContext applicationContext;

	@FXML
    private AnchorPane loginPane;
	
	@FXML
	private JFXPasswordField passwordTF;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton sing_up;

	@FXML
	private JFXTextField userTF;

	@FXML
	private StackPane loginStackPane;

	@FXML
	private JFXButton forgotPass;
	
	@FXML
    private JFXButton close;
	
	@Autowired
	private IClientesDaoService dao; 
	
	@Autowired
    private PantallasController pantallasController;

	@FXML
	void makeLogin(ActionEvent event) throws IOException {
		
		String usernameInput = userTF.getText();
		String passInput = passwordTF.getText();

		boolean succesfull = false;

		List<Cliente> clientes = dao.obtenerClientes();

		// Bucle para recorrer los nombre de usuarios y contraseñas de bbdd y compararlos
		for (Cliente client : clientes) {
			String username = client.getNombreUsuario();
			String password = client.getPassword();
	
			if (username.equals(usernameInput) && password.equals(passInput)) {

				JFXButton ok = new JFXButton("okay");
				JFXDialog dialog = pantallasController.crearDialog(new Text("Bienvenido"), new Text("Contraseña y parametros correctos"),
						loginStackPane, ok);

				ok.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						dialog.close();
					}
				});
				dialog.show();
				succesfull = true;
				currentCliente = client;

			}
		}

		// En caso de no coincidir los datos se imprime una alerta
		if (succesfull == !true) {
			JFXButton ok = new JFXButton("OK");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Error en el Login"),
					new Text("Usuario o Contraseña incorrectos o están vacíos"), loginStackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialog.close();
				}
			});
			dialog.show();
		} else {
			// En caso de coincidir se dirije a la pantalla principal
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Productos.fxml"));
			loader.setControllerFactory(applicationContext::getBean);
			Parent root = loader.load();
			pantallasController.cambiarPantalla(root);
		}
	}

	@FXML
	public void makeNewAccount(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Registro.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
	}
	
	@FXML
    void openResetPass(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ResetPass.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
		
    }
	
	@FXML
    void exit(ActionEvent event) {
		Main.primaryStage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		passwordTF.setStyle("-fx-text-inner-color: white");
		userTF.setStyle("-fx-text-inner-color: white");
	}

}
