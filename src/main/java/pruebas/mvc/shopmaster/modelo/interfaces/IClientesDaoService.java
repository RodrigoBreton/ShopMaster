package pruebas.mvc.shopmaster.modelo.interfaces;

import java.util.List;

import pruebas.mvc.shopmaster.modelo.entidades.Cliente;

public interface IClientesDaoService {
	
	public void guardarCliente(Cliente c);
	public List<Cliente> obtenerClientes();
	public void actualizarCliente(Cliente c);

}
