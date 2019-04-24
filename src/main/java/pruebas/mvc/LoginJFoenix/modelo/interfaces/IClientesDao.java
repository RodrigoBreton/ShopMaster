package pruebas.mvc.LoginJFoenix.modelo.interfaces;

import java.util.List;

import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;

public interface IClientesDao {
	
	public void guardarCliente(Cliente c);
	public List<Cliente> obtenerClientes();

}
