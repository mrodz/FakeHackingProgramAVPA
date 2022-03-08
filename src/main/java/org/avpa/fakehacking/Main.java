package org.avpa.fakehacking;

import org.avpa.fakehacking.colorprinter.ColorChain;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.avpa.fakehacking.Commons.*;

public class Main {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws InterruptedException {
        new LogMessage("This is a program that will hack into the school's grade portal!", LogMessage.INFO);
        waitFor(1000);
        new LogMessage("Loading libraries...", LogMessage.INFO);
        waitFor(4346);
        new LogMessage("Attempting to isolate network...", LogMessage.INFO);
        waitFor(1150);
        new LogMessage("Found 19.83.700.21:8080, mapping to './src/'", LogMessage.INFO);
        waitFor(5700);
        new LogMessage("Running tests to find old/inactive sessions", LogMessage.INFO);
        waitFor(3000);
        new LogMessage("FOUND: {1} data stream open on HTTP", LogMessage.DEBUG);
        new LogMessage("Opening Virtual Machine", LogMessage.INFO);
        waitFor(6000);
        new LogMessage("Success: opening POWERSHELL session.", LogMessage.INFO);

        System.out.println("""
                
                #!
                
                PowerShell --
                All rights reserved.

                Try the new cross-platform PowerShell https://aka.ms/pscore6
                
                >>
                """);

        printPowershellCode();

        MenuSelector.ResponseOption[] questions = {
                MenuSelector.ResponseOption.of("1.", "Submit Grades (unavailable)", () -> System.out.println("doesn't work")),
                MenuSelector.ResponseOption.of("2.", "View Students (unavailable)", () -> System.out.println("doesn't work")),
                MenuSelector.ResponseOption.of("3.", "Change a Grade", () -> {
                    System.out.printf("%nHere's a list of students:%n");

                    try {
                        waitFor(2000);
                    } catch (InterruptedException ignored) { }

                    printStudents();

                    MenuSelector.ResponseOption[] sami = {
                            MenuSelector.ResponseOption.of("y.", "YES", () -> {
                                Scanner scanner = new Scanner(System.in);
                                System.out.print("Okay, enter Sami's new grade:\r\n>> ");
                                String s = scanner.nextLine();
                                System.out.println("\r\nDONE!");
                            }),
                            MenuSelector.ResponseOption.of("n.", "NO", () -> System.out.println("don't pick this one"))
                    };
                    MenuSelector menuSelector2 = new MenuSelector("Change Sami's Grade?", sami);

                    menuSelector2.prompt();
                })
        };
        MenuSelector menuSelector1 = new MenuSelector("""
                
                init ~
                
                      _       _ _ _               _                _____   ____   _____ _______   ______           _             _       _  \s
                     | |     (_) | |             | |              |  __ \\ / __ \\ / ____|__   __| |  ____|         | |           (_)     | | \s
                     | | __ _ _| | |__  _ __ ___ | | _____ _ __   | |__) | |  | | (___    | |    | |__   _ __   __| |_ __   ___  _ _ __ | |_\s
                 _   | |/ _` | | | '_ \\| '__/ _ \\| |/ / _ \\ '_ \\  |  ___/| |  | |\\___ \\   | |    |  __| | '_ \\ / _` | '_ \\ / _ \\| | '_ \\| __|
                | |__| | (_| | | | |_) | | | (_) |   <  __/ | | | | |    | |__| |____) |  | |    | |____| | | | (_| | |_) | (_) | | | | | |_\s
                 \\____/ \\__,_|_|_|_.__/|_|  \\___/|_|\\_\\___|_| |_| |_|     \\____/|_____/   |_|    |______|_| |_|\\__,_| .__/ \\___/|_|_| |_|\\__|
                                                                                                                    | |                     \s
                 (A Spectacular Service by ECHO!) v0.0.1                                                            |_|                     \s
                 
                 Select one of the options below.
                """, questions);
        menuSelector1.prompt();
    }

