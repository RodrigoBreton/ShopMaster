package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import pruebas.mvc.LoginJFoenix.modelo.dao.ClientesDao;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Direccion;

public class NewAccountController implements Initializable{

	//Datos personales
	@FXML
    private JFXTextField newNombre;

    @FXML
    private JFXTextField newApellidos;

    @FXML
    private JFXDatePicker newFechaNacimiento;

    //Datos de la cuenta
    @FXML
    private JFXTextField newNombreUsuario;

    @FXML
    private JFXTextField newCorreo;

    @FXML
    private JFXPasswordField newPassword;

    @FXML
    private JFXPasswordField repeatPassword;
	
    //Direccion
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

    //Elementos varios
    @FXML
    private JFXButton buttonCrear;
    
    @FXML
    private StackPane stackPane;
    
    @FXML
    private ImageView volverAtrás;
    
    PantallasController p = new PantallasController();
    
    @FXML
    void crearCliente(ActionEvent event) {
    	
    	String contra = newPassword.getText();
    	String repeatContra = repeatPassword.getText();
    	
    	//Si las contraseñas coinciden se insertan los datos y se muestra un dialog de confirmacion
    	if(contra.equals(repeatContra)) {
    		
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
        	ClientesDao helper = new ClientesDao();
        	helper.guardarCliente(c);
        	
        	JFXButton singUp = new JFXButton("Iniciar sesión");
        	JFXDialog correcto = p.crearDialog(new Text("Todo listo!"), new Text("Se creó la cuenta correctamente"), stackPane, singUp);
        	
        	//Se le da una funcion al boton singUp
        	singUp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					//Vuelve a la pantalla de Login para iniciar sesion
					try {
						Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
						p.cambiarPantalla(window);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("-----ERROR AL VOLVER A LA PANTALLA DE LOGIN-----");
					}
				}
			});
        	correcto.show();
        	
    	//Si no coinciden se muestra un dialog en conforme no coinciden las contraseñas
    	} else {
    		System.out.println("No coinciden las contraseñas");
    		
    		JFXButton button = new JFXButton("Okay");
    		JFXDialog error = p.crearDialog(new Text("Error"), new Text("Las contraseñas no coinciden"), stackPane, button);
    		
    		button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					error.close();
				}
			});
    		error.show();
    	}
    }
    
    @FXML
    void volverALogin(MouseEvent event) throws IOException {
    	
    	Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
    	p.cambiarPantalla(window);

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
