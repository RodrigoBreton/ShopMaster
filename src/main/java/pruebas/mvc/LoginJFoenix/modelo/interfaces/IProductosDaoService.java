package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;

public interface IProductosDaoService {
	
	public void guardarProducto(Producto p);
	public Set<Producto> obtenerProductos();
	public Producto obtenerById(int id);

}
