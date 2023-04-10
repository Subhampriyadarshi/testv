package codingAssisgment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class RecentlyPlayedStrorTest {
	private RecentlyPlayedStore store;
	private User user1;
	private User user2;
	private Song song1;
	private Song song2;
	private Song song3;
	private Song song4;
	
	@Before
	public void setUp() {
		store = new RecentlyPlayedStore(3);
		user1 = new User("User 1");
		user2 = new User("User 2");
		song1 = new Song("Song 1");
		song2 = new Song("Song 2");
		song3 = new Song("Song 3");
		song4 = new Song("Song 4");
	}
	
	@Test
	public void testAddSong() {
		store.addsong(user1, song1);
		store.addsong(user1, song2);
		store.addsong(user1, song3);
		store.addsong(user1, song4);
		store.addsong(user2, song1);
		store.addsong(user2, song2);
		assertEquals(Arrays .asList(song2, song3, song4), store.getRecentPlayed(user1));
		assertEquals(Arrays.asList(song1, song2), store.getRecentPlayed(user2));
		
		
	}

}
