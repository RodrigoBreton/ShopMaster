package pruebas.mvc.shopmaster.modelo.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	private int id;
	private String nombre;
	private String precio;
	private Set<Tienda> tiendas;
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String precio, Set<Tienda> tiendas) {
		this.nombre = nombre;
		this.precio = precio;
		this.tiendas = tiendas;
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
	
	@Column(name = "precio")
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@ManyToMany(mappedBy = "productos")
	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

}
