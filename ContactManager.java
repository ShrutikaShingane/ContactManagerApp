package contactmanager;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private final List<Contact> contacts = new ArrayList<>();
    private final Path file = Paths.get("contacts.csv");

    public ContactManager() {
        loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public void updateContact(int number, Contact updated) {
        if (!isValid(number)) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.set(number - 1, updated);
        saveContacts();
        System.out.println("Contact updated successfully!");
    }

    public void deleteContact(int number) {
        if (!isValid(number)) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(number - 1);
        saveContacts();
        System.out.println("Contact deleted successfully!");
    }

    private boolean isValid(int number) {
        return number >= 1 && number <= contacts.size();
    }

    private void saveContacts() {
        try (BufferedWriter writer = Files.newBufferedWriter(
                file, StandardCharsets.UTF_8)) {

            for (Contact c : contacts) {
                writer.write(csv(c.getName()) + ","
                        + csv(c.getPhone()) + ","
                        + csv(c.getEmail()));
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving contacts: "
                    + e.getMessage());
        }
    }

    private String csv(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }

    private void loadContacts() {
        if (!Files.exists(file)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(
                file, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                List<String> fields = parseCsv(line);

                if (fields.size() == 3) {
                    contacts.add(new Contact(
                            fields.get(0),
                            fields.get(1),
                            fields.get(2)));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading contacts: "
                    + e.getMessage());
        }
    }

    private List<String> parseCsv(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean quoted = false;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '"') {
                if (quoted && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {
                    value.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (ch == ',' && !quoted) {
                fields.add(value.toString());
                value.setLength(0);
            } else {
                value.append(ch);
            }
        }

        fields.add(value.toString());
        return fields;
    }
}