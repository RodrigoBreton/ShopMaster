package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

@Component
public class TiendasController implements Initializable {

	@FXML
	private JFXDrawer menuDrawer;

	@FXML
	private JFXHamburger menuHamburger;

	@FXML
	private JFXListView<Label> categorias;
	
	@Autowired
	private PantallasController pantallasController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}

		try {
			Label comida = new Label("Comida");
			Label ropa = new Label("Ropa");
			Label herramientas = new Label("Herramientas");

			// Iconos del ListView
			Image pngComida = new Image("images/hamburguesa.png");
			ImageView iconComida = new ImageView(pngComida);
			comida.setGraphic(iconComida);
			
			categorias.getItems().add(comida);
			categorias.getItems().add(ropa);
			categorias.getItems().add(herramientas);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
