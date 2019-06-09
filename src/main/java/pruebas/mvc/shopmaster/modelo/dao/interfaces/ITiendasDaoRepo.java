package pruebas.mvc.shopmaster.modelo.dao.interfaces;

import java.util.Set;

import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

public interface ITiendasDaoRepo {
	
	public void guardarTienda(Tienda t);
	public Set<Tienda> obtenerTiendas();

}
