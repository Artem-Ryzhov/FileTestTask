package controller.fileWorker;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 01.03.16
 * Time: 20:25
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public class FileWorker implements Worker  {

      /*
      Метод служит для получения данных с файла
      обработки их и возвращает
       */
    public JSONObject  MetaData(File file,boolean meta){
        JSONObject root = new JSONObject();
        if (meta==true){
            root.put("FileName",fileName(file));
            root.put("FileSie",fileSize(file));
            root.put("FileData",fileData(file));
            return root;
        }
        return root;
    }

    /*
   Метод принимает файл и уловия для роботи с ним
   считиваем поток с файла
   и записивает в лист
   после чего лист передаем в обработчик данних
   и возвращаем результат
    */
    public JSONArray  jsonKeyWords (File file,String key,int length,int limit)  {
        JSONArray jsonArray = new JSONArray();
        String line = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (scanner.hasNext()){
            line =  scanner.next();
            list.add(line); // добавляем текст в список
        }
        scanner.close();
        jsonArray.add(text(list,key,limit,length));  // принимает данные после обработки
        return jsonArray;  // возвращаем текст
    }


    /*
    Обработчик мета данных
     */
    private String fileName(File file) {
        String fileName = file.getName().toString();
        return  fileName;
    }

    private int fileSize(File file) {
        int size = (int)file.length();
        return   size;
    }
    private String  fileData(File file) {
        long lastmodificatedData = file.lastModified();
        Date data = new Date(lastmodificatedData);
        return String.valueOf(data);
    }


     /*
     Обработчик текста
      */
    private String text(ArrayList<String> list,String key,int limit,int length){
        ArrayList<String> keywords = new ArrayList<String>();
        String find = "";
        int counter = 0;
        // int length = 0;
        String words = "";
        for (String m : list){
            if (m.indexOf(key)!=-1 && counter < limit  ){
                if(key.length() <= length){  // проверяем или слово не превишает заданную длину
                    find += m  + " ";
                    keywords.add(find);
                    counter ++;
                } else return "";  // если слово превишает длину возвращаем пустоту
            }
        }
        /*
       Проверяет или список слов не пустой
        */
        if (keywords.size()!=0){
            for (String i : keywords){
                words = i ;
            }
        }
        return  words ;

    }


}




















