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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import pruebas.mvc.shopmaster.modelo.entidades.Producto;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;
import pruebas.mvc.shopmaster.modelo.interfaces.IProductosDaoService;

@Component
public class ProductosController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private JFXHamburger menuHamburger;

	@FXML
	private JFXDrawer menuDrawer;

	@FXML
	private FlowPane main;

	@FXML
	private JFXTreeTableView<ProductoVO> treeView;

	@Autowired
	private PantallasController pantallasController;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private IProductosDaoService daop;
	
	public static Set<Tienda> tiendasDelProducto = new HashSet<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<ProductoVO> productoVOs = FXCollections.observableArrayList();
		Set<Producto> productos = daop.obtenerProductos();
		Set<Tienda> tiendas = new HashSet<>();
		
		for (Producto p : productos) {
			String obNombre = p.getNombre();
			String obPrecio = p.getPrecio();
			tiendas = p.getTiendas();

			ProductoVO p1 = new ProductoVO(obNombre, obPrecio, tiendas);
			productoVOs.add(p1);
		}

//		cabecera de la columna del nombre de los productos
		JFXTreeTableColumn<ProductoVO, String> colNombre = new JFXTreeTableColumn<>("Nombre");
		colNombre.setMinWidth(250);
		colNombre.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<ProductoVO, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<ProductoVO, String> param) {
						return param.getValue().getValue().nombre;
					}
				});

//		cabecera de la columna del nombre de los productos
		JFXTreeTableColumn<ProductoVO, String> colPrecio = new JFXTreeTableColumn<>("Precio");
		colPrecio.setMinWidth(250);
		colPrecio.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<ProductoVO, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<ProductoVO, String> param) {
						return param.getValue().getValue().precio;
					}
				});

		final TreeItem<ProductoVO> root = new RecursiveTreeItem<ProductoVO>(productoVOs, RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(colNombre, colPrecio);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		
//		Creo un EventHandler para cuando se haga click dentro de la tabla
		EventHandler<MouseEvent> filaSeleccionada = new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
//				Se selecciona el nombre del objeto seleccionado y se imprime por pantalla
				TreeItem<ProductoVO> productSelected = treeView.getSelectionModel().getSelectedItem();
				ProductoVO productoGetted = productSelected.getValue();
				StringProperty nombreObtenido = productoGetted.getNombre();
				tiendasDelProducto =  productoGetted.getTiendas();
				
				
				FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/ProductosDeLaTienda.fxml"));
				loader.setControllerFactory(applicationContext::getBean);
				try {
					Parent root = loader.load();
					pantallasController.cambiarPantalla(root);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
//				String nombreDeTienda = new String();
//				String calleDeTienda = new String();
//				String ciudadDeLaTienda = new String();
//				for(Tienda t : tiendasDelProducto){
//					nombreDeTienda = t.getNombre();
//					calleDeTienda = t.getDireccion().getCalle();
//					ciudadDeLaTienda = t.getDireccion().getCiudad();
//					nombresTiendas.add(nombreDeTienda);
//					System.out.println("El producto está disponible en la tienda " + nombreDeTienda + " que está en la calle " + calleDeTienda +
//							" en la ciudad "  + ciudadDeLaTienda);
//				}
//				System.out.println("El nombre del producto seleccionado es " + nombreObtenido);
				
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

	public class ProductoVO extends RecursiveTreeObject<ProductoVO> {

		StringProperty nombre;
		StringProperty precio;
		Set<Tienda> tiendas;

		public ProductoVO(String nombre, String precio, Set<Tienda> tiendas) {
			super();
			this.nombre = new SimpleStringProperty(nombre);
			this.precio = new SimpleStringProperty(precio);
			this.tiendas = tiendas;
		}

		public StringProperty getNombre() {
			return nombre;
		}

		public void setNombre(StringProperty nombre) {
			this.nombre = nombre;
		}

		public StringProperty getPrecio() {
			return precio;
		}

		public void setPrecio(StringProperty precio) {
			this.precio = precio;
		}

		public Set<Tienda> getTiendas() {
			return tiendas;
		}

		public void setTiendas(Set<Tienda> tiendas) {
			this.tiendas = tiendas;
		}
	}
}
