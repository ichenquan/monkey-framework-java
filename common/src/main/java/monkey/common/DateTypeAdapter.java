package monkey.common;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileName: DateTypeAdapter
 * Description:
 * Author: ChenQ
 * Date:  2020/4/28
 */
public class DateTypeAdapter extends TypeAdapter<Date> {
    @Override
    public void write(JsonWriter writer, Date value) throws IOException {
        if (value == null) {
            writer.nullValue();
        } else {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
            writer.value(format);
        }
    }

    @Override
    public Date read(JsonReader reader) throws IOException {
        if (reader.peek() == null) {
            return null;
        }
        Long value = reader.nextLong();
        return new Date(value);
    }
}
