package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


//   .\compilar.bat view.Boundary

public class Boundary extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		TabPane telaPrincialPane = new TabPane();
		Scene scn = new Scene(telaPrincialPane, 500, 500);
		
		Tab tabCadastroDoadoresSangue = new Tab("Cadastro de Doadores de Sangue",
				new CadastroDoadoresSangue().getTela());
		tabCadastroDoadoresSangue.setClosable(false);
		
		Tab AgendamentoDoacaoSangue = new Tab("Agendamento de Doacacao de Sangue",
				new AgendamentoDoacaoSangue().getTela());
		AgendamentoDoacaoSangue.setClosable(false);
		
		telaPrincialPane.getTabs().addAll(tabCadastroDoadoresSangue, AgendamentoDoacaoSangue);
		
		stage.setScene(scn);
		stage.setTitle(STYLESHEET_CASPIAN);
		stage.show();
		
		}
		
		
	public static void main(String[] args) {
		Application.launch(Boundary.class, args);
	}

}
