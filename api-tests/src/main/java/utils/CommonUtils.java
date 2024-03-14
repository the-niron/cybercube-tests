package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonUtils {
  public String readFile(String fileName) throws IOException {
    File file = new File(Constants.FILE_PATH + fileName);
    return FileUtils.readFileToString(file, Constants.UTF8);
  }

  public String getInputDataFromRequests(String file, String field) throws IOException {
    String content = this.readFile(Constants.REQUESTS_DIR + file);
    JsonObject jsonArticle = new JsonParser().parse(content).getAsJsonObject();
    return String.valueOf(jsonArticle.get(field));
  }
}
