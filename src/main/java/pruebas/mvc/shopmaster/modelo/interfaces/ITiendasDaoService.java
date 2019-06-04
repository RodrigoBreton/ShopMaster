package pruebas.mvc.shopmaster.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

public interface ITiendasDaoService {
	
	public void guardarTienda(Tienda t);
	public Set<Tienda> obtenerTiendas();

}
