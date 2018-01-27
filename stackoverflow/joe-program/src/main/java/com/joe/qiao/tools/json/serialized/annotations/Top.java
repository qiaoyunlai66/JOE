package com.joe.qiao.tools.json.serialized.annotations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Joe Qiao
 * @Date 26/01/2018.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "Car"),
        @JsonSubTypes.Type(value = Truck.class, name = "Trunk"),
        @JsonSubTypes.Type(value = Bike.class, name = "Bike"),
        @JsonSubTypes.Type(value = NoargConstructor.class, name = "NoargConstructor")

})
public interface Top {
}
