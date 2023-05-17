import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountWordsReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

	public void reduce(Text key, Iterable<LongWritable> values, Context output) throws IOException, InterruptedException {
		int sum = 0;
		for(LongWritable value : values){
			long l = value.get();
			sum += l;
		}
		output.write(key, new LongWritable(sum));
	}
}