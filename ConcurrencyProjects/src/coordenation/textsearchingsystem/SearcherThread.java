package ConcurrencyProjects.src.coordenation.textsearchingsystem;


class SearcherThread extends Thread {
	private TextRepository textRepository;

	public SearcherThread(TextRepository textRepository) {
		this.textRepository = textRepository;
	}

	@Override
	public void run() {
		// TODO
		TextChunk chunk = textRepository.getChunk();
		while (chunk != null) {
			int pos = chunk.text.indexOf(chunk.stringToBeFound);
			while (pos != -1) {
				System.out.println("Found a text match at position: " + (pos + chunk.getInitialPos()) );
				chunk.addFoundPos(pos);
				pos = chunk.text.indexOf(chunk.stringToBeFound, pos + 1);
			}
			textRepository.submitResult(chunk);
			chunk = textRepository.getChunk();
		}
	}
}
