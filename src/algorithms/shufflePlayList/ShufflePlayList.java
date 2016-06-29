package algorithms.shufflePlayList;

public class ShufflePlayList {

	/**
	 * O(n); n - Size of the playlist
	 * @param playList
	 * @return
	 */
	public static String[] shufflePlayList(String[] playList){
		if(playList==null || playList.length<2)	return playList;
				
		for(int i=0; i<playList.length; i++){
			int nextSong = (int) (i + Math.random()*(playList.length - i));
			
			// Swap song
			String tmp = playList[i];
			playList[i] = playList[nextSong];
			playList[nextSong] = tmp;
		}
		return playList;
	}
	
	public static void main(String[] args) {
		String[] playList = {"Song1", "Song2", "Song3", "Song4", "Song5"};
		playList = shufflePlayList(playList);
		for(String song : playList)
			System.out.print(song + ", ");
		System.out.println();
	}

}
