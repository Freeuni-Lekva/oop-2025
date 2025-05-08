public class Main {

    public static void main(String[] args) {
        Server server = new Server(8080);
        Client client = new Client("localhost", 8080);

        server.start();
        client.start();
    }
}
