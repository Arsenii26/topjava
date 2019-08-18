package ru.javawebinar.topjava.web.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * <p>
 * Handling Hibernate lazy-loading
 *
 * @link https://github.com/FasterXML/jackson
 * @link https://github.com/FasterXML/jackson-datatype-hibernate
 * @link https://github.com/FasterXML/jackson-docs/wiki/JacksonHowToCustomSerializers
 */
//ObjectMapper how to serialize Java objects into JSON and deserialize JSON string into Java objects.
public class JacksonObjectMapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new JacksonObjectMapper();

    private JacksonObjectMapper() {
        registerModule(new Hibernate5Module()); //register new module

        registerModule(new JavaTimeModule());
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        //JsonAutoDetect.Visibility.
        //ANY
        //Value that means that all kinds of access modifiers are acceptable, from private to public.
        //DEFAULT
        //Value that indicates that default visibility level (whatever it is, depends on context) is to be used.
        //NON_PRIVATE
        //Value that means that any other access modifier other than 'private' is considered auto-detectable.
        //NONE
        //Value that indicates that no access modifiers are auto-detectable: this can be used to explicitly disable auto-detection for specified types.
        //PROTECTED_AND_PUBLIC
        //Value that means access modifiers 'protected' and 'public' are auto-detectable (and 'private' and "package access" == no modifiers are not)
        //PUBLIC_ONLY
        //Value to indicate that only 'public' access modifier is considered auto-detectable.
        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static ObjectMapper getMapper() {
        return MAPPER;
    }
}