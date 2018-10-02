package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Record> recordList = new ArrayList<>();


    public static void main(String[] args) {
        int i;
        for (i = 1; i < 11; i++) {
            Person p = new Person();
            p.setName("Maks" + i);
            p.setSurname("Surname" + i);
            p.setPhone("121211" + i);
            p.setEmail("mail" + i + "@gmail.com");

            recordList.add(p);
        }
        for (i = 1; i < 3; i++) {
            Note n = new Note();
            n.setSubject("Maks" + i);
            n.setText("Text dfdfdsfsdfdsdsfddsfsdfdsf" + i);
            recordList.add(n);
        }
        while (true) {
            System.out.println();
            System.out.println("Commands:");
            System.out.println("11: New Contact");
            System.out.println("21: New Note");
            System.out.println("2: Show List, 3: Remove, 4: Find");
            System.out.println("'help' for help), 0: Exit");
            String cmd = scanner.next();
            switch (cmd) {
                case "11":
                    createContact();
                    break;
                case "21":
                    createNote();
                    break;
                case "2":
                    printListContact();
                    break;
                case "3":
                    removeById();
                    break;
                case "4":
                    find();
                    break;
                case "help":
                    showHelp();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("It isn't a command");
            }
        }
    }

    private static void find() {
        System.out.println("Find What?:");
        String str = askString();
        for (Record r : recordList) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }


    private static void createNote() {
        System.out.println("Enter Subject:");
        String subject = askString();

        System.out.println("Enter Notes:");
        String text = askString();

        Note n = new Note();
        n.setSubject(subject);
        n.setText(text);

        recordList.add(n);

        System.out.println(n);
    }

    private static void showHelp() {
        System.out.println("create - bla bla bla bla");
        System.out.println("remove - bla bla bla bla");
        System.out.println("bla bla bla bla");
        System.out.println("bla bla bla bla");
    }

    private static void removeById() {
        System.out.println("Enter ID to remove:");
        int id = scanner.nextInt();
        for (int i = 0; i < recordList.size(); i++) {
            Record p = recordList.get(i);
            if (id == p.getId()) {
                recordList.remove(i);
                break;
            }
        }
    }

    private static void printListContact() {
        for (Record p : recordList) {
            System.out.println(p);
        }
    }

    private static void createContact() {
        System.out.println("Enter name:");
        String name = askString();

        System.out.println("Enter surname:");
        String surname = askString();

        System.out.println("Enter phone:");
        String phone = askString();

        System.out.println("Enter email:");
        String email = askString();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);
        p.setEmail(email);

        recordList.add(p);

        System.out.println(p);
    }

    private static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {

            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    String str = String.join("_", result);
                    return str.substring(1, str.length() - 1);
                }
                word = scanner.next();
            } while (true);

        } else {
            return word;
        }

    }
}
