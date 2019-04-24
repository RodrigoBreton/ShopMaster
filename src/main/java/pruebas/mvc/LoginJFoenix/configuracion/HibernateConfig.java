package pruebas.mvc.LoginJFoenix.configuracion;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {
	
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		if(factory == null) {
			buildSessionFactory();
		}
		return factory;
	}
	
	private static void buildSessionFactory() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources metadataSources = new MetadataSources(registry);
		Metadata metadata = metadataSources.buildMetadata();

		factory = metadata.buildSessionFactory();
	}
	
	public static void shutdown() {
		factory.close();
	}
}
