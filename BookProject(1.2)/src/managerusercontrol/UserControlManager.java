package managerusercontrol;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import manageramend.ManagerUserAmend;
import managercontroller.ManagerUserDeleteController;
import managercontroller.ManagerUserSearchController;
import userVO.User;

public class UserControlManager {

	TableView<User> tableView;
	Button amendbtn;
	Button deletebtn;
	TextField usertext;
	User user;
	String searchKeyword;
	String deleteid;

	public BorderPane getLayout() {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 500);

		amendbtn = new Button("회원정보수정");
		amendbtn.setPrefSize(100, 50);
		amendbtn.setOnAction(e -> {
			
			Parent layout = new ManagerUserAmend(user).getLayout();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			stage.setTitle("회원정보 수정");
			
		});

		deletebtn = new Button("회원삭제");
		deletebtn.setDisable(true);
		deletebtn.setPrefSize(100, 50);
		deletebtn.setOnAction(e -> {

			ManagerUserDeleteController controller = new ManagerUserDeleteController();
			ObservableList<User> list = controller.getResult(deleteid,searchKeyword);
			tableView.setItems(list);
		});

		usertext = new TextField();
		usertext.setPrefSize(200, 50);
		usertext.setOnAction(e->{
			
			ManagerUserSearchController controller = new ManagerUserSearchController();
			ObservableList<User> list = controller.getResult(usertext.getText());
			tableView.setItems(list);
			searchKeyword = usertext.getText();
			usertext.clear();
		});

		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(300, 100);
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setHgap(10);
		flowPane.getChildren().add(usertext);
		flowPane.getChildren().add(amendbtn);
		flowPane.getChildren().add(deletebtn);

		TableColumn<User, String> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<User, String> nameColumn = new TableColumn<>("NAME");
		nameColumn.setMinWidth(150);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<User, String> passwordColumn = new TableColumn<>("PASSWORD");
		passwordColumn.setMinWidth(150);
		passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

		TableColumn<User, String> birthColumn = new TableColumn<>("BIRTH");
		birthColumn.setMinWidth(150);
		birthColumn.setCellValueFactory(new PropertyValueFactory<>("birth"));

		TableColumn<User, String> telColumn = new TableColumn<>("TEL");
		telColumn.setMinWidth(150);
		telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));

		tableView = new TableView<User>();
		tableView.getColumns().addAll(idColumn, nameColumn, passwordColumn, birthColumn, telColumn);

		tableView.setRowFactory(e -> {

			TableRow<User> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				deletebtn.setDisable(false);
				user = row.getItem();
				deleteid = user.getId();

			});

			return row;
		});
		root.setCenter(tableView);
		root.setBottom(flowPane);

		return root;

	}
}
