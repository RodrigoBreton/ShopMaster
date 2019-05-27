package pruebas.mvc.LoginJFoenix.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXButton;
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
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Producto;
import pruebas.mvc.LoginJFoenix.modelo.entidades.Tienda;
import pruebas.mvc.LoginJFoenix.modelo.interfaces.IProductosDaoService;

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
	private JFXTreeTableView<Product> treeView;

	@Autowired
	private PantallasController pantallasController;

	@Autowired
	private IProductosDaoService daop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<Product> products = FXCollections.observableArrayList();
		Set<Producto> productos = daop.obtenerProductos();
		Set<Tienda> tiendas = new HashSet<>();

		for (Producto p : productos) {
			String obNombre = p.getNombre();
			String obPrecio = p.getPrecio();
			tiendas = p.getTiendas();

			Product p1 = new Product(obNombre, obPrecio);
			products.add(p1);
		}

//		Mostar los productos en una tabla
//		cabecera de la columna del nombre de los productos
		JFXTreeTableColumn<Product, String> colNombre = new JFXTreeTableColumn<>("Nombre");
		colNombre.setMinWidth(250);
		colNombre.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Product, String> param) {
						return param.getValue().getValue().nombre;
					}
				});

//		cabecera de la columna del nombre de los productos
		JFXTreeTableColumn<Product, String> colPrecio = new JFXTreeTableColumn<>("Precio");
		colPrecio.setMinWidth(250);
		colPrecio.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<Product, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<Product, String> param) {
						return param.getValue().getValue().precio;
					}
				});
		
//		cabecera par ala columna de botones
//		JFXTreeTableColumn actionColumn = new JFXTreeTableColumn("Disponibilidad");
//		actionColumn.setMinWidth(250);
//		actionColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
		
		
		final TreeItem<Product> root = new RecursiveTreeItem<Product>(products, RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(colNombre, colPrecio);
		treeView.setRoot(root);
		treeView.setShowRoot(false);

		try {
			pantallasController.cargarDrawerHamburger(menuDrawer, menuHamburger);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.err.println("------ ERROR AL CARGAR EL CONTENIDO DEL DRAWER ------");
		}
	}

	class Product extends RecursiveTreeObject<Product> {

		StringProperty nombre;
		StringProperty precio;
//		JFXButton button;

		public Product(String nombre, String precio) {
			super();
			this.nombre = new SimpleStringProperty(nombre);
			this.precio = new SimpleStringProperty(precio);
//			this.button = new JFXButton("Tiendas");
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

//		public JFXButton getButton() {
//			return button;
//		}
//
//		public void setButton(JFXButton button) {
//			this.button = button;
//		}
		
	}
}
