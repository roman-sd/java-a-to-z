package ru.sdroman.carsales.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sdroman.carsales.models.User;

import java.lang.reflect.Type;

/**
 * @author sdroman
 * @since 06.2018
 */
public class UserSerializer implements JsonSerializer<User> {

    /**
     * Returns json object.
     *
     * @param user                     User
     * @param type                     Type
     * @param jsonSerializationContext JsonSerializationContext
     * @return JsonElement
     */
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.addProperty("id", user.getId());
        result.addProperty("login", user.getLogin());
        return result;
    }
}
