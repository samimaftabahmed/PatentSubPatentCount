package com.samhad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class PatentSubPatentMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable IN_WRITABLE_ONE = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        StringTokenizer stringTokenizer = new StringTokenizer(value.toString(), "\n");

        while (stringTokenizer.hasMoreTokens()) {

            String[] recordSplit = stringTokenizer.nextToken().trim().split(" ");

            String subPatent = recordSplit[1].split("\\.")[0];

            word.set("patent no " + subPatent);
            context.write(word, IN_WRITABLE_ONE);
        }
    }
}
