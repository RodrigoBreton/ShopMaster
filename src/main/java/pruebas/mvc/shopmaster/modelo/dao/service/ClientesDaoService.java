package pruebas.mvc.shopmaster.modelo.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoRepo;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoService;

@Service
public class ClientesDaoService implements IClientesDaoService{

	@Autowired
	private IClientesDaoRepo dao;
	
	@Override
	public void guardarCliente(Cliente c) {
		dao.guardarCliente(c);
		
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return dao.obtenerClientes();
	}

	@Override
	public void actualizarCliente(Cliente c) {
		dao.actualizarCliente(c);
	}

	@Override
	public void eliminarCliente(Cliente c) {
		dao.eliminarCliente(c);
	}

}
