package Jsvalidation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 07.03.16
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class JsonParser implements Parser{

   public  String parse(String s){
        String result = null;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JSONParser parser = new JSONParser();
            JSONObject jo = null;
            try {
              jo = (JSONObject) parser.parse(s);
            } catch (org.json.simple.parser.ParseException e) {

                e.printStackTrace();
            }
            result = gson.toJson(jo);

        return result;


}

}
