package pruebas.mvc.shopmaster.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.shopmaster.modelo.entidades.Producto;

public interface IProductosDaoService {
	
	public void guardarProducto(Producto p);
	public Set<Producto> obtenerProductos();

}
