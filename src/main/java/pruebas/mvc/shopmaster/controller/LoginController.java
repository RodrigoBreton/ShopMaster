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
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Component
public class LoginController implements Initializable {
	public static Stage resetPassWindow; //variable que guarda la ventana de resetPass

	public static Cliente currentCliente;
	
	@Autowired
	private ApplicationContext applicationContext;

	@FXML
    private AnchorPane loginPane;
	
	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton sing_up;

	@FXML
	private JFXTextField user;

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

//		No se como utilizar los snackbars
//		JFXSnackbar iniciando = new JFXSnackbar(loginPane);
//		iniciando.enqueue(new SnackbarEvent(node));
		
		String usernameInput = user.getText();
		String passInput = password.getText();

		boolean succesfull = false;

		List<Cliente> clientes = dao.obtenerClientes();

		// Bucle para recorrer los nombre de usuarios y contraseñas de bbdd y compararlos
		for (Cliente client : clientes) {
			String username = client.getNombreUsuario();
			String password = client.getPassword();
			System.out.println(username);
			System.out.println(password);

			if (username.equals(usernameInput) && password.equals(passInput)) {

				JFXButton ok = new JFXButton("okay");
				JFXDialog dialog = pantallasController.crearDialog(new Text("Bienvenido"), new Text("Contraseña y parametros correctos"),
						loginStackPane, ok);

				ok.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						dialog.close();
					}
				});
				dialog.show();
				succesfull = true;
				currentCliente = client;

				System.out.println("Bienvenido");

			}
		}

		// En caso de no coincidir los datos se imprime una alerta
		System.out.println("Salida del bucle");
		if (succesfull == !true) {
			System.out.println("Esta entrando");
			JFXButton ok = new JFXButton("okay");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Error en el Login"),
					new Text("Usuario o Contraseña incorrectos"), loginStackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					dialog.close();
				}
			});
			dialog.show();
		} else {
			// En caso de coincidir se dirije a la pantalla principal
			System.out.println("Dirigiendose a la pantalla de productos");
			FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Productos.fxml"));
			loader.setControllerFactory(applicationContext::getBean);
			Parent root = loader.load();
			pantallasController.cambiarPantalla(root);
		}
	}

	@FXML
	public void makeNewAccount(ActionEvent event) throws IOException {
		System.out.println("Se ha pulsado el boton para ir a la pantalla de registro");

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/NewAccount.fxml"));
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

		password.setStyle("-fx-text-inner-color: white");
		user.setStyle("-fx-text-inner-color: white");
	}

}
