package database;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.github.nekoposer.database.PostgreSQLConnect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseTest {
    @Test
    @DisplayName("Test selectAll query")
    public void selectAllTest() {
        List<Map<String, Integer>> result = new ArrayList<>();

        Map<String, Integer> firstPlayer = new HashMap<>();
        Map<String, Integer> secondPlayer = new HashMap<>();
        Map<String, Integer> thirdPlayer = new HashMap<>();
        Map<String, Integer> fourthPlayer = new HashMap<>();
        Map<String, Integer> testPlayer = new HashMap<>();

        firstPlayer.put("hh", 31);
        secondPlayer.put("poma", 19);
        thirdPlayer.put("z", 17);
        fourthPlayer.put("qd", 0);
        testPlayer.put("test", 3);

        result.add(firstPlayer);
        result.add(secondPlayer);
        result.add(thirdPlayer);
        result.add(testPlayer);
        result.add(fourthPlayer);

        List<Map<String, Integer>> testFromDB = PostgreSQLConnect.selectAllFromDB();
        Assertions.assertEquals(result, testFromDB);
    }

    @Test
    @DisplayName("Test select query")
    public void selectTest() {
        Map<String, Integer> result = new HashMap<>();
        result.put("z", 17);

        Map<String, Integer> testFromDB = PostgreSQLConnect.selectDataFromDB("z");
        Assertions.assertEquals(result, testFromDB);
    }

    @Test
    @DisplayName("Test insert query")
    public void insertTest() {
        PostgreSQLConnect.insertDataIntoDB("test", 3);

        List<Map<String, Integer>> result = new ArrayList<>();

        Map<String, Integer> firstPlayer = new HashMap<>();
        Map<String, Integer> secondPlayer = new HashMap<>();
        Map<String, Integer> thirdPlayer = new HashMap<>();
        Map<String, Integer> fourthPlayer = new HashMap<>();
        Map<String, Integer> testPlayer = new HashMap<>();

        firstPlayer.put("hh", 31);
        secondPlayer.put("poma", 19);
        thirdPlayer.put("z", 17);
        fourthPlayer.put("qd", 0);
        testPlayer.put("test", 3);

        result.add(firstPlayer);
        result.add(secondPlayer);
        result.add(thirdPlayer);
        result.add(testPlayer);
        result.add(fourthPlayer);

        List<Map<String, Integer>> testFromDB = PostgreSQLConnect.selectAllFromDB();
        Assertions.assertEquals(result, testFromDB);
    }

    @Test
    @DisplayName("Test update query")
    public void updateTest() {
        PostgreSQLConnect.updateDataInDB("test", 3);

        List<Map<String, Integer>> result = new ArrayList<>();

        Map<String, Integer> firstPlayer = new HashMap<>();
        Map<String, Integer> secondPlayer = new HashMap<>();
        Map<String, Integer> thirdPlayer = new HashMap<>();
        Map<String, Integer> fourthPlayer = new HashMap<>();
        Map<String, Integer> testPlayer = new HashMap<>();

        firstPlayer.put("hh", 31);
        secondPlayer.put("poma", 19);
        thirdPlayer.put("z", 17);
        fourthPlayer.put("qd", 0);
        testPlayer.put("test", 3);

        result.add(firstPlayer);
        result.add(secondPlayer);
        result.add(thirdPlayer);
        result.add(testPlayer);
        result.add(fourthPlayer);

        List<Map<String, Integer>> testFromDB = PostgreSQLConnect.selectAllFromDB();
        Assertions.assertEquals(result, testFromDB);
    }
}
