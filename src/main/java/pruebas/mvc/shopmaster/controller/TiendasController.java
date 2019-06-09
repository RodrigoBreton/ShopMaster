package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.IProductosDaoService;
import pruebas.mvc.shopmaster.modelo.dao.interfaces.ITiendasDaoService;
import pruebas.mvc.shopmaster.modelo.entidades.Producto;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

@Component
public class TiendasController implements Initializable {
	
	@FXML
    private JFXHamburger menuHamburger;

    @FXML
    private JFXDrawer menuDrawer;
    
    @Autowired
	private ApplicationContext applicationContext;

    @Autowired
    private PantallasController pantallasController;
    
    @Autowired
    private ITiendasDaoService dao;
    
    @Autowired
    private IProductosDaoService daop;
    
    @FXML
    private FlowPane main;

    @FXML
    private JFXTreeTableView<TiendaVO> treeView;
    
    public static Set<Producto> productosDeLaTienda = new HashSet<>();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<TiendaVO> tiendaVOs = FXCollections.observableArrayList();
		Set<Tienda> tiendas = dao.obtenerTiendas();
		Set<Producto> productos = new HashSet<>();
		
		for (Tienda t : tiendas) {
			String nombre = t.getNombre();
			productos = t.getProductos();
			String calle = t.getDireccion().getCalle();
			String ciudad = t.getDireccion().getCiudad();
			
			TiendaVO tiendaVO = new TiendaVO();
			tiendaVO.setNombre(new SimpleStringProperty(nombre));
			tiendaVO.setCalle(new SimpleStringProperty(calle));
			tiendaVO.setCiudad(new SimpleStringProperty(ciudad));
			tiendaVO.setProductos(productos);
			tiendaVOs.add(tiendaVO);
		}
		
//		Mostar las tiendas en una tabla
		
//		columna del nombre de la tienda (cabecera)
		JFXTreeTableColumn<TiendaVO, String> colNombre = new JFXTreeTableColumn<>("Nombre");
		colNombre.setMinWidth(250);
		colNombre.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TiendaVO,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<TiendaVO, String> param) {
				return param.getValue().getValue().nombre;
			}
		});
		
		
//		columna de la direccion de la tienda (cabecera)
		JFXTreeTableColumn<TiendaVO, String> colDirec = new JFXTreeTableColumn<>("Direccion");
		colDirec.setMinWidth(250);
		colDirec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TiendaVO,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<TiendaVO, String> param) {
				return param.getValue().getValue().calle;
			}
		});
		
//		columna de la ciudad de la tienda (cabecera)
		JFXTreeTableColumn<TiendaVO, String> colCiudad = new JFXTreeTableColumn<>("Ciudad");
		colCiudad.setMinWidth(250);
		colCiudad.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TiendaVO,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<TiendaVO, String> param) {
				return param.getValue().getValue().ciudad;
			}
		});
		
		final TreeItem<TiendaVO> root = new RecursiveTreeItem<TiendaVO>(tiendaVOs, RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(colNombre, colDirec, colCiudad);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		
//		Creo un EventHandler para cuando se haga click dentro de la tabla
		EventHandler<MouseEvent> filaSeleccionada = new EventHandler<MouseEvent>() {
			
			
			@Override
			public void handle(MouseEvent event) {
//				Se obtienen los nombres de los prouctos disponibles en la tienda
				TreeItem<TiendaVO> tiendaSeleccionada = treeView.getSelectionModel().getSelectedItem();
				TiendaVO tiendaObtenida = tiendaSeleccionada.getValue();
				productosDeLaTienda = tiendaObtenida.getProductos();
				
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ProductosDeLaTienda.fxml"));
				loader.setControllerFactory(applicationContext::getBean);
				try {
					Parent root = loader.load();
					pantallasController.cambiarPantalla(root);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		if(filaSeleccionada != null) {
			treeView.setOnMouseClicked(filaSeleccionada);
		}
		
		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}
	}
	
	public static class TiendaVO extends RecursiveTreeObject<TiendaVO> {
		
		int id;
		StringProperty nombre;
		StringProperty calle;
		StringProperty ciudad;
		private Set<Producto> productos;
		
		public TiendaVO(int id, String nombre, String calle, String ciudad ,Set<Producto> productos) {
			this.id = id;
			this.nombre = new SimpleStringProperty(nombre);
			this.calle = new SimpleStringProperty(calle);
			this.ciudad = new SimpleStringProperty(ciudad);
			setProductos(new HashSet<Producto>());
		}
		
		public TiendaVO() {
			
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public StringProperty getNombre() {
			return nombre;
		}

		public void setNombre(StringProperty nombre) {
			this.nombre = nombre;
		}

		public Set<Producto> getProductos() {
			return productos;
		}

		public void setProductos(Set<Producto> productos) {
			this.productos = productos;
		}

		public StringProperty getCalle() {
			return calle;
		}

		public void setCalle(StringProperty calle) {
			this.calle = calle;
		}

		public StringProperty getCiudad() {
			return ciudad;
		}

		public void setCiudad(StringProperty ciudad) {
			this.ciudad = ciudad;
		}
	}
}
