package vo;

public class Board {
	private int boardnum;
	private String id;
	private String title;
	private String content;
	private String inputdate;
	private int hits;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardnum, String title, String content) {
		this.boardnum = boardnum;
		this.title = title;
		this.content = content;
	}

	public Board(String id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getNumber() {
		return boardnum;
	}

	public void setNumber(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", id=" + id + ", title=" + title + ", content=" + content + ", inputdate="
				+ inputdate + ", hits=" + hits + "]";
	}

}
