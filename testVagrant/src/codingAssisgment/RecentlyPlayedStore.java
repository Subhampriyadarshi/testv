package codingAssisgment;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {

    private int capacity;
    private Map<User, List<Song>> recentlyPlayed;
    
    public RecentlyPlayedStore(int capacity) {
    	this.capacity = capacity;
   	this.recentlyPlayed = new HashMap<>();
    }
       
    public void addsong(User user, Song song) {
    	if(!recentlyPlayed.containsKey(user)) {
    		recentlyPlayed.put(user, new LinkedList<>());
    	}
    	List<Song>songs = recentlyPlayed.get(user);
    	songs.add(song);
    	if(songs.size()>capacity) {
    		songs.remove(0);
    	}	
    }
    public List<Song>getRecentPlayed(User user){
    	return recentlyPlayed.getOrDefault(user, Collections.emptyList());
    }


	public static void main(String[] args) {
		RecentlyPlayedStore store = new RecentlyPlayedStore(3);
		User user1 = new User("user1");
		Song song1 = new Song("s1");
		Song song2 = new Song("s2");
		Song song3 = new Song("s3");
		Song song4 = new Song("s4");
		store.addsong(user1, song1);
		store.addsong(user1, song2);
		store.addsong(user1, song3);
		System.out.println(store.getRecentPlayed(user1));// expected output: [s1, s2, s3]
		
		store.addsong(user1, song4);
		System.out.println(store.getRecentPlayed(user1));// expected output: [s2, s3, s4]
		
		store.addsong(user1, song2);
		System.out.println(store.getRecentPlayed(user1));// expected output: [s3, s4, s2]
		
		store.addsong(user1, song1);
		System.out.println(store.getRecentPlayed(user1)); // expected output: [s4, s2, s1]
		

	}

}
