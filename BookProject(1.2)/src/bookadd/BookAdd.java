package bookadd;

import BookController.BookAddController;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class BookAdd {

	private Text isbn;
	private Text title;
	private Text date;
	private Text page;
	private Text price;
	private Text author;
	private Text translator;
	private Text supplement;
	private Text publisher;
	TextField isbntext;
	TextField titletext;
	TextField datetext;
	TextField pagetext;
	TextField pricetext;
	TextField authortext;
	TextField translatortext;
	TextField supplementtext;
	TextField publishertext;
	String addbook;
	String bisbn;
	String btitle;
	String bdate;
	int bpage;
	int bprice;
	String bauthor;
	String btranslator;
	String bsupplement;
	String bpublisher;

	Button addbtn;
	
	public BorderPane getLayout() {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 550);
		
		isbn =new Text("책 번호");
		isbn.setWrappingWidth(50);
		isbntext = new TextField();
		isbntext.setPrefSize(200, 50);
		
		title =new Text("책 이름");
		title.setWrappingWidth(50);
		titletext = new TextField();
		titletext.setPrefSize(200, 50);
		
		date =new Text("출판일");
		date.setWrappingWidth(50);
		datetext = new TextField();
		datetext.setPrefSize(200, 50);
		
		page =new Text("페이지 수");
		page.setWrappingWidth(50);
		pagetext = new TextField();
		pagetext.setPrefSize(200, 50);
		
		price =new Text("책 가격");
		price.setWrappingWidth(50);
		pricetext = new TextField();
		pricetext.setPrefSize(200, 50);
		
		author =new Text("작가");
		author.setWrappingWidth(50);
		authortext = new TextField();
		authortext.setPrefSize(200, 50);
		
		translator =new Text("번역자");
		translator.setWrappingWidth(50);
		translatortext = new TextField();
		translatortext.setPrefSize(200, 50);
		
		supplement =new Text("부록");
		supplement.setWrappingWidth(50);
		supplementtext = new TextField();
		supplementtext.setPrefSize(200, 50);
		
		publisher =new Text("출판사");
		publisher.setWrappingWidth(50);
		publishertext = new TextField();
		publishertext.setPrefSize(200, 50);
		
		FlowPane isbnflowPane = new FlowPane();
		isbnflowPane.setPrefSize(200, 50);
		isbnflowPane.setPadding(new Insets(10,10,10,10));
		isbnflowPane.setColumnHalignment(HPos.CENTER);
		isbnflowPane.setHgap(10);
		isbnflowPane.getChildren().add(isbn);
		isbnflowPane.getChildren().add(isbntext);		
		
		FlowPane titleflowPane = new FlowPane();
		titleflowPane.setPrefSize(200, 50);
		titleflowPane.setPadding(new Insets(10,10,10,10));
		titleflowPane.setColumnHalignment(HPos.CENTER);
		titleflowPane.setHgap(10);
		titleflowPane.getChildren().add(title);
		titleflowPane.getChildren().add(titletext);
		
		FlowPane dateflowPane = new FlowPane();
		dateflowPane.setPrefSize(200, 50);
		dateflowPane.setPadding(new Insets(10,10,10,10));
		dateflowPane.setColumnHalignment(HPos.CENTER);
		dateflowPane.setHgap(10);
		dateflowPane.getChildren().add(date);
		dateflowPane.getChildren().add(datetext);
		
		FlowPane pageflowPane = new FlowPane();
		pageflowPane.setPrefSize(200, 50);
		pageflowPane.setPadding(new Insets(10,10,10,10));
		pageflowPane.setColumnHalignment(HPos.CENTER);
		pageflowPane.setHgap(10);
		pageflowPane.getChildren().add(page);
		pageflowPane.getChildren().add(pagetext);
		
		FlowPane priceflowPane = new FlowPane();
		priceflowPane.setPrefSize(200, 50);
		priceflowPane.setPadding(new Insets(10,10,10,10));
		priceflowPane.setColumnHalignment(HPos.CENTER);
		priceflowPane.setHgap(10);
		priceflowPane.getChildren().add(price);
		priceflowPane.getChildren().add(pricetext);
		
		FlowPane authorflowPane = new FlowPane();
		authorflowPane.setPrefSize(200, 50);
		authorflowPane.setPadding(new Insets(10,10,10,10));
		authorflowPane.setColumnHalignment(HPos.CENTER);
		authorflowPane.setHgap(10);
		authorflowPane.getChildren().add(author);
		authorflowPane.getChildren().add(authortext);
		
		FlowPane translatorflowPane = new FlowPane();
		translatorflowPane.setPrefSize(200, 50);
		translatorflowPane.setPadding(new Insets(10,10,10,10));
		translatorflowPane.setColumnHalignment(HPos.CENTER);
		translatorflowPane.setHgap(10);
		translatorflowPane.getChildren().add(translator);
		translatorflowPane.getChildren().add(translatortext);
		
		FlowPane supplementflowPane = new FlowPane();
		supplementflowPane.setPrefSize(200, 50);
		supplementflowPane.setPadding(new Insets(10,10,10,10));
		supplementflowPane.setColumnHalignment(HPos.CENTER);
		supplementflowPane.setHgap(10);
		supplementflowPane.getChildren().add(supplement);
		supplementflowPane.getChildren().add(supplementtext);
		
		FlowPane publisherflowPane = new FlowPane();
		publisherflowPane.setPrefSize(200, 50);
		publisherflowPane.setPadding(new Insets(10,10,10,10));
		publisherflowPane.setColumnHalignment(HPos.CENTER);
		publisherflowPane.setHgap(10);
		publisherflowPane.getChildren().add(publisher);
		publisherflowPane.getChildren().add(publishertext);
		
		FlowPane mainflowPane = new FlowPane();
		mainflowPane.setPrefSize(300, 300);
		mainflowPane.setPadding(new Insets(10,10,10,10));
		mainflowPane.setColumnHalignment(HPos.CENTER);
		mainflowPane.setHgap(10);
		mainflowPane.getChildren().add(isbnflowPane);
		mainflowPane.getChildren().add(titleflowPane);
		mainflowPane.getChildren().add(dateflowPane);
		mainflowPane.getChildren().add(pageflowPane);
		mainflowPane.getChildren().add(priceflowPane);
		mainflowPane.getChildren().add(authorflowPane);
		mainflowPane.getChildren().add(translatorflowPane);
		mainflowPane.getChildren().add(supplementflowPane);
		mainflowPane.getChildren().add(publisherflowPane);

		addbtn = new Button("도서 추가");
		addbtn.setPrefSize(150, 50);
		addbtn.setOnAction(e->{
			
		 BookAddController controller = new BookAddController();
		 bisbn = isbntext.getText();
		 btitle = titletext.getText();
		 bdate = datetext.getText();
		 bpage = Integer.valueOf(pagetext.getText());
		 bprice= Integer.valueOf(pricetext.getText());
		 bauthor = authortext.getText();
		 btranslator = translatortext.getText();
		 bsupplement = supplementtext.getText();
		 bpublisher = publishertext.getText();
		 int count = controller.getResult(bisbn,btitle,bdate,bpage,bprice,bauthor,btranslator,bsupplement,bpublisher);
		 
		
		});
		
		FlowPane bottomflowPane = new FlowPane();
		bottomflowPane.setPrefSize(300, 300);
		bottomflowPane.setPadding(new Insets(10,10,10,10));
		bottomflowPane.setColumnHalignment(HPos.CENTER);
		bottomflowPane.setHgap(10);
		bottomflowPane.getChildren().add(addbtn);
		
		root.setCenter(mainflowPane);
		root.setBottom(bottomflowPane);
		
		return root;
		
	}

	
}
