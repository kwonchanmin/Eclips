package managerBookmainview;

import BookController.BookBorrowController;
import BookController.BookDeleteController;
import BookController.BookReturnBorrowController;
import BookController.BookSearchController;
import BookVO.Book;
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
import managetvo.Manager;
import userVO.User;

public class ManagerBookMain {

	TableView<Book> tableView;
	TableView<User> tableView1;
	TextField textField;
	Button deleteBtn;
	Button userbtn;
	Button bookaddbtn;
	Button bookamendbtn;
	Button logbtn;
	String deleteISBN;
	String searchKeyword;
	String borrow;
	String userID;
	Manager manager;
	Book book;
	User user;

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

			ObservableList<Book> list = controller.getResult(textField.getText());
			tableView.setItems(list);
			searchKeyword = textField.getText();
			textField.clear();
		});

		deleteBtn = new Button("Delete");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {

			BookDeleteController controller = new BookDeleteController();
			ObservableList<Book> list = controller.getResult(deleteISBN, searchKeyword);

			tableView.setItems(list);
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

		logbtn = new Button("로그 조회");
		logbtn.setPrefSize(150, 40);
		logbtn.setOnAction(e -> {

		});

		flowpane.getChildren().add(textField);
		flowpane.getChildren().add(deleteBtn);
		flowpane.getChildren().add(userbtn);
		flowpane.getChildren().add(bookaddbtn);
		flowpane.getChildren().add(bookamendbtn);
		flowpane.getChildren().add(logbtn);

		TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));

		TableColumn<Book, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));

		TableColumn<Book, String> dateColumn = new TableColumn<>("DATE");
		dateColumn.setMinWidth(150);
		dateColumn.setCellValueFactory(new PropertyValueFactory<>("bdate"));

		TableColumn<Book, Integer> pageColumn = new TableColumn<>("PAGE");
		pageColumn.setMinWidth(150);
		pageColumn.setCellValueFactory(new PropertyValueFactory<>("bpage"));

		TableColumn<Book, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));

		TableColumn<Book, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));

		TableColumn<Book, String> translatorColumn = new TableColumn<>("TRANSLATOR");
		translatorColumn.setMinWidth(150);
		translatorColumn.setCellValueFactory(new PropertyValueFactory<>("btranslator"));

		TableColumn<Book, String> supplementColumn = new TableColumn<>("SUPPLEMENT");
		supplementColumn.setMinWidth(150);
		supplementColumn.setCellValueFactory(new PropertyValueFactory<>("bsupplement"));

		TableColumn<Book, String> publisherColumn = new TableColumn<>("PUBLISHER");
		publisherColumn.setMinWidth(150);
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("bpublisher"));

		TableColumn<Book, Integer> borrowColumn = new TableColumn<>("BORROW");
		borrowColumn.setMinWidth(150);
		borrowColumn.setCellValueFactory(new PropertyValueFactory<>("bborrow"));

		tableView = new TableView<Book>();

		tableView.getColumns().addAll(isbnColumn, titleColumn, dateColumn, pageColumn, priceColumn, authorColumn,
				translatorColumn, supplementColumn, publisherColumn, borrowColumn);

		tableView.setRowFactory(e -> {

			TableRow<Book> row = new TableRow();
			row.setOnMouseClicked(e1 -> {
				book = row.getItem();
				if (e1.getClickCount() == 2) {

//					BookBorrowSearchController controller = new BookBorrowSearchController();
//					ObservableList<Book> list = controller.getResult(borrow);

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
							boolean result = controller.getResult(row.getItem().getBisbn());
							if (result) {
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
								boolean result = controller.getResult(row.getItem().getBisbn());
								if (result) {
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
