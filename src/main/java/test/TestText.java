package test;

import controller.fileWorker.FileWorker;
import controller.fileWorker.Worker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import service.FileSetings;
import service.Settings;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.03.16
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class TestText {

    private Settings setings = new FileSetings();
    private Worker worker = new FileWorker();
    private JSONObject testObj = new JSONObject();
    private JSONArray testArray = new JSONArray();
    boolean meta = true;

    /*
  Метод служит тестов для возврата 1 слова
  проверяем или он возвратит 1 слово
  если больше метод свалиться

    */
    @Test
    public void testReturnStatmentForKeyWords() throws Exception {
        String findWord = "java";
        int length = 5;
        int limit = 1;
        String expectResult = "Withjava ";
        testArray.add(expectResult);
        assertEquals(worker.jsonKeyWords(setings.getFile(), findWord, length, limit),testArray);
    }

    /*
  Метод служит тестов для возврата 2 слова
  проверяем или он возвратит 2 слово
  если больше метод свалиться

    */
    @Test
    public void testReturnStatmentForTwoKeyWords() throws Exception {
        String findWord = "java";
        int length = 5;
        int limit = 2;
        String expect = "Withjava informationjava ";
        testArray.add(expect);
        assertEquals(worker.jsonKeyWords(setings.getFile(), findWord, length, limit), testArray);
    }
    /*
  Метод должен возвратить пустоту
  проверяем или он возвратит пустоту
  если возвратит что то  метод свалиться

    */
    @Test
    public void testReturnStatmentForMissing() throws Exception {
        String findWord = "";
        int length = 0;
        int limit = 0;
        String expect = "";
        testArray.add(expect);
        assertEquals(worker.jsonKeyWords(setings.getFile(), findWord, length, limit), testArray);

    }

    /*
    метод должен возвратить пустоту при условии что длина 1

     */
    @Test
    public void testReturnStatmentForWrongLength() throws Exception {
        String findWord = "java";
        int length = 1;
        int limit = 10;
        String expect = "";
        testArray.add(expect);
        assertEquals(worker.jsonKeyWords(setings.getFile(),findWord, length, limit),testArray);
    }
    /*
   Тестируем получения мета данных
   с нашими данными которые мы будем вводить
    */
    @Test
    public void MetaTesting() throws Exception {
        JSONObject expect = new JSONObject();
        JSONObject root = new JSONObject();
        long lastmodificatedData = setings.getFile().lastModified();
        Date data = new Date(lastmodificatedData);
        String time = String.valueOf(data);
        expect.put("FileSie",setings.getFile().length());
        expect.put("FileName",setings.getFile().getName());
        expect.put("FileData",time);

        root.put("meta",expect);
        testObj.put("meta",worker.MetaData(setings.getFile(),meta));
        assertEquals(testObj.toJSONString(),root.toJSONString());
    }
    /*
   Тестируем на получения пустого значения мета данных
    */
    @Test
    public void MetaTestingForMissingReurn() throws Exception {
        JSONObject root = new JSONObject();
        boolean testmeta = false;
        assertEquals(worker.MetaData(setings.getFile(),testmeta).toJSONString(),root.toJSONString());
    }

}