    public static void printPowershellCode() throws InterruptedException {
        new ColorChain().green("FUNCTION").s().magenta("frm_output").s().gray('{').println();
        waitFor(800);
        new ColorChain().s(4).green("PROCESS").s().gray('{').println();
        waitFor(800);
        new ColorChain().s(8).magenta("Write-Host").s().yellow("$_ -ForegroundColor").s().blue("yellow").s()
                .yellow("-BackgroundColor").s().blue("black").println();
        waitFor(800);
        new ColorChain().s(4).gray('}').ln().gray('}').println();
        waitFor(800);
        new ColorChain().yellow("$networks").none(" = ").gray("@('https://google.com', 'https://static.ezgrades.com/" +
                "users?name=name&password-field=super%20secret%20password.')").println();
        waitFor(1000);
        new ColorChain().green("FOREACH").s().gray('(').yellow("$network").s().green("in").s().yellow("$networks").gray(") {").println();
        waitFor(500);
        new ColorChain().s(4).yellow("$response").gray(" = ").magenta("PING.exe").s().yellow("-n").s().blue(1).println();
        waitFor(500);
        new ColorChain().s(4).green("IF").s().gray("(").yellow("$?").s().gray("-eq").s().green("$true").gray(") {").println();
        waitFor(600);
        new ColorChain().s(8).magenta("Write-Host").s().gray("'Could connect to ").yellow("$network").gray(": ").yellow("$response").gray('\'').s().red('|').s().magenta("frm_output").println();
        waitFor(700);
        new ColorChain().s(4).gray('}').s().green("ELSE").s().gray('{').println();
        waitFor(800);
        new ColorChain().s(8).magenta("Write-Host").s().gray("'ERROR: could not connect!'").s().red('|').s().magenta("frm_output").println();
        waitFor(600);
        new ColorChain().s(8).magenta("Clear-Host").ln().s(8).green("EXIT").println();
        waitFor(400);
        new ColorChain().s(4).gray('}').ln().gray('}').println();
        waitFor(500);
        new ColorChain().green("FUNCTION").s().magenta("Calculate-Factorial").s().gray('{').println();
        waitFor(500);
        new ColorChain().s(4).green("PARAM").s().gray('(').red("[Int64]").s().yellow("$number").gray(")").println();
        waitFor(600);
        new ColorChain().s(4).red("[Int64]").s().yellow("$result").gray(" = ").blue(1).println();
        waitFor(700);
        new ColorChain().s(4).green("FOR").s().gray("(").yellow("$i").gray(" = ").blue(1).gray("; ").yellow("$i")
                .gray(" -le ").yellow("$number").gray("; ").yellow("$i").gray("++) {").println();
        waitFor(500);
        new ColorChain().s(8).yellow("$result").gray(" = ").yellow("$result").gray(" * ").yellow("$i").ln().s(4).gray('}').println();
        waitFor(400);
        new ColorChain().s(4).green("RETURN").s().yellow("$result").println();
        waitFor(300);
        new ColorChain().gray('}').println();
        waitFor(500);
        new ColorChain().underline(new ColorChain().red("<# Run a pre-packaged java program #>")).println();
        waitFor(500);
        new ColorChain().magenta("JAVA.exe").s().yellow("-jar").s().gray("PasswordCracker.jar").println();
        waitFor(300);
        new ColorChain().green("EXIT").println();
    }

    public static final int AMOUNT_OF_STUDENTS = 35;

    private static final List<Student> listOfRandomStudents = Stream.generate(Student::new)
            .limit(AMOUNT_OF_STUDENTS).collect(Collectors.toList());

    static {
        listOfRandomStudents.add(new Student("Sami S.", "F", new boolean[] {true, true, true, true, true}));
    }

    private static void printStudents() {
        for (Student s : listOfRandomStudents) {
            char[] symbols = new char[s.attendance.length];
            for (int i = 0; i < symbols.length; i++) {
                symbols[i] = s.attendance[i] ? 'P' : 'A';
            }

            ColorChain attendance = new ColorChain();

            for (int i = 0, length = symbols.length; i < length; i++) {
                if (symbols[i] == 'P') {
                    attendance.green(symbols[i]);
                } else {
                    attendance.red(symbols[i]);
                }
                if (i != symbols.length - 1) attendance.s();
            }

            ColorChain c = new ColorChain();

            c.cyan('|').s().none("Student :: ").underline(new ColorChain().none(s.name)).ln()
                    .cyan('|').s(12).none("Letter Grade = " + s.grade).ln()
                    .cyan('|').s(12).none("Attendance = ").insert(attendance).s().gray("(past 5 days)")
                    .println();

//            System.out.printf("| Student :: %s%n| %sLetter Grade = %s%n| %sAttendance = %s (past 5 days)%n", s.name, tab,
//                    s.grade, tab, Arrays.toString((symbols)));
        }
    }

    private static class Student {
        static JSONArray firstNames;

        static {
            try {
                URI uri = new URI("https://raw.githubusercontent.com/dominictarr/random-name/master/names.json");
                JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                firstNames = new JSONArray(tokener);
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }

        static final Random r = new Random();
        static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWYZ";

        String name;
        String grade;
        boolean[] attendance = new boolean[5];

        public Student() {
            this.name = getRandomName();
            this.grade = getRandomGrade();

            for (int i = 0; i < attendance.length; i++) {
                attendance[i] = r.nextInt(100) > 15;
            }
        }

        public Student(String name, String grade, boolean[] attendance) {
            this.name = name;
            this.grade = grade;
            this.attendance = attendance;
        }

        private String getRandomGrade() {
            return gradeFromInt(r.nextInt(50) + 60) + (r.nextInt(5) == 0 ? "+" : r.nextInt(3) == 0 ? "-" : "");
        }

        private char gradeFromInt(int val) {
            if (val < 60) return 'F';
            if (val < 70) return 'D';
            if (val < 80) return 'C';
            if (val < 90) return 'B';
            return 'A';
        }

        private String getRandomName() {
            String firstName = firstNames.getString(r.nextInt(firstNames.length()));
            char lastName = letters.toCharArray()[r.nextInt(letters.length())];

            return String.format("%s %c.", firstName, lastName);
        }

        @Override
        public String toString() {
            return "Student :: " +
                    "name = '" + name + '\'' +
                    ", grade = " + grade +
                    ", attendance = " + Arrays.toString(attendance);
        }
    }
}
