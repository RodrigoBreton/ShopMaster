package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import pruebas.mvc.shopmaster.controller.ProductosController.ProductoVO;
import pruebas.mvc.shopmaster.controller.TiendasController.TiendaVO;
import pruebas.mvc.shopmaster.modelo.entidades.Producto;

@Component
public class ProductosDeLaTiendaController implements Initializable {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private PantallasController pantallasController;

	@FXML
	private JFXTreeTableView<ProductoVO> treeView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Set<Producto> productos = TiendasController.productosDeLaTienda;
		ObservableList<ProductoVO> productoVOs = FXCollections.observableArrayList(); 
		
		for(Producto p : productos) {
			String nombre = p.getNombre();
			String precio = p.getPrecio();
			
			ProductoVO productoVO = new ProductoVO();
			productoVO.setNombre(new SimpleStringProperty(nombre));
			productoVO.setPrecio(new SimpleStringProperty(precio));
			productoVOs.add(productoVO);
		}
		
//		Mostrar tabla
		
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
		
	}

	@FXML
	void goBack(MouseEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Tiendas.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
	}

}
