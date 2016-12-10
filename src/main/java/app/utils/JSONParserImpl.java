package app.utils;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by krisitown on 06.12.16.
 */
public class JSONParserImpl {
    private Gson gson;

    public JSONParserImpl() {
        this.setGson(new GsonBuilder().setPrettyPrinting().create());
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public <T> T[] readFromJson(Class<T[]> classes, String file){
        String fileData = null;
        T[] objects = null;

        try {
            fileData = new String(Files.readAllBytes(Paths.get(file)));
            objects = getGson().fromJson(fileData, classes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objects;
    }
}
