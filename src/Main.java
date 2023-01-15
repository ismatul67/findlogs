import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String [] finder = {"Mozilla","Google","Safari"};
        System.out.println(checkLog(Arrays.asList(finder)));
    }

    public static Map<String,Integer> checkLog (List<String> input){
        Map<String,Integer> results = new HashMap<>();
        input.forEach(data ->{
            results.put(data, 0);
        });
        try (Stream<String> stream = Files.lines(Paths.get("src/log.log"))) {
            stream.forEach(lines -> {
                input.forEach(data ->{
                    if (lines.contains(data)){
                        for (String key : results.keySet()) {
                            if (key.equals(data)){
                                results.put(key, results.get(key)+1);
                            }
                        }
                    }
                });
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}