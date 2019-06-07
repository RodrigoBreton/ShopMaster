package pruebas.mvc.shopmaster.controller;

import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.TextField;

@Component
public class Validaciones {
	
	public boolean validarCampoVacio(TextField textField) {
		boolean vacio = true; 
		
		if(textField.getText().isEmpty()) {
			vacio = true;
		} else {
			vacio = false;
		}
		
		return vacio;
	}
	
	public boolean esIgual(String palabra, String palabra1) {
		boolean correcto = false;
		
		if(palabra.equals(palabra1)) {
			correcto = true;
		}
		
		return correcto;
	}
	
	

}
