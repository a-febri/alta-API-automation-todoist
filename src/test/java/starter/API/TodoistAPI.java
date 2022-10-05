package starter.API;

public class TodoistAPI {
    public static String URL = "https://api.todoist.com";
    public static String AUTH = "d256eb8544ab45ff968db31541e1f058ce0ce5d6";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_REQUEST_BODY_FILE = DIR+"/src/test/resources/JSON/RequestBody";
    public static final String JSON_SCHEMA_VALIDATOR_FILE = DIR+"/src/test/resources/JSON/JsonSchema";
}
