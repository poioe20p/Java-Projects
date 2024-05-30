package ConcurrencyProjects.src.coordenation.musicdownloadservice;

import java.util.LinkedList;
import java.util.List;

public class Servidor {
	private List<Repository> repoList = new LinkedList<>();

	public Servidor(int numRepositorios) {

		// Criar e inicia os repositorios
		for (int i = 0; i != numRepositorios; i++) {
			Repository repo = new Repository(i, this);
			repoList.add(repo);
		}
		for (Repository repo : repoList) {
			repo.start();
		}

		// TODO
	}

	public synchronized List<SongRequest> downloadSongs(List<SongRequest> songs) throws InterruptedException {
		// TODO

		return null;
	}

	public synchronized SongRequest getSongRequest() throws InterruptedException {
		// TODO
		return null;

	}

	public synchronized void uploadSong(SongRequest song) {
		// TODO
	}

	public void stopServer() {
		for (Repository repo : repoList) {
			repo.interrupt();
		}
		// TODO
	}

}
