package pruebas.mvc.LoginJFoenix.modelo.dao.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoRepo;

@Repository
public class ProductosDaoRepo implements IProductosDaoRepo {
	private SessionFactory factory = HibernateConfig.getSessionFactory();
	
	@Override
	public void guardarProducto(Producto p) {
		Session sesion = factory.openSession();
		Transaction t = sesion.beginTransaction();

		sesion.save(p);

		t.commit();
		sesion.close();
	}

}
