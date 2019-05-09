package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.List;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;

public interface IClientesDaoService {
	
	public void guardarCliente(Cliente c);
	public List<Cliente> obtenerClientes();
	public void actualizarCliente(Cliente c);

}
