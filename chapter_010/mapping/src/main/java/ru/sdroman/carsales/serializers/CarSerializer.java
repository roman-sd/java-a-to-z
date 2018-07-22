package ru.sdroman.carsales.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sdroman.carsales.models.Car;

import java.lang.reflect.Type;

/**
 * @author sdroman
 * @since 06.2018
 */
public class CarSerializer implements JsonSerializer<Car> {

    /**
     * Returns json object.
     *
     * @param car                      Car
     * @param type                     Type
     * @param jsonSerializationContext JsonSerializationContext
     * @return JsonElement
     */
    @Override
    public JsonElement serialize(Car car, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.addProperty("id", car.getId());
        result.addProperty("model", car.getModel().getName());
        result.addProperty("driveType", car.getDriveType().getName());
        result.addProperty("body", car.getBody().getName());
        result.addProperty("engine", car.getEngine().getName());
        result.addProperty("transmission", car.getTransmission().getName());
        result.addProperty("year", car.getYear());
        return result;
    }
}
