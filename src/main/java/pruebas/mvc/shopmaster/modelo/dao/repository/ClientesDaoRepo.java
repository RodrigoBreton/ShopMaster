package pruebas.mvc.shopmaster.modelo.dao.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pruebas.mvc.shopmaster.configuracion.HibernateConfig;
import pruebas.mvc.shopmaster.modelo.entidades.Cliente;
import pruebas.mvc.shopmaster.modelo.interfaces.IClientesDaoRepo;

@Repository
public class ClientesDaoRepo implements IClientesDaoRepo {
	private SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public ClientesDaoRepo() {
		
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
