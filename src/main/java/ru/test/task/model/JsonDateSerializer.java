package ru.test.task.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@Component
public class JsonDateSerializer extends JsonSerializer<Date> {
    public JsonDateSerializer() {
    }

    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
        if (date != null) {
            String formattedDate = ((DateFormat)DateFormatConstants.DEFAULT_DATE_FORMAT.get()).format(date);
            gen.writeString(formattedDate);
        }

    }
}
