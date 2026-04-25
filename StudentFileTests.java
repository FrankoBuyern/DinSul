package hw_6;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentFileTests {

    @FileTest
    public void checkIvanovIvanIvanovichInJson() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\lesson_11_505\\IOStreams\\src\\students.json"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null){
                if (line.contains("Иванов Иван Иванович")){
                    found = true;
                }
            }
            if(!found) {
                throw new AssertionError("Иванов Иван Иванович not found");
            }
        }
    }

    @FileTest
    public void checkJsonFormatIsValid() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\lesson_11_505\\IOStreams\\src\\students.json" ))){
            String line;
            boolean id= false;
            boolean name = false;
            boolean grade = false;
            while ((line = reader.readLine()) != null){
                if(line.contains("\"id\"")) id = true;
                if (line.contains("\"fullName\"")) name = true;
                if(line.contains("\"averageGrade\"")) grade = true;
            }
            if (!id || !name || !grade){
                throw new AssertionError("Invalid format");
            }
        }
    }

    @FileTest
    public void checkXMLMatchesJSON() throws Exception {
        int xmlCount = 0;
        int jsonCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\lesson_11_505\\IOStreams\\src\\students.json"))){
            String line;
            while((line = reader.readLine()) != null ){
                if(line.trim().equals("{")) {
                    jsonCount++;
                }
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("..\\lesson_11_505\\IOStreams\\src\\students.json"))){
            String line;
            while((line = reader.readLine()) != null ){
                if(line.trim().equals("<student>")) {
                    xmlCount++;
                }
            }
        }
        if(xmlCount != jsonCount){
            throw new AssertionError("Количество студентов отличается");
        }
    }
}
