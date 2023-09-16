import java.util.Scanner;

abstract class Ashim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ManagementSystem managementSystem = new ManagementSystem();

        do {
            System.out.println("==============================");
            System.out.println("Welcome to MIS");
            System.out.println("==============================");
            System.out.println("1. Add Information");
            System.out.println("2. Update Information");
            System.out.println("3. View Inventory");
            System.out.println("4. Delete Information");
            System.out.println("5. Transaction");
            System.out.println("6. Exit");
            System.out.println("==============================");
            System.out.print("Please enter your choice (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    managementSystem.addInformation();
                    break;
                case 2:
                    managementSystem.updateInformation();
                    break;
                case 3:
                    managementSystem.viewInventory();
                    break;
                case 4:
                    managementSystem.deleteInformation();
                    break;
                case 5:
                    managementSystem.transaction();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }

            clearConsole();
        } while (choice != 6);

        scanner.close();
    }

    private static void clearConsole() {

        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Console clearing failed: " + e.getMessage());
        }
    }
}

class ManagementSystem {
    private String information;


    public String getInformation() {
        return information;
    }


    public void setInformation(String information) {
        this.information = information;
    }

    void addInformation() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter new information: ");
            String newInformation = scanner.nextLine();
            setInformation(newInformation);
        }
        System.out.println("[LCID - 001 - Add Information] Information updated.");
    }

    void updateInformation() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter updated information: ");
            String updatedInformation = scanner.nextLine();
            setInformation(updatedInformation);
        }
        System.out.println("[LCID - 002 - Update Information] Information updated.");
    }

    void viewInventory() {
        System.out.println("[LCID - 003 - View Inventory] Information: " + getInformation());
    }

    void deleteInformation() {
        setInformation(null);
        System.out.println("[LCID - 004 - Delete Information] Information deleted.");
    }

    void transaction() {

        System.out.println("[LCID - 005 - Transaction]");
    }


    @Override
    public String toString() {
        return "ManagementSystem{" +
                "information='" + information + '\'' +
                '}';
    }
}
