package pruebas.mvc.shopmaster.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
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
import pruebas.mvc.shopmaster.controller.TiendasController.TiendaVO;
import pruebas.mvc.shopmaster.modelo.entidades.Tienda;

@Component
public class TiendasDelProductoController implements Initializable {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private PantallasController pantallasController;
	
	@FXML
    private JFXTreeTableView<TiendaVO> treeView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Set<Tienda> tiendas = ProductosController.tiendasDelProducto;
		ObservableList<TiendaVO> tiendaVOs = FXCollections.observableArrayList();
		
		for(Tienda t : tiendas) {
			String nombre = t.getNombre();
			String calle = t.getDireccion().getCalle();
			String ciudad = t.getDireccion().getCiudad();
			
			TiendaVO tiendaVO = new TiendaVO();
			tiendaVO.setNombre(new SimpleStringProperty(nombre));
			tiendaVO.setCalle(new SimpleStringProperty(calle));
			tiendaVO.setCiudad(new SimpleStringProperty(ciudad));
			tiendaVOs.add(tiendaVO);
		}
		
//		Mosatrar Tabla
		
		JFXTreeTableColumn<TiendaVO, String> colNombre = new JFXTreeTableColumn<>("Nombre");
		colNombre.setMinWidth(250);
		colNombre.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TiendaVO,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<TiendaVO, String> param) {
				return param.getValue().getValue().nombre;
			}
		});
		
		JFXTreeTableColumn<TiendaVO, String> colDirec = new JFXTreeTableColumn<>("Direccion");
		colDirec.setMinWidth(250);
		colDirec.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<TiendaVO,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<TiendaVO, String> param) {
				return param.getValue().getValue().calle;
			}
		});
		
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
		
	}
	
	@FXML
    void goBack(MouseEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Productos.fxml"));
		loader.setControllerFactory(applicationContext::getBean);
		Parent root = loader.load();
		pantallasController.cambiarPantalla(root);
    }
	
}
