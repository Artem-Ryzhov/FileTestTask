package service;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.03.16
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public class FileSetings implements Settings{
    private  File file;

    public FileSetings() {
        try {
            file = new File( this.getClass().getResource( "/dexter.txt" ).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }
}
