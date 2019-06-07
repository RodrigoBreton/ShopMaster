package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

@Component
public class DrawerController implements Initializable {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@FXML
    private VBox drawerVBox;

    @FXML
    private ImageView imgDrawer;

    @FXML
    private JFXButton btProductos;

    @FXML
    private JFXButton btPerfil;

    @FXML
    private JFXButton btTienda;

    @FXML
    private JFXButton btSalir;
	
    @Autowired
	private PantallasController pantallasController;
	
	@FXML
    void goProductos(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Productos.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
		
    }
	
	@FXML
    void goOut(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
    }

	@FXML
    void goPerfil(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);

    }
	
	@FXML
    void goTiendas(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Tiendas.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
