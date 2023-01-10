package BookVO;

public class Book {
	
	private String bisbn;
	private String btitle;
	private String bdate;
	private int bpage;
	private int bprice;
	private String bauthor;
	private String btranslator;
	private String bsupplement;
	private String bpublisher;
	private int bborrow;
	
	public Book(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor, String btranslator,
			String bsupplement, String bpublisher, int bborrow) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
		this.btranslator = btranslator;
		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
		this.bborrow = bborrow;
		}
	
	
	public Book(int bborrow) {
		super();
		this.bborrow = bborrow;
	}


	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public int getBborrow() {
		return bborrow;
	}

	public void setBborrow(int bborrow) {
		this.bborrow = bborrow;
	}


	@Override
	public String toString() {
		return "Book [bisbn=" + bisbn + ", btitle=" + btitle + ", bdate=" + bdate + ", bpage=" + bpage + ", bprice="
				+ bprice + ", bauthor=" + bauthor + ", btranslator=" + btranslator + ", bsupplement=" + bsupplement
				+ ", bpublisher=" + bpublisher + ", bborrow=" + bborrow + "]";
	}
	
	
}
