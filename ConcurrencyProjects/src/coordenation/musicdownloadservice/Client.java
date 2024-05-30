package ConcurrencyProjects.src.coordenation.musicdownloadservice;

public class Client extends Thread {
	private int clientId;
	private Servidor server;
	private int numSongRequests;

	public Client(int clienteId, Servidor servidor, int numSongRequests) {
		super("Cliente-" + clienteId);
		this.clientId = clienteId;
		this.server = servidor;
		this.numSongRequests = numSongRequests;
	}

	public void run() {
		// TODO
		while(true) {
			try {
				server.downloadSongs(SongRequest.getRandomListOfSongsRequests(numSongRequests));
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			break;
		}
	}
}
