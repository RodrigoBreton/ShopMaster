package pruebas.mvc.shopmaster.modelo.dao.interfaces;

import java.util.Set;

import pruebas.mvc.shopmaster.modelo.entidades.Producto;

public interface IProductosDaoRepo {
	
	public void guardarProducto(Producto p);
	public Set<Producto> obtenerProductos();
}
