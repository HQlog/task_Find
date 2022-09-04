import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {
    private void equalsFiles(String inputName, String expectedOutputInFile) throws IOException {


        StringBuilder result1 = new StringBuilder();

        try (BufferedReader buff1 = new BufferedReader(new FileReader(inputName))) {
            String a;
            while ((a = buff1.readLine()) != null) result1.append(a);
        }


        StringBuilder result2 = new StringBuilder();

        try (BufferedReader buff2 = new BufferedReader(new FileReader(expectedOutputInFile))) {

            String b;
            while ((b = buff2.readLine()) != null) result2.append(b);
        }

        assertEquals(result2.toString(), result1.toString());
    }

    @Test
    void test() throws IOException {

        equalsFiles("C:\\Users\\Xiaomi\\IdeaProjects\\task_Find\\out\\artifacts\\task_Find_jar\\task_Find.jar", "C:\\Users\\Xiaomi\\IdeaProjects\\task_Find\\out\\artifacts\\task_Find_jar\\task_Find.jar");

    }


}