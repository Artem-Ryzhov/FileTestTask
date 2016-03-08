package controller.Buffers;

import Jsvalidation.JsonParser;
import Jsvalidation.Parser;
import controller.fileWorker.FileWorker;
import controller.fileWorker.Worker;
import org.json.simple.JSONObject;
import service.FileSetings;
import service.Settings;

/*
  Основная задача класса создать обект
  ясона для того что положить данние файла
  и затем передавать сервлету
 */
public class JsonBuffer implements Bufers {

    private Worker worker = new FileWorker();
    private Settings setings = new FileSetings();

    private String key = "";
    private int length;
    private boolean met;
    private int limit;

    /*
   Метод принимает данные  дял роботы с текстом с сервлета
    */
    public void setTextParameters(String key,int length,int limit) {
        this.length = length;
        this.key = key;
        this.limit = limit;
    }

    public void setMeta(boolean meta){
        met = meta;
    }

    /*
    принимает данные с обработчика данных текста
    и возвращает сервлету
     */
    public String jsonText(){
        JSONObject infa = new JSONObject();
        Parser jsonParser = new JsonParser();
        infa.put("metaData",worker.MetaData(setings.getFile(),met));
        infa.put("text",worker.jsonKeyWords(setings.getFile(), key, length, limit));
        return   jsonParser.parse(infa.toJSONString());
    }
}
