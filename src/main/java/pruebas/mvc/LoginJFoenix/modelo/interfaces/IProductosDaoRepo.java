package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;

public interface IProductosDaoRepo {
	
	public void guardarProducto(Producto p);
	public Set<Producto> obtenerProductos();
	public Producto obtenerById(int id);

}
