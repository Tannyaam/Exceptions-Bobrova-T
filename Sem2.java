import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sem2 {
    public static void main(String[] args) {
        String pathFile = "test.txt";
        Map<String, String> map = new HashMap<>();
        try {
            List<String> input = Files.readAllLines(Path.of(pathFile));
            for (String s : input) {
                String[] line = s.split("=");
                map.put(line[0], line[1]);
            }
            map.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            System.err.println("error");
        }
    }
}
