package controller.Buffers;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 02.03.16
 * Time: 20:54
 * To change this template use FileModel | Settings | FileModel Templates.
 */
public interface Bufers {
    public void setTextParameters(String key,int length,int limit);
    public void setMeta(boolean  meta);
     String jsonText();
}
