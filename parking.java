import java.util.ArrayList;
import java.util.Scanner;

class parking{
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }
}

public class ParkingManagementSystem {

    static final int TOTAL_SLOTS = 10;
    static ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

    public static void parkVehicle(Scanner sc) {
        if (parkedVehicles.size() >= TOTAL_SLOTS) {
            System.out.println("Parking Full!");
            return;
        }

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        parkedVehicles.add(new Vehicle(number, owner));

        System.out.println("Vehicle Parked Successfully.");
    }

    public static void removeVehicle(Scanner sc) {
        System.out.print("Enter Vehicle Number to Remove: ");
        String number = sc.nextLine();

        for (Vehicle v : parkedVehicles) {
            if (v.vehicleNumber.equalsIgnoreCase(number)) {
                parkedVehicles.remove(v);
                System.out.println("Vehicle Removed Successfully.");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    public static void showAvailableSlots() {
        int available = TOTAL_SLOTS - parkedVehicles.size();
        System.out.println("Available Slots: " + available);
    }

    public static void viewParkedVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No Vehicles Parked.");
            return;
        }

        System.out.println("\n--- Parked Vehicles ---");

        for (Vehicle v : parkedVehicles) {
            System.out.println("Vehicle No: " + v.vehicleNumber);
            System.out.println("Owner: " + v.ownerName);
            System.out.println("----------------------");
        }
    }

    public static void searchVehicle(Scanner sc) {
        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        for (Vehicle v : parkedVehicles) {
            if (v.vehicleNumber.equalsIgnoreCase(number)) {
                System.out.println("Vehicle Found");
                System.out.println("Owner Name: " + v.ownerName);
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SMART PARKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Search Vehicle");
            System.out.println("5. Available Slots");
            System.out.println("6. Exit");

            System.out.print("Choose Option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    parkVehicle(sc);
                    break;

                case 2:
                    removeVehicle(sc);
                    break;

                case 3:
                    viewParkedVehicles();
                    break;

                case 4:
                    searchVehicle(sc);
                    break;

                case 5:
                    showAvailableSlots();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
