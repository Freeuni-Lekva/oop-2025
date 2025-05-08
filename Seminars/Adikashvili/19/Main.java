public class Main {

    public static void main(String[] args) {
        Client client = new Client("localhost", 8080);
        Server server = new Server(8080);

        client.start();
        server.start();
    }
}
