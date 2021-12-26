package utils.chucknorris;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import objects.chucknorris.GetResponseObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonParser {


    public void parseGSON(String fileLocation) throws FileNotFoundException {
        Gson gson = new Gson();
        GetResponseObject responseObject = gson.fromJson(new JsonReader(new FileReader(fileLocation)), GetResponseObject.class);
    }
}
