package ru.sdroman.carsales.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sdroman.carsales.models.Order;

import java.lang.reflect.Type;

/**
 * @author sdroman
 * @since 06.2018
 */
public class OrderSerializer implements JsonSerializer<Order> {

    /**
     * Returns json object.
     * @param order Order
     * @param type Type
     * @param context JsonSerializationContext
     * @return JsonElement
     */
    @Override
    public JsonElement serialize(Order order, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("id", order.getId());
        result.addProperty("sold", order.isSold());
        result.addProperty("price", order.getPrice());
        result.addProperty("created", String.valueOf(order.getCreated()));
        result.addProperty("description", order.getDescription());
        result.addProperty("photoListSize", order.getPhotoList().size());
        result.add("car", context.serialize(order.getCar()));
        result.add("user", context.serialize(order.getUser()));
        return result;
    }
}
