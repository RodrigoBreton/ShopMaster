	package pruebas.mvc.shopmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
//@Repository
public class Main extends Application {
	
	@Autowired
	private ApplicationContext applicationContext; 
	public static Stage primaryStage;	

	public void start(Stage stage) throws Exception {
		
		primaryStage = stage;
		
		// Quita el marco de la ventana
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("ShopMaster");
		
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/Login.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
 
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		// Establecer el color de relleno del Scene a transparente
        scene.setFill(Color.TRANSPARENT);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
    public static void main( String[] args ) {
    	launch(args);
    	
    }
    
    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = SpringApplication.run(Main.class, args);
    }

}

