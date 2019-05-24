package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.action.internal.CollectionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoService;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.ITiendasDaoService;

@Component
public class TiendasDosController implements Initializable {
	
	@FXML
    private JFXHamburger menuHamburger;

    @FXML
    private JFXDrawer menuDrawer;
    
//    @Autowired
//	private ApplicationContext applicationContext;

    @Autowired
    private PantallasController pantallasController;
    
    @Autowired
    private ITiendasDaoService dao;
    
    @Autowired
    private IProductosDaoService daop;
    
    @FXML
    private FlowPane main;

    @FXML
    private JFXTreeTableView<Shop> treeView;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//		comprobacion de q funciona
//		Direccion d = new Direccion("Monasterio de bergondo", "14", "6", 1509, "Coruña");
//		Tienda t = new Tienda("Mediamark", d);
//		dao.guardarTienda(t);
		
//		comprobacion de la obtencion de los nombres de las tiendas a las que pertenece un producto
//		Pasando una determinada id
		
		Set<Tienda> tiendass = new HashSet<>();
		Producto productoSeleccionado = daop.obtenerById(1);
		ArrayList<String> nombresTiendas = new ArrayList<>(); 
		tiendass = productoSeleccionado.getTiendas();
		for(Tienda t : tiendass) {
			nombresTiendas.add(t.getNombre());
		}
		System.out.println(nombresTiendas);
		
		ObservableList<Shop> shops = FXCollections.observableArrayList();
		Set<Tienda> tiendas = dao.obtenerTiendas();
		
		for (Tienda t : tiendas) {
			String obNombre = t.getNombre();
			String obDireccion = (t.getDireccion().getCalle() + ", " + t.getDireccion().getPortal() + ", " + t.getDireccion().getCodPostal());
			String obCiudad = t.getDireccion().getCiudad();
			
			Shop s = new Shop(obNombre, obDireccion, obCiudad);
			shops.add(s);
		}
		
//		Mostar las tiendas en una tabla
		
//		columna del nombre de la tienda (cabecera)
		JFXTreeTableColumn<Shop, String> colNombre = new JFXTreeTableColumn<>("Nombre");
		colNombre.setMinWidth(250);
		colNombre.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Shop,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Shop, String> param) {
				return param.getValue().getValue().nombre;
			}
		});
		
		
//		columna de la direccion de la tienda (cabecera)
		JFXTreeTableColumn<Shop, String> colDirec = new JFXTreeTableColumn<>("Direccion");
		colDirec.setMinWidth(250);
		colDirec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Shop,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Shop, String> param) {
				return param.getValue().getValue().direccion;
			}
		});
		
//		columna de la ciudad de la tienda (cabecera)
		JFXTreeTableColumn<Shop, String> colCiudad = new JFXTreeTableColumn<>("Ciudad");
		colCiudad.setMinWidth(250);
		colCiudad.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Shop,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Shop, String> param) {
				return param.getValue().getValue().ciudad;
			}
		});
		
//		ObservableList<Shop> shops = FXCollections.observableArrayList();
//		shops.add(new Shop("MediaMark", "CC Marineda"));
//		shops.add(new Shop("San Brandan", "c/Barcelona"));
//		shops.add(new Shop("Gadis", "Monasterio de bergondo"));
		
		final TreeItem<Shop> root = new RecursiveTreeItem<Shop>(shops, RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(colNombre, colDirec, colCiudad);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		
		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}
		
	}
	
	class Shop extends RecursiveTreeObject<Shop> {
		
		StringProperty nombre;
		StringProperty direccion;
		StringProperty ciudad;
		
		public Shop(String nombre, String direccion, String ciudad) {
			this.nombre = new SimpleStringProperty(nombre);
			this.direccion = new SimpleStringProperty(direccion);
			this.ciudad = new SimpleStringProperty(ciudad);
					
		}

		public StringProperty getNombre() {
			return nombre;
		}

		public void setNombre(StringProperty nombre) {
			this.nombre = nombre;
		}

		public StringProperty getDireccion() {
			return direccion;
		}

		public void setDireccion(StringProperty direccion) {
			this.direccion = direccion;
		}

		public StringProperty getCiudad() {
			return ciudad;
		}

		public void setCiudad(StringProperty ciudad) {
			this.ciudad = ciudad;
		}
		
	}
	

}
