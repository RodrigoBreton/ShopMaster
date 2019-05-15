package pruebas.mvc.LoginJFoenix.modelo.dao.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.ITiendasDaoRepo;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.ITiendasDaoService;

@Service
public class TiendasDaoService implements ITiendasDaoService {

	@Autowired
	private ITiendasDaoRepo dao;
	
	@Override
	public void guardarTienda(Tienda t) {
		dao.guardarTienda(t);
		
	}

	@Override
	public Set<Tienda> obtenerTiendas() {
		return dao.obtenerTiendas();
	}
	
}
