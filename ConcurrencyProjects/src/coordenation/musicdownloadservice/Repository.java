package ConcurrencyProjects.src.coordenation.musicdownloadservice;

import java.util.List;

public class Repository extends Thread {
	private Servidor server;
	private List<SongRequest> listOfTitles;

	public Repository(int id, Servidor servidor) {
		super("Repo-" + id);
		this.server = servidor;
		
		// TODO 
	}

	@Override
	public void run() {
		// TODO
	}


}
