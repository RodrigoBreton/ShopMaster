package pruebas.mvc.shopmaster.converters;

import java.util.Set;

import pruebas.mvc.shopmaster.controller.TiendasController.TiendaVO;
import pruebas.mvc.shopmaster.modelo.entidades.Direccion;
import pruebas.mvc.shopmaster.modelo.entidades.Producto;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

public class ConverterVO {
	
	public static TiendaVO convertirTiendaAVO(Set<Tienda> tiendas){
		TiendaVO tiendaVO;
		
		for(Tienda t : tiendas) {
			int idTienda = t.getId();
			String nombreDeTienda = t.getNombre();
			Direccion direccionTienda = t.getDireccion();
			Set<Producto> productos = t.getProductos();
		}
		
		return null;
	}

}
