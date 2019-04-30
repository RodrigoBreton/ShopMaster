package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DrawerController implements Initializable {
	
	@FXML
    private VBox drawerVBox;

    @FXML
    private ImageView imgDrawer;

    @FXML
    private JFXButton btInicio;

    @FXML
    private JFXButton btPerfil;

    @FXML
    private JFXButton btTienda;

    @FXML
    private JFXButton btSalir;
	
	PantallasController p = new PantallasController();
	
	@FXML
    void goPrincipalPage(ActionEvent event) throws IOException {
		System.out.println("Esta intentando ir al login");
		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/PrincipalPage.fxml"));
		p.cambiarPantalla(window);
    }
	
	@FXML
    void goOut(ActionEvent event) throws IOException {
		System.out.println("Esta intentando ir al login");
		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/Login.fxml"));
		p.cambiarPantalla(window);
    }

	@FXML
    void goPerfil(ActionEvent event) throws IOException {
		System.out.println("Esta intentando ir a la pagina de perfil");
		Parent window = FXMLLoader.load(getClass().getClassLoader().getResource("view/PerfilCliente.fxml"));
		p.cambiarPantalla(window);

    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
