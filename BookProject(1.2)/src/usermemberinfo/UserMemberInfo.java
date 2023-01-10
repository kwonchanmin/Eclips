package usermemberinfo;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import managercontroller.ManagerUserUpdateController;
import userVO.User;
import usersearchcontroller.UserInfoDeleteController;
//import usersearchcontroller.UserInfoSearchController;
import usersearchcontroller.UserUpdateInfoController;

public class UserMemberInfo {

	Button amendbtn;
	Button deletebtn;
	Button userinfobtn;
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
	User user;
	String deleteUSER;
	
	
	public UserMemberInfo(User user) {
		super();
		this.user = user;
	}
	
	
	
	public BorderPane getLayout() {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 520);
		
		ID = new Text("ID");
		ID.setWrappingWidth(70);
		idtext = new TextField(user.getId());
		idtext.setDisable(true);
		idtext.setPrefSize(200, 50);
		
		NAME = new Text("NAME");
		NAME.setWrappingWidth(70);
		nametext = new TextField(user.getName());
		nametext.setPrefSize(200, 50);
		
		PASSWORD= new Text("PASSWORD");
		PASSWORD.setWrappingWidth(70);
		passwordtext = new TextField(user.getPassword());
		passwordtext.setPrefSize(200, 50);
		
		BIRTH = new Text("BIRTH");
		BIRTH.setWrappingWidth(70);
		birthtext = new TextField(user.getBirth());
		birthtext.setPrefSize(200, 50);
		
		TEL = new Text("TEL");
		TEL.setWrappingWidth(70);
		teltext = new TextField(user.getTel());
		teltext.setPrefSize(200, 50);
		
		FlowPane idflowPane = new FlowPane();
		idflowPane.setPrefSize(300, 50);
		idflowPane.setHgap(10);
		idflowPane.setPadding(new Insets(10,10,10,10));
		idflowPane.setColumnHalignment(HPos.CENTER);
		idflowPane.getChildren().add(ID);
		idflowPane.getChildren().add(idtext);
		
		FlowPane nameflowPane = new FlowPane();
		nameflowPane.setPrefSize(300, 50);
		nameflowPane.setHgap(10);
		nameflowPane.setPadding(new Insets(10,10,10,10));
		nameflowPane.setColumnHalignment(HPos.CENTER);
		nameflowPane.getChildren().add(NAME);
		nameflowPane.getChildren().add(nametext);
		
		FlowPane passwordflowPane = new FlowPane();
		passwordflowPane.setPrefSize(300, 50);
		passwordflowPane.setHgap(10);
		passwordflowPane.setPadding(new Insets(10,10,10,10));
		passwordflowPane.setColumnHalignment(HPos.CENTER);
		passwordflowPane.getChildren().add(PASSWORD);
		passwordflowPane.getChildren().add(passwordtext);
		
		FlowPane birthflowPane = new FlowPane();
		birthflowPane.setPrefSize(300, 50);
		birthflowPane.setHgap(10);
		birthflowPane.setPadding(new Insets(10,10,10,10));
		birthflowPane.setColumnHalignment(HPos.CENTER);
		birthflowPane.getChildren().add(BIRTH);
		birthflowPane.getChildren().add(birthtext);
		
		FlowPane telflowPane = new FlowPane();
		telflowPane.setPrefSize(300, 50);
		telflowPane.setHgap(10);
		telflowPane.setPadding(new Insets(10,10,10,10));
		telflowPane.setColumnHalignment(HPos.CENTER);
		telflowPane.getChildren().add(TEL);
		telflowPane.getChildren().add(teltext);
		
		FlowPane topflowPane = new FlowPane();
		topflowPane.setPrefSize(300, 300);
		topflowPane.setHgap(10);
		topflowPane.setPadding(new Insets(10,10,10,10));
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
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);
		
		
		amendbtn = new Button("회원정보수정");
		amendbtn.setPrefSize(150, 50);
		amendbtn.setPadding(new Insets(10,10,10,10));
		amendbtn.setOnAction(e->{
			ManagerUserUpdateController controller = new ManagerUserUpdateController();
			id = idtext.getText();
			name = nametext.getText();
			password = passwordtext.getText();
			birth = birthtext.getText();
			tel = teltext.getText();
			int list = controller.getResult(name,password,birth,tel,id);
			if(list == 1) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("회원정보 수정완료");
				ButtonType type = new ButtonType("확인",ButtonData.OK_DONE);
				String st = "회원정보 수정을 완료했습니다.";
				
				dialog.setContentText(st.toString());
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinWidth(100);
				dialog.showAndWait();
				
//				Node node = (Node) e.getSource();
//				Stage thisStage = (Stage) node.getScene().getWindow();
//				thisStage.close();
			}
		});
			
		deletebtn = new Button("회원탈퇴");
		deletebtn.setPrefSize(150, 50);
		deletebtn.setPadding(new Insets(10,10,10,10));
		deletebtn.setOnAction(e->{
			id=idtext.getText();
			
			UserInfoDeleteController controller = new UserInfoDeleteController();
			int list = controller.getResult(id);
			
		});

		
		root.setCenter(topflowPane);
		flowPane.getChildren().add(amendbtn);
		flowPane.getChildren().add(deletebtn);
		root.setBottom(flowPane);
		
		return root;                                         
		
	}
}
