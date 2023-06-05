import javax.json.*;
import java.io.*;
import java.lang.String;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ScanWordsMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {

        String line = value.toString();
        JsonReader reader = Json.createReader(new StringReader(line));
        JsonObject object = reader.readObject();
        reader.close();

        try {
            if (object.getJsonObject("entities") != null) {
                object = object.getJsonObject("entities");
                JsonArray arrayURLS = object.getJsonArray("urls");
                arrayURLS.toString();
                if (arrayURLS != null) {
                    String expanded = null;
                    for (int i = 0; i < arrayURLS.size(); i++) {
                        JsonObject expanded_url = arrayURLS.getJsonObject(i);
                        expanded = expanded_url.getString("expanded_url");
                        for (int x = 0; x < expanded.length(); x++) {
                            if (expanded != null) {
                                expanded = expanded_url.getString("expanded_url");
                                System.out.println(expanded);   
                               
                                output.write(new Text(expanded), new LongWritable(1));
                            }
                        }
                    }
                }
            }
            } catch(ClassCastException e){
                System.out.print(e);
            } catch(NumberFormatException e){
                System.out.println(e);
        }
                    
    }
}

