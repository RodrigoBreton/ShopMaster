package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class PrincipalPageController implements Initializable {
	
	@FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXHamburger menuHamburger;

    @FXML
    private JFXDrawer menuDrawer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			//Carga el contenido del menú desplegable de la derecha de la scene
			VBox box = FXMLLoader.load(getClass().getClassLoader().getResource("view/ContentPrincipalDrawer.fxml"));
			menuDrawer.setSidePane(box);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------------ERROR CARGANDO EL INTERIOR DEL DRAWER------------");
		}
		
		//Animacion del boton hamburger
		HamburgerBackArrowBasicTransition flechaIzq = new HamburgerBackArrowBasicTransition(menuHamburger);
		flechaIzq.setRate(-1);
		menuHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
			flechaIzq.setRate(flechaIzq.getRate()*-1);
			flechaIzq.play();
			
			//Control del menu desplegable
			if(menuDrawer.isOpened()){
				menuDrawer.close();
			} else {
				menuDrawer.open();
			}
		});
	}
}
