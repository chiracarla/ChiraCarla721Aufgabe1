import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        read();
        startingWith("C");
    }
    static public void read(){
        String filePath = "src/evenimente.tsv";
        List<String> names= new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            lines.remove(0);
            for(String line : lines){
                String[] fields = line.split("\t");
                names.add(fields[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String name : names){
            System.out.println(name);
        }
    }

    static public void startingWith(String letter){
        String filePath = "src/evenimente.tsv";
        List<String> names= new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for(String line : lines){
                String[] fields = line.split("\t");
                if(fields[1].startsWith(letter)){
                    names.add(fields[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        names = names.stream()
                .distinct()
                .collect(Collectors.toList());
        for(String name : names){
            System.out.println(name);
        }
    }
}