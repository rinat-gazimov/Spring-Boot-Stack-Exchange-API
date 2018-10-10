package ru.test.task.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {
    public JsonDateDeserializer() {
    }

    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();

        try {
            return ((DateFormat)DateFormatConstants.DEFAULT_DATE_FORMAT.get()).parse(date);
        } catch (ParseException var5) {
            return null;
        }
    }
}
