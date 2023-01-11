package managerusercontrol;

import java.util.List;

import Use.vo.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import manageramend.ManagerUserAmend;
import managercontroller.ManagerUserDeleteController;
import managercontroller.ManagerUserSearchController;

public class UserControlManager {

	TableView<UserVO> tableView;
	Button amendbtn;
	Button deletebtn;
	TextField usertext;
	UserVO user;
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
			List<UserVO> list = controller.getResult(deleteid, searchKeyword);
			ObservableList<UserVO> lists = FXCollections.observableArrayList();

			if (list != null) {
				for (UserVO user : list) {
					lists.add(user);
				}
			}
			tableView.setItems(lists);
			if (list != null) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("회원 삭제");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String st = "회원 삭제를 완료했습니다.";

				dialog.setContentText(st.toString());
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinWidth(100);
				dialog.showAndWait();
			}
		});

		usertext = new TextField();
		usertext.setPrefSize(200, 50);
		usertext.setOnAction(e -> {

			ManagerUserSearchController controller = new ManagerUserSearchController();
			List<UserVO> list = controller.getResult(usertext.getText());
			ObservableList<UserVO> lists = FXCollections.observableArrayList();

			if (list != null) {
				for (UserVO user : list) {
					lists.add(user);
				}
			}

			tableView.setItems(lists);
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

		TableColumn<UserVO, String> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(150);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<UserVO, String> nameColumn = new TableColumn<>("NAME");
		nameColumn.setMinWidth(150);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<UserVO, String> passwordColumn = new TableColumn<>("PASSWORD");
		passwordColumn.setMinWidth(150);
		passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

		TableColumn<UserVO, String> birthColumn = new TableColumn<>("BIRTH");
		birthColumn.setMinWidth(150);
		birthColumn.setCellValueFactory(new PropertyValueFactory<>("birth"));

		TableColumn<UserVO, String> telColumn = new TableColumn<>("TEL");
		telColumn.setMinWidth(150);
		telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));

		tableView = new TableView<UserVO>();
		tableView.getColumns().addAll(idColumn, nameColumn, passwordColumn, birthColumn, telColumn);

		tableView.setRowFactory(e -> {

			TableRow<UserVO> row = new TableRow<>();
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
