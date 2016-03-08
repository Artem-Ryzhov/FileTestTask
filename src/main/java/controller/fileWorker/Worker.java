package controller.fileWorker;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 01.03.16
 * Time: 20:25
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public interface Worker {
    JSONArray jsonKeyWords (File file,String key,int length,int limit) ;
    JSONObject MetaData(File file,boolean meta);
}
