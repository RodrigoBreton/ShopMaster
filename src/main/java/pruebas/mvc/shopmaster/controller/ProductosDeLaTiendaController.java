package pruebas.mvc.shopmaster.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.stereotype.Component;

import javafx.fxml.Initializable;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

@Component
public class ProductosDeLaTiendaController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Set<Tienda> tiendas = new HashSet<>();
		tiendas = ProductosController.tiendasDelProducto;
		
		for(Tienda t : tiendas) {
			String nombre = t.getNombre();
			System.out.println("El Producto está disponible en la tienda: " + nombre);
		}
		
	}
	
	
	
}
