package userlogin;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import usercontroller.UserSignUpController;

public class UserSignUp {

	Button signupbtn;
	private Text ID;
	private Text NAME;
	private Text PASSWORD;
	private Text BIRTH;
	private Text TEL;
	TextField idtext;
	TextField nametext;
	TextField passwordtext;
	TextField birthtext;
	TextField teltext;
	String id;
	String name;
	String password;
	String birth;
	String tel;

	public BorderPane getLayout() {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 500);

		ID = new Text("ID");
		ID.setWrappingWidth(70);
		idtext = new TextField();
		idtext.setPrefSize(200, 50);

		NAME = new Text("NAME");
		NAME.setWrappingWidth(70);
		nametext = new TextField();
		nametext.setPrefSize(200, 50);

		PASSWORD = new Text("PASSWORD");
		PASSWORD.setWrappingWidth(70);
		passwordtext = new TextField();
		passwordtext.setPrefSize(200, 50);

		BIRTH = new Text("BIRTH");
		BIRTH.setWrappingWidth(70);
		birthtext = new TextField();
		birthtext.setPrefSize(200, 50);

		TEL = new Text("TEL");
		TEL.setWrappingWidth(70);
		teltext = new TextField();
		teltext.setPrefSize(200, 50);

		FlowPane idflowPane = new FlowPane();
		idflowPane.setPrefSize(300, 50);
		idflowPane.setHgap(10);
		idflowPane.setPadding(new Insets(10, 10, 10, 10));
		idflowPane.setColumnHalignment(HPos.CENTER);
		idflowPane.getChildren().add(ID);
		idflowPane.getChildren().add(idtext);

		FlowPane nameflowPane = new FlowPane();
		nameflowPane.setPrefSize(300, 50);
		nameflowPane.setHgap(10);
		nameflowPane.setPadding(new Insets(10, 10, 10, 10));
		nameflowPane.setColumnHalignment(HPos.CENTER);
		nameflowPane.getChildren().add(NAME);
		nameflowPane.getChildren().add(nametext);

		FlowPane passwordflowPane = new FlowPane();
		passwordflowPane.setPrefSize(300, 50);
		passwordflowPane.setHgap(10);
		passwordflowPane.setPadding(new Insets(10, 10, 10, 10));
		passwordflowPane.setColumnHalignment(HPos.CENTER);
		passwordflowPane.getChildren().add(PASSWORD);
		passwordflowPane.getChildren().add(passwordtext);

		FlowPane birthflowPane = new FlowPane();
		birthflowPane.setPrefSize(300, 50);
		birthflowPane.setHgap(10);
		birthflowPane.setPadding(new Insets(10, 10, 10, 10));
		birthflowPane.setColumnHalignment(HPos.CENTER);
		birthflowPane.getChildren().add(BIRTH);
		birthflowPane.getChildren().add(birthtext);

		FlowPane telflowPane = new FlowPane();
		telflowPane.setPrefSize(300, 50);
		telflowPane.setHgap(10);
		telflowPane.setPadding(new Insets(10, 10, 10, 10));
		telflowPane.setColumnHalignment(HPos.CENTER);
		telflowPane.getChildren().add(TEL);
		telflowPane.getChildren().add(teltext);

		FlowPane topflowPane = new FlowPane();
		topflowPane.setPrefSize(300, 300);
		topflowPane.setHgap(10);
		topflowPane.setPadding(new Insets(10, 10, 10, 10));
		topflowPane.setColumnHalignment(HPos.CENTER);
		topflowPane.setOrientation(Orientation.VERTICAL);
		topflowPane.getChildren().add(idflowPane);
		topflowPane.getChildren().add(nameflowPane);
		topflowPane.getChildren().add(passwordflowPane);
		topflowPane.getChildren().add(birthflowPane);
		topflowPane.getChildren().add(telflowPane);

		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(300, 150);
		flowPane.setHgap(10);
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);

		signupbtn = new Button("회원가입");
		signupbtn.setPrefSize(150, 50);
		signupbtn.setPadding(new Insets(10, 10, 10, 10));
		signupbtn.setOnAction(e -> {
			UserSignUpController controller = new UserSignUpController();
			id = idtext.getText();
			name = nametext.getText();
			password = passwordtext.getText();
			birth = birthtext.getText();
			tel = teltext.getText();
			int list = controller.getResult(id, name, password, birth, tel);
			Dialog<String> dialog = new Dialog<String>();
			dialog.setTitle("회원가입이 완료되었습니다.");
			ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
			String st = "회원가입을 완료하였습니다.";

			dialog.setContentText(st.toString());
			dialog.getDialogPane().getButtonTypes().add(type);
			dialog.getDialogPane().setMinHeight(100);
			dialog.showAndWait();

		});

		root.setCenter(topflowPane);
		root.setBottom(signupbtn);

		return root;

	}
}
