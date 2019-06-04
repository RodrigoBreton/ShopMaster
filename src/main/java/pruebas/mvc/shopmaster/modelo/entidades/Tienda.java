package pruebas.mvc.shopmaster.modelo.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tienda")
public class Tienda {
	
	private int id;
	private String nombre;
	private Direccion direccion;
	private Set<Producto> productos;
	
	public Tienda() {
		
	}
	
	public Tienda(String nombre, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_direccion")
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "productos_tiendas", 
	joinColumns = { @JoinColumn(name = "id_tienda") }, 
	inverseJoinColumns = { @JoinColumn(name = "id_producto")})
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}
