package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXPasswordField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.IClientesDaoService;

@Component
public class CambiarContrasenhaController implements Initializable {
	
	@FXML
    private JFXPasswordField nuevaContrasenha1;

    @FXML
    private JFXPasswordField nuevaContrasenha2;

    @FXML
    private JFXButton btAceptar;

    @FXML
    private JFXButton btCancelar;
    
    @FXML
    private StackPane stackPane;
    
    @Autowired
    private PantallasController pantallasController;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private Validaciones validar;
    
    @Autowired
    private IClientesDaoService clientesService;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {

    	nuevaContrasenha1.setStyle("-fx-text-inner-color: white");
		nuevaContrasenha2.setStyle("-fx-text-inner-color: white");
		
	}

    @FXML
    void cambiarContrasenha(ActionEvent event) {
    	if(validar.esIgual(nuevaContrasenha1.getText(), nuevaContrasenha2.getText()) == true &&
    			(validar.validarCampoVacio(nuevaContrasenha1) == false || validar.validarCampoVacio(nuevaContrasenha2) == false)) {
    			
    		LoginController.currentCliente.setPassword(nuevaContrasenha1.getText());
    		clientesService.actualizarCliente(LoginController.currentCliente);
    		
    		JFXButton ok = new JFXButton("OK");
			JFXDialog dialog = pantallasController.crearDialog(new Text("Contraseña Actualizada"),
					new Text("Se ha actualizado la contraseña correctamente"), stackPane, ok);

			ok.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					
					FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
					loader.setControllerFactory(applicationContext::getBean);
					Parent root;
					try {
						root = loader.load();
						pantallasController.cambiarPantalla(root);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			dialog.show();
    		
    	} else {
    		JFXButton ok = new JFXButton("OK");
    		JFXDialog dialog = pantallasController.crearDialog(new Text("Error"), new Text("Las contraseñas introducidas no coinciden o los campos requeridos están vacíos"), 
    				stackPane, ok);
    		
    		ok.setOnAction(new EventHandler<ActionEvent>() { 
    			@Override
				public void handle(ActionEvent event) { 
    				dialog.close();
    			}
			});
    		dialog.show();
    	}
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ResetPass.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
    }
}
