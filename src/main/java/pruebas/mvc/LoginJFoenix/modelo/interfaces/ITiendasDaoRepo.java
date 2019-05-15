package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.Set;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;

public interface ITiendasDaoRepo {
	
	public void guardarTienda(Tienda t);
	public Set<Tienda> obtenerTiendas();

}
