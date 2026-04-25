package hw_6;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("1", "Петров Петр Петрович", 4.5),
                new Student("2", "Иванов Иван Иванович", 4.9),
                new Student("3", "Помидоров Огурчик Кунжутович", 3.2)
        );

        XmlGenerator.generateXml(students, "..\\lesson_11_105\\IOStreams\\src\\students.xml");XmlGenerator.generateXml(students, "..\\lesson_11_105\\IOStreams\\src\\students.xml");

        StreamParser.convertXmlToJson("..\\lesson_11_105\\IOStreams\\src\\students.xml", "..\\lesson_11_105\\IOStreams\\src\\students.json");

        TestRunner.runTests(StudentFileTests.class);
    }
}