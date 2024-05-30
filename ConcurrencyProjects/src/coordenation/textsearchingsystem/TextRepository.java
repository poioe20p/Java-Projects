package ConcurrencyProjects.src.coordenation.textsearchingsystem;

import java.util.ArrayList;
import java.util.List;

public class TextRepository {
	// TODO

	private List<TextChunk> textChunks = new ArrayList<>();
	private List<Integer> foundPostions = new ArrayList<>();
	private int numChunks;
	private int numOfReceivedResults;

	public TextRepository(String text, String stringToBeFound, int chunkSize) {
		// TODO
		for(int i = 0; i < text.length(); i+=chunkSize) {
			textChunks.add(new TextChunk(text.substring(i, Math.min(i + chunkSize, text.length())), i, stringToBeFound));
			numChunks++;
		}
	}

	public synchronized TextChunk getChunk()  {
		// TODO
		if(textChunks.isEmpty()) {
			return null;
		}
		return textChunks.remove(0);
	}

	public synchronized void submitResult(TextChunk chunk) {
		// TODO
		numOfReceivedResults++;
		if(!chunk.getFoundPos().isEmpty()) {
			for(int foundPositionAtChunk: chunk.getFoundPos()) {
				foundPostions.add((foundPositionAtChunk + chunk.getInitialPos()));
			}
		}
		notifyAll();
	}

	public synchronized List<Integer> getAllMatches() throws InterruptedException {
		// TODO
		while(numOfReceivedResults < numChunks) {
			wait();
		}
		return foundPostions;
	}


}
