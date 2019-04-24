package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pruebas.mvc.LoginJFoenix.modelo.dao.ClientesDao;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;

public class LoginController implements Initializable {
	public static Stage resetPassWindow; //variable que guarda la ventana de resetPass

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

	PantallasController p = new PantallasController();

//	private void setGlobalEventHandler(Node root) {
//		root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
//			if (ev.getCode() == KeyCode.ENTER) {
//				login.fire();
//				ev.consume();
//			}
//		});
//	}

	@FXML
	void makeLogin(ActionEvent event) throws IOException {

		String usernameInput = user.getText();
		String passInput = password.getText();

		boolean succesfull = false;

		ClientesDao helpers = new ClientesDao();
		List<Cliente> clientes = helpers.obtenerClientes();

		// Bucle para recorrer los nombre de usuarios y contraseñas de bbdd y
		// compararlos
		// para comprobar que coincidan
		for (Cliente client : clientes) {
			String username = client.getNombreUsuario();
			String password = client.getPassword();
			System.out.println(username);
			System.out.println(password);

			if (username.equals(usernameInput) && password.equals(passInput)) {

				JFXButton ok = new JFXButton("okay");
				JFXDialog dialog = p.crearDialog(new Text("Bienvenido"), new Text("Contraseña y parametros correctos"),
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

				System.out.println("Bienvenido");

			}
		}

		// En caso de no coincidir el nombre de usuario o la contraseña con el que hay
		// en bbdd
		// se imprime un mensaje por pantalla
		System.out.println("Salida del bucle");
		if (succesfull == !true) {
			System.out.println("Esta entrando");
			JFXButton ok = new JFXButton("okay");
			JFXDialog dialog = p.crearDialog(new Text("Error en el Login"),
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
			// En caso de coincidir se dirije al usuario del programa a la pantalla
			// principal
			System.out.println("Dirigiendose a la pantalla principal");
			Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/PrincipalPage.fxml"));
			p.cambiarPantalla(window);
		}
	}

	// Método para ir a la pantalla de registro y crear una cuenta
	@FXML
	public void makeNewAccount(ActionEvent event) throws IOException {
		System.out.println("Se ha pulsado el boton para ir a la pantalla de registro");

		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/NewAccount.fxml"));
		p.cambiarPantalla(window);

	}
	
	@FXML
    void openResetPass(ActionEvent event) throws IOException {
		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/ResetPass.fxml"));
		p.nuevaVentana(window);
		
//		Encontrar la manera de cerar una ventana 
//		resetPassWindow.setScene(new Scene (window));
//		resetPassWindow.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
