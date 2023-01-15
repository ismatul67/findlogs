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

    public static List<Data> checkLog (List<String> input){
        List<Data> results = new ArrayList<>();
        input.forEach(data ->{
            Data newData = new Data(data,0);
            results.add(newData);
        });
        try (Stream<String> stream = Files.lines(Paths.get("src/log.log"))) {
            stream.forEach(lines -> {
                input.forEach(data ->{
                    if (lines.contains(data)){
                        results.forEach(result ->{
                            if (result.getName().equals(data)){
                                result.setCount(result.getCount()+1);
                            }
                        });
                    }
                });
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}