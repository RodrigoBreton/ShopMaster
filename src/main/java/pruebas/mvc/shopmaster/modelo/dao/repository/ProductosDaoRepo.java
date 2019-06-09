package pruebas.mvc.shopmaster.modelo.dao.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pruebas.mvc.shopmaster.configuracion.HibernateConfig;
import pruebas.mvc.shopmaster.modelo.entidades.Producto;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;
import pruebas.mvc.shopmaster.modelo.interfaces.IProductosDaoRepo;

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
}
