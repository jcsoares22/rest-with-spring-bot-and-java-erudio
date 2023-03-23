package br.com.systec;

public class Greenting {
	
	private final long id;
	private final String content;
	
	
	public Greenting(long id, String content) {
		this.id = id;
		this.content = content;
	}


	public long getId() {
		return id;
	}


	public String getContent() {
		return content;
	}	
}
