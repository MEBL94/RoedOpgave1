import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Alice {
    private static String path = System.getProperty("user.dir") + "\\";
    private File file;
    private Scanner scanner;
    private Map<Character, Integer> map;
    private double counter = 0.0;
    private String line = "";

    public Alice() {

    }

    public Alice(String path, File file, Scanner scanner, Map<Character, Integer> map, double counter, String line) {
        this.path = path;
        this.file = file;
        this.scanner = scanner;
        this.map = map;
        this.counter = counter;
        this.line = line;
    }

    public void countChars() {
        try {
            System.out.println(path);
            this.setFile(new File(path + "Alice.txt"));
            this.setScanner(new Scanner(file));
            this.setMap(new TreeMap<>());
            for (int i = 97; i < 123; i++) {
                map.put((char) i, 0);
            }
            while (scanner.hasNextLine()) {
                this.setLine(scanner.nextLine().toLowerCase());
                for (Character c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        map.put(c, map.get(c) + 1);
                        counter++;
                    }
                }
            }
            System.out.println("Count: " + counter);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void calculatePercent() {
        try {
            this.setMap(new TreeMap<>());
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                double d = (entry.getValue() / counter) * 100.0;
                System.out.println("Letter " + entry.getKey() +
                        " occurrences: " + d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Alice.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Map<Character, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Character, Integer> map) {
        this.map = map;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
