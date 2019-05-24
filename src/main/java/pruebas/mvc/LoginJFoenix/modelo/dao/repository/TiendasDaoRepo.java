package pruebas.mvc.LoginJFoenix.modelo.dao.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import pruebas.mvc.LoginJFoenix.configuracion.HibernateConfig;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Cliente;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.ITiendasDaoRepo;

@Repository
public class TiendasDaoRepo implements ITiendasDaoRepo {
	private SessionFactory factory = HibernateConfig.getSessionFactory();

	public TiendasDaoRepo() {

	}

	@Override
	public void guardarTienda(Tienda ti) {
		Session sesion = factory.openSession();
		Transaction t = sesion.beginTransaction();

		sesion.save(ti);

		t.commit();
		sesion.close();

	}

	@Override
	public Set<Tienda> obtenerTiendas() {
		Session sesion = factory.openSession();

		String selectAll = "from Tienda";
		List<Tienda> tiendasList = sesion.createQuery(selectAll, Tienda.class).getResultList();
		Set<Tienda> tiendas = new HashSet<>(tiendasList);
		
		sesion.close();
		return tiendas;
	}

}
