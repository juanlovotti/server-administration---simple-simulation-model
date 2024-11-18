import java.util.ArrayList;

public class serverAdministration {
    private ArrayList<Server> servers;

    public serverAdministration() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
        System.out.println(server.getName() + " added successfully ");
    }

    //list servers
    public void listServers() {
        if (servers.isEmpty()) {
            System.out.println("No servers");
        } else {
            System.out.println("Server registered: ");
            for (int i = 0; i < servers.size(); i++) {
                Server s = servers.get(i);
                System.out.println((i + 1) + ". " + s.getName() + " (" + s.getIpDirection() + ") - State: " + s.getState());
            }
        }
    }

    public Server byName(String name) {
        for (Server s : servers) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
