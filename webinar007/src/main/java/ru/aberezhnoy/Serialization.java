package ru.aberezhnoy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serialization {
    public static void main(String[] args) {
        Path path = Paths.get("webinar007/webinar8/point.class");

        try (OutputStream out = Files.newOutputStream(path)) {
            Point point = new Point(5, 7);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(point);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = Files.newInputStream(path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            Point point = (Point) objectInputStream.readObject();

            System.out.println(point);
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }


    public static class Point implements Serializable {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
