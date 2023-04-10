package codingAssisgment;

public class Song {
	private String id;
	
	public Song(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id;
	}

}
