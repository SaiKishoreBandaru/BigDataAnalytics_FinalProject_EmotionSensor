import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;

public class Storage1 {   

 private static Configuration conf = null;
 public static String x,y,z;
 public static String col;
 public static String val="";
 public static String tableName;
 public static long i = 0;
 
    /**
     * Initialization
     */
    static {
        conf = HBaseConfiguration.create();
    }

public static void push (String x, String y,long z, String i) throws IOException{
            HTable table = new HTable(conf, "Detector");
        Put p = new Put(Bytes.toBytes(row+i));
            p.add(Bytes.toBytes("Motion1"), Bytes.toBytes(x), i,Bytes.toBytes(x));
			            p.add(Bytes.toBytes("Motion1"), Bytes.toBytes(y), i,Bytes.toBytes(y));
						            p.add(Bytes.toBytes("Motion1"), Bytes.toBytes(z), i,Bytes.toBytes(z));
			
        table.put(p);
        
   
    }

public static void main(String agrs[]) throws IOException
{                           
        
        String fileName="Sensor1.txt";
            
            
                FileReader inputFile = new FileReader(fileName);
                BufferedReader bufferReader = new BufferedReader(inputFile);
                String line;
                while ((line = bufferReader.readLine()) != null)   {
            String[] splits = line.split("\t");
            x = splits[1];
            y = splits[0];
            z=splits[2]
			
           
            i = i + 1;
                    storage.push(x,y,z,i);
            System.out.println(i+" "+x+" "+y+z);
           // val = "";
                }
                bufferReader.close();
    

        
        
    }
}