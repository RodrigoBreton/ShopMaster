package pruebas.mvc.LoginJFoenix.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IClientesDao;

public class ClientesDao implements IClientesDao {
	private SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public ClientesDao() {
		
	}
	
	public void guardarCliente(Cliente c) {
		Session sesion = factory.openSession();
		Transaction t = sesion.beginTransaction();
		
		sesion.save(c);
		
		t.commit();
		sesion.close();
	}
	
	public List<Cliente> obtenerClientes() {
		Session sesion = factory.openSession();
		
		String selectAll = "from Cliente";
		List<Cliente> clientes = sesion.createQuery(selectAll, Cliente.class).getResultList();
		
		return clientes;
	}
	
	public void actualizarCliente(Cliente c) {
		Session sesion = factory.openSession();
		Transaction t = sesion.beginTransaction();
		
		sesion.update(c);
		
		t.commit();
		sesion.close();
	}

}
