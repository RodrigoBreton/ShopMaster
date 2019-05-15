package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;

public interface ITiendasDaoService {
	
	public void guardarTienda(Tienda t);
	public Set<Tienda> obtenerTiendas();

}
