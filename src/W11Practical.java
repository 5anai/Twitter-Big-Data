

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class W11Practical {

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Usage: java -cp lib/*:bin WordCount <input_path> <output_path>");
			System.exit(1);
		}

		String input_path = args[0];
		String output_path = args[1];

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Word Count");

		FileInputFormat.setInputPaths(job, new Path(input_path));
		FileOutputFormat.setOutputPath(job, new Path(output_path));

		job.setMapperClass(ScanWordsMapper.class);
			job.setMapOutputKeyClass(Text.class);
				job.setMapOutputValueClass(LongWritable.class);
					job.setReducerClass(CountWordsReducer.class);
						job.setOutputKeyClass(Text.class);
							job.setOutputValueClass(LongWritable.class);

		try {
			job.waitForCompletion(true);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}