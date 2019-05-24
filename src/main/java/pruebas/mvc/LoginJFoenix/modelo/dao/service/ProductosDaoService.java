package pruebas.mvc.LoginJFoenix.modelo.dao.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoRepo;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoService;

@Service
public class ProductosDaoService implements IProductosDaoService {

	@Autowired
	private IProductosDaoRepo dao;
	
	@Override
	public void guardarProducto(Producto p) {
		dao.guardarProducto(p);
	}

	@Override
	public Set<Producto> obtenerProductos() {
		Set<Producto> productos = new HashSet<>();
		return productos = dao.obtenerProductos();
	}

	@Override
	public Producto obtenerById(int id) {
		Producto p = dao.obtenerById(id);
		return p;
	}

}
