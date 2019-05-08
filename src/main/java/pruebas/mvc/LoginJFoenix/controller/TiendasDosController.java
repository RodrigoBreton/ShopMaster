package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TiendasDosController implements Initializable {
	
	@FXML
    private JFXHamburger menuHamburger;

    @FXML
    private JFXDrawer menuDrawer;

    PantallasController p = new PantallasController();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			p.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}
		
	}
	

}
