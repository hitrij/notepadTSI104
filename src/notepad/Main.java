package notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public final static String DATE_FORMAT = "dd/MM/yyyy";
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public final static String TIME_FORMAT = "HH/mm";
    public final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

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

        for (i = 1; i < 5; i++) {
            Reminder n = new Reminder();
            n.setText("sdadsdad" + i + i + i + "dsfsdfs");

            LocalDate dt = LocalDate.parse("0" + i + "/0" + i + "/201" + i, DATE_FORMATTER);
            n.setDate(dt);

            LocalTime tm = LocalTime.parse("0" +i+"/0" + i, TIME_FORMATTER);
            n.setTime(tm);

            recordList.add(n);
        }
        while (true) {
            System.out.println();
            System.out.println("Commands:");
            System.out.println("11: New Contact");
            System.out.println("12: New Note");
            System.out.println("13: New Reminder");
            System.out.println("2: Show List, 3: Remove, 4: Find");
            System.out.println("'help' for help), 0: Exit");
            String cmd = scanner.next();
            switch (cmd) {
                case "11":
                    createContact();
                    break;
                case "12":
                    createNote();
                    break;
                case "13":
                    createReminder();
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

    private static void createReminder() {
        var p = new Reminder();
        addRecord(p);
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
        Note p = new Note();
        addRecord(p);
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
        Person p = new Person();
        addRecord(p);
    }

    private static void addRecord(Record p) {
        p.askQuestions();
        recordList.add(p);
        System.out.println(p);
    }

    public static String askString() {
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

    public static LocalDate askDate() {
        String d = askString();
        LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
        return date;
    }
    public static LocalTime askTime() {
        String t = askString();
        LocalTime time = LocalTime.parse(t, TIME_FORMATTER);
        return time;
    }
}
