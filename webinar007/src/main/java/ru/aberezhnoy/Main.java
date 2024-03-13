package ru.aberezhnoy;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path vebinar8 = Paths.get("webinar007/webinar8");
//        exist(vebinar8);
//
        Path txt1 = Paths.get("webinar007/webinar8/1.txt");
//        exist(txt1);
//
//        Path txt2 = Paths.get("webinar007/webinar8/2.txt");
//        exist(txt2);
//
//        delete(txt2);
//        delete(vebinar8);
        deleteRecursively(vebinar8);

//        Path vebinar8 = Paths.get("webinar007/webinar8");
//        Path vebinar8copy = Paths.get("webinar007/CopyWebinar8");
//
//        try {
//            Files.copy(vebinar8, vebinar8copy, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            System.out.println(Files.isDirectory(vebinar8));
//            System.out.println(Files.size(txt1));
//            System.out.println(Files.getOwner(txt1));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try {
//            System.out.println(Files.exists(txt2));
//            Files.createFile(txt2);
//            System.out.println(Files.exists(txt2));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (DirectoryStream<Path> stream = Files.newDirectoryStream(vebinar8)) {
//            for (Path file : stream) {
//                System.out.println(file.getFileName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private static void exist(Path path) {
        if (Files.exists(path))
            System.out.println("\'%s\' существует".formatted(path));
        else
            System.out.printf("'%s' не существует%n", path);
    }

    private static void delete(Path path) {
//        try {
//            Files.deleteIfExists(path);
//        } catch (NoSuchFileException x) {
//            System.err.format("%s: не найден" + " файл или папка%n", path);
//        } catch (DirectoryNotEmptyException x) {
//            System.err.format("%s не пустая директория%n", path);
//        } catch (IOException x) {
//            // File permission problems are caught here.
//            System.err.println(x);
//        }
        try (Stream<Path> pathStream = Files.walk(path)) {
            pathStream.sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteRecursively(Path path) {
        File file = Path.of(path.toUri()).toFile();
        if (file.isDirectory()) {
            for (File sub : Objects.requireNonNull(file.listFiles())) {
                deleteRecursively(sub.toPath());
            }
        }
        file.delete();
    }

}
