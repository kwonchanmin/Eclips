package managerview;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import managerBookmainview.ManagerBookMain;
import managercontroller.ManagerLoginController;
import managetvo.Manager;


public class ManagerMain {

//	TableView<User> tableView;
	TextField textField;
    Button loginbtn;
	private Text ID;
	private Text PW;
	TextField idtext;
	TextField pwtext;
	String id;
	String password;
	
	public BorderPane getLayout() {
		BorderPane root = new BorderPane();
		root.setPrefSize(200, 200);
		
		loginbtn = new Button("로그인");
		loginbtn.setPrefSize(100, 20);
		loginbtn.setOnAction(e->{
			
		ManagerLoginController controller = new ManagerLoginController();
		id = idtext.getText();
		password = pwtext.getText();
		ObservableList<Manager> list = controller.getResult(id,password);
			if (list.size()== 1) {
				
				Parent layout = new ManagerBookMain(list.get(0)).getLayout(); // () 안의 인자는 내가 새롭게 만든 클레스에 이 정보를 넘겨주는 자료들을 적어주는거다. 이 상황에서는!!
				Scene scene = new Scene(layout);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.show();
				stage.setTitle("관리자 모드");
			}else {
				System.out.println("X");
			}
			
		});
		
		ID = new Text("ID");
		ID.setWrappingWidth(70);
		
		PW = new Text("Password");
		PW.setWrappingWidth(70);
		
		idtext = new TextField();
		idtext.setPrefSize(200, 50);
		
		pwtext = new TextField();
		pwtext.setPrefSize(200, 50);
		
		FlowPane idflowPane = new FlowPane();
		idflowPane.setPrefSize(300, 50);
		idflowPane.setPadding(new Insets(10,10,10,10));
		idflowPane.setColumnHalignment(HPos.CENTER);
		idflowPane.setHgap(10);
		idflowPane.setOrientation(Orientation.HORIZONTAL);
		idflowPane.getChildren().add(ID);
		idflowPane.getChildren().add(idtext);
		
		FlowPane pwflowPane = new FlowPane();
		pwflowPane.setPrefSize(300, 50);
		pwflowPane.setPadding(new Insets(10,10,10,10));
		pwflowPane.setColumnHalignment(HPos.CENTER);
		pwflowPane.setHgap(10);
		pwflowPane.getChildren().add(PW);
		pwflowPane.getChildren().add(pwtext);

		FlowPane cmflowPane = new FlowPane();
		cmflowPane.setPrefSize(300, 50);
		cmflowPane.setPadding(new Insets(10,10,10,10));
		cmflowPane.setColumnHalignment(HPos.CENTER);
		cmflowPane.setHgap(10);
		cmflowPane.setOrientation(Orientation.VERTICAL);
		cmflowPane.getChildren().add(idflowPane);
		cmflowPane.getChildren().add(pwflowPane);
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(300, 40);
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(loginbtn);
	
		
		root.setCenter(cmflowPane);
		root.setBottom(flowPane);
		
		return root;
		
	}
}
