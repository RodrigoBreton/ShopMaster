package pruebas.mvc.LoginJFoenix.modelo.dao.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
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

	@Override
	public Set<Producto> obtenerProductos() {
		Session sesion = factory.openSession();
		
		String selectAll = "from Producto";
		List<Producto> productoList = sesion.createQuery(selectAll, Producto.class).getResultList();
		Set<Producto> productos = new HashSet<>(productoList);
		
		return productos;
	}

	@Override
	public Producto obtenerById(int id) {
		Session sesion = factory.openSession();
	
		Producto p = (Producto) sesion.createQuery("SELECT p FROM Producto p WHERE id=" + id).uniqueResult();
		
		return p;
	}

}
