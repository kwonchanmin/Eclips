package managerBookmainview;

import java.util.List;
import BookController.BookBorrowController;
import BookController.BookDeleteController;
import BookController.BookReturnBorrowController;
import BookController.BookSearchController;
import Use.vo.UserVO;
import book.vo.BookVO;
import bookadd.BookAdd;
import bookamend.BookAmend;
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
import managerusercontrol.UserControlManager;
import managervo.Manager;

public class ManagerBookMain {

	TableView<BookVO> tableView;
	TableView<UserVO> tableView1;
	TextField textField;
	Button deleteBtn;
	Button userbtn;
	Button bookaddbtn;
	Button bookamendbtn;
	String deleteISBN;
	String searchKeyword;
	String borrow;
	String userID;
	Manager manager;
	BookVO book;
	UserVO user;

	public ManagerBookMain(Manager manager) {
		this.manager = manager;

	}

	public BorderPane getLayout() {

		BorderPane root = new BorderPane();
		root.setPrefSize(1100, 500);

		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		;
		flowpane.setColumnHalignment(HPos.CENTER);
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(10);

		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {

			BookSearchController controller = new BookSearchController();
			List<BookVO> list = controller.getResult(textField.getText());

			ObservableList<BookVO> lists = FXCollections.observableArrayList();

			if (list != null) {
				for (BookVO book : list) {
					lists.add(book);
				}
			}

			tableView.setItems(lists);
			searchKeyword = textField.getText();
			textField.clear();
		});

		deleteBtn = new Button("Delete");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {

			BookDeleteController controller = new BookDeleteController();
			List<BookVO> list = controller.getResult(deleteISBN, searchKeyword);

			ObservableList<BookVO> lists = FXCollections.observableArrayList();
			if (list != null) {
				for (BookVO book : list) {
					lists.add(book);
				}
			}
			tableView.setItems(lists);
			if (list != null) {
				Dialog<String> dialog = new Dialog<String>();
				dialog.setTitle("도서정보 삭제");
				ButtonType type = new ButtonType("확인", ButtonData.OK_DONE);
				String st = "도서정보 삭제를 완료했습니다.";

				dialog.setContentText(st.toString());
				dialog.getDialogPane().getButtonTypes().add(type);
				dialog.getDialogPane().setMinWidth(100);
				dialog.showAndWait();
			}
		});

		userbtn = new Button("회원조회");
		userbtn.setPrefSize(150, 40);
		userbtn.setOnAction(e -> {

			Parent layout = new UserControlManager().getLayout();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		});

		bookaddbtn = new Button("도서 추가");
		bookaddbtn.setPrefSize(150, 40);
		bookaddbtn.setOnAction(e -> {

			Parent layout = new BookAdd().getLayout();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		});

		bookamendbtn = new Button("도서 수정");
		bookamendbtn.setPrefSize(150, 40);
		bookamendbtn.setOnAction(e -> {

			Parent layout = new BookAmend(book).getLayout();
			Scene scene = new Scene(layout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

		});

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(userbtn);
		flowpane.getChildren().add(bookaddbtn);
		flowpane.getChildren().add(bookamendbtn);

		// TableView의 안에 들어갈 정보들에 대해 작성
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<BookVO, String> dateColumn = new TableColumn<>("DATE");
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("bdate"));

		TableColumn<BookVO, Integer> pageColumn = new TableColumn<>("PAGE");
		pageColumn.setMinWidth(150);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("bpage"));

		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));

		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		TableColumn<BookVO, String> translatorColumn = new TableColumn<>("TRANSLATOR");
		translatorColumn.setMinWidth(150);
		translatorColumn.setCellValueFactory(new PropertyValueFactory<>("btranslator"));

		TableColumn<BookVO, String> supplementColumn = new TableColumn<>("SUPPLEMENT");
		supplementColumn.setMinWidth(150);
		supplementColumn.setCellValueFactory(new PropertyValueFactory<>("bsupplement"));

		TableColumn<BookVO, String> publisherColumn = new TableColumn<>("PUBLISHER");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));

		TableColumn<BookVO, Integer> borrowColumn = new TableColumn<>("BORROW");
		borrowColumn.setMinWidth(150);
		borrowColumn.setCellValueFactory(new PropertyValueFactory<>("bborrow"));

		tableView = new TableView<BookVO>();

		tableView.getColumns().addAll(isbnColumn, titleColumn, dateColumn, pageColumn, priceColumn, authorColumn,
				translatorColumn, supplementColumn, publisherColumn, borrowColumn);

		tableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow();
			row.setOnMouseClicked(e1 -> {
				book = row.getItem();
				if (e1.getClickCount() == 2) {
					if (book != null) {
						if (book.getBborrow() == 0) {
							Dialog<String> dialog = new Dialog<String>();
							dialog.setTitle("대여 확인");
							ButtonType type = new ButtonType("대여", ButtonData.OK_DONE);
							String st = "대여하시겠습니까?";

							dialog.setContentText(st.toString());
							dialog.getDialogPane().getButtonTypes().add(type);
							dialog.getDialogPane().setMinHeight(100);
							dialog.showAndWait();

							BookBorrowController controller = new BookBorrowController();
							int count = controller.getResult(row.getItem().getBisbn());
							System.out.println(count);
							if (count == 1) {
								tableView.setItems(FXCollections.observableArrayList());

							}
						} else {
							if (book.getBborrow() == 1) {
								Dialog<String> dialog = new Dialog<String>();
								dialog.setTitle("반납 확인");
								ButtonType type = new ButtonType("반납", ButtonData.OK_DONE);
								String st = "반납하시겠습니까?";

								dialog.setContentText(st.toString());
								dialog.getDialogPane().getButtonTypes().add(type);
								dialog.getDialogPane().setMinHeight(100);
								dialog.showAndWait();

								BookReturnBorrowController controller = new BookReturnBorrowController();
								int count = controller.getResult(row.getItem().getBisbn());
								System.out.println(count);
								if (count == 1) {
									tableView.setItems(FXCollections.observableArrayList());
								}
							}

						}
					}
				} else {
					deleteBtn.setDisable(false);
					book = row.getItem();
					deleteISBN = book.getBisbn();

				}

			});

			return row;
		});

		root.setCenter(tableView);
		root.setBottom(flowpane);

		return root;

	}
}
