import java.util.*;

public class Main {
    public static void main(String[] args) {
        serverAdministration admin = new serverAdministration();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Añadir Servidor");
            System.out.println("2. Listar Servidores");
            System.out.println("3. Seleccionar un Servidor");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1: // Añadir un servidor
                    System.out.print("Introduce el nombre del servidor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce la dirección IP: ");
                    String ip = scanner.nextLine();
                    admin.addServer(new Server(nombre, ip));
                    break;

                case 2: // Listar servidores
                    admin.listServers();
                    break;

                case 3: // Seleccionar un servidor
                    admin.listServers();
                    System.out.print("Introduce el nombre del servidor que quieres gestionar: ");
                    String serverName = scanner.nextLine();

                    // Buscar el servidor por nombre
                    Server servidorSeleccionado = admin.byName(serverName);
                    if (servidorSeleccionado != null) {
                        int opt;
                        do {
                            System.out.println("\n=== Opciones de Servidor: " + servidorSeleccionado.getName() + " ===");
                            System.out.println("1. Encender");
                            System.out.println("2. Apagar");
                            System.out.println("3. Reiniciar");
                            System.out.println("4. Regresar al menú principal");
                            System.out.print("Selecciona una opción: ");
                            opt = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea

                            switch (opt) {
                                case 1:
                                    servidorSeleccionado.turnOn();
                                    break;
                                case 2:
                                    servidorSeleccionado.turnOff();
                                    break;
                                case 3:
                                    servidorSeleccionado.restart();
                                    break;
                                case 4:
                                    System.out.println("Regresando al menú principal...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intenta de nuevo.");
                            }
                        } while (opt != 4);
                    } else {
                        System.out.println("No se encontró un servidor con ese nombre.");
                    }
                    break;

                case 4: // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
