package dataTest.Json;

import actions.commons.GlobalConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;

@Data
public class DataJson {

    public static DataJson getDataJson() {
        String fileName = switch (System.getProperty("ENV")) {
            case "dev" -> GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\dataTest\\Json\\dev.json";
            case "test" -> GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\dataTest\\Json\\test.json";
            case "staging" -> GlobalConstants.PROJECT_PATH + "\\src\\test\\java\\dataTest\\Json\\staging.json";
            default -> throw new RuntimeException("This Environment is not support");
        };

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(fileName), DataJson.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("url")
    String url;

    @JsonProperty("host")
    String hostName;

    @JsonProperty("username")
    String userName;

    @JsonProperty("password")
    String password;

}
