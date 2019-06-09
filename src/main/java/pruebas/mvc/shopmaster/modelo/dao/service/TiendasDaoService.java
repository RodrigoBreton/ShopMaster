package pruebas.mvc.shopmaster.modelo.dao.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebas.mvc.shopmaster.modelo.dao.interfaces.ITiendasDaoRepo;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.ITiendasDaoService;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

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
