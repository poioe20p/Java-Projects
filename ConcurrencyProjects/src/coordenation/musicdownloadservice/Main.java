package ConcurrencyProjects.src.coordenation.musicdownloadservice;

public class Main {
	private static final int NUM_REPOSITORIOS = 4; // numero de repositorios no servidor

	public static void main(String[] args) throws InterruptedException {
		Servidor servidor = new Servidor(NUM_REPOSITORIOS);

		Client client1 = new Client(0, servidor, 4);
		client1.start();
						
		servidor.stopServer();
	}

}
