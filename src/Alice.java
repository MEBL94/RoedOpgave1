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

    public void countChars() {
        try {
            System.out.println(path);
            file = new File(path + "Alice.txt");
            scanner = new Scanner(file);
            map = new TreeMap<>();
            for (int i = 97; i < 123; i++) {
                map.put((char) i, 0);
            }
            while (scanner.hasNextLine()) {
                line = scanner.nextLine().toLowerCase();
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
            map = new TreeMap<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                double d = (entry.getValue() / counter) * 100.0;
                System.out.println("Letter " + entry.getKey() +
                        " occurrences: " + d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
