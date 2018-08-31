package hello;

import com.google.gson.JsonObject;

public class Hello {
    public static JsonObject main(JsonObject args) {
        String name = "stranger";
        if (args.has("name"))
            name = args.getAsJsonPrimitive("name").getAsString();
        String greeting = "Hello " + name + "!";
        System.out.println(greeting);
        System.err.println("Java to stderr");
        JsonObject response = new JsonObject();
        response.addProperty("greeting", greeting);
        return response;
    }
}
