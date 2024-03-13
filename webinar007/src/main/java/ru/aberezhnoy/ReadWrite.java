package ru.aberezhnoy;

import javax.management.relation.RoleInfoNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWrite {
    public static void main(String[] args) {
        Path txt1 = Paths.get("webinar007/webinar8/1.txt");
        Path txt2 = Paths.get("webinar007/webinar8/2.txt");

        String val = """
                Hello
                World
                """;

//        try (OutputStream out = Files.newOutputStream(txt1, StandardOpenOption.APPEND)) {
//            out.write(val.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException();
//        }
//
//        try {
//            List<String> lines = Files.readAllLines(txt1);
//            for (String line : lines)
//                System.out.println(line);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            System.out.println(Files.exists(txt2));
            Files.createFile(txt2);
            System.out.println(Files.exists(txt2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
