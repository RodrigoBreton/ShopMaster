package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoService;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.ITiendasDaoService;

@Component
public class TiendasDosController implements Initializable {
	
	@FXML
    private JFXHamburger menuHamburger;

    @FXML
    private JFXDrawer menuDrawer;
    
//    @Autowired
//	private ApplicationContext applicationContext;

    @Autowired
    private PantallasController pantallasController;
    
    @Autowired
    private ITiendasDaoService dao;
    
    @Autowired
    private IProductosDaoService daop;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//		comprobacion de q funciona
//		Direccion d = new Direccion("Monasterio de bergondo", "14", "6", 1509, "Coruña");
//		Tienda t = new Tienda("Mediamark", d);
//		dao.guardarTienda(t);
		
//		comprobacion de inserccion de productos
//		Set<Tienda> tiendas = dao.obtenerTiendas();
//		Set<Producto> productos = new HashSet<>();
//		Producto p = new Producto("Tablet", 15.50, tiendas);
//		daop.guardarProducto(p);
		
		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}
		
	}
	

}
