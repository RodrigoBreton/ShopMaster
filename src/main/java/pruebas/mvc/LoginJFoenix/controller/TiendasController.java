package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class TiendasController implements Initializable{
	
	@FXML
    private JFXDrawer menuDrawer;
	
	@FXML
    private JFXHamburger menuHamburger;

	PantallasController p = new PantallasController();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			p.cargarDrawer(menuDrawer);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}

		// Animacion del boton hamburger
		HamburgerBackArrowBasicTransition flechaIzq = new HamburgerBackArrowBasicTransition(menuHamburger);
		flechaIzq.setRate(-1);
		menuHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			flechaIzq.setRate(flechaIzq.getRate() * -1);
			flechaIzq.play();

			// Control del menu desplegable
			if (menuDrawer.isOpened()) {
				menuDrawer.close();
			} else {
				menuDrawer.open();
			}
		});
	}

	

}
