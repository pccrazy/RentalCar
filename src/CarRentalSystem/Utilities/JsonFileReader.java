package CarRentalSystem.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** Created by CodeCrazy on 4/29/17. */
public class JsonFileReader {

  public enum file {
    Users,
    Cars
  }

  public static <T> T jsonToPojo(file whichFile, Class<T> pojoClass) {
    try {
      Gson gson =  new Gson();
      InputStream in =
          pojoClass
              .getClass()
              .getResourceAsStream("/CarRentalSystem/JsonFiles/" + whichFile + ".json");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      return pojoClass.cast(gson.fromJson(br, pojoClass));
    } catch (ClassCastException e) {
      return null;
    }
  }

  public static <T> void WriteToJson(file toFile, Class<T> pojoClass) {
    try {
      //write converted json data to a file named "CountryGSON.json"
      Gson gson = new Gson();

      String json =  gson.toJson(pojoClass);
      FileWriter writer =
          new FileWriter(
              pojoClass
                  .getClass()
                  .getResource("/CarRentalSystem/JsonFiles/" + toFile + ".json")
                  .getFile());
      writer.write(json);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
