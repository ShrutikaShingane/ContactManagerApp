package contactmanager;

import java.util.Scanner;

public class ContactManagerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n===== CONTACT MANAGER =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {

                    case "1":
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        manager.addContact(
                                new Contact(name, phone, email));
                        break;

                    case "2":
                        manager.viewContacts();
                        break;

                    case "3":
                        manager.viewContacts();

                        System.out.print(
                                "Enter contact number to update: ");
                        int updateNumber =
                                Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new phone: ");
                        String newPhone = sc.nextLine();

                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();

                        manager.updateContact(updateNumber,
                                new Contact(newName, newPhone, newEmail));
                        break;

                    case "4":
                        manager.viewContacts();

                        System.out.print(
                                "Enter contact number to delete: ");
                        int deleteNumber =
                                Integer.parseInt(sc.nextLine().trim());

                        manager.deleteContact(deleteNumber);
                        break;

                    case "5":
                        System.out.println(
                                "Contacts saved. Goodbye!");
                        sc.close();
                        return;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid contact number.");
            }
        }
    }
}
