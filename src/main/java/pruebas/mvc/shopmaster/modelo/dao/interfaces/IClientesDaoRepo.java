package pruebas.mvc.shopmaster.modelo.dao.interfaces;

import java.util.List;

import pruebas.mvc.shopmaster.modelo.entidades.Cliente;

public interface IClientesDaoRepo {
	
	public void guardarCliente(Cliente c);
	public List<Cliente> obtenerClientes();
	public void actualizarCliente(Cliente c);
	public void eliminarCliente(Cliente c);

}
