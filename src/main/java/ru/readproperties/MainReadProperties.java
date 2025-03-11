package ru.readproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainReadProperties {

    public static void main(String[] args) {
//        version1();
        version2();
    }

    private static void version1() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);  // Загружаем данные из файла
            String value = properties.getProperty("ключ");  // Читаем значение по ключу
            System.out.println("Значение: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void version2() {
        Properties properties = new Properties();
        try (InputStream input = MainReadProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
            String value = properties.getProperty("learning.java.17");
            System.out.println("Значение: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
