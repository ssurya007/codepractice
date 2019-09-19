package serializationpractice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WithoutSerialization {
	public static void main(String... args) throws InterruptedException, ExecutionException {
		try {
			Writer.writeStock(new PrintWriter("test.txt"));
			Reader.readStock( new FileInputStream("test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Reader {
	static void readStock(FileInputStream fis) {
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] content = new byte[10000];
		try {
			int flag = fis.read(content);
			while(flag >= 0) {
				flag = fis.read(content);
				
			}
			objectMapper.reader().readValues(content);
		} catch ( IOException e) {
			e.printStackTrace();
		}
	}
}



class Writer {
	static void writeStock(PrintWriter pw) {
		Stock s = new Stock("HCL", "HYD");
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		
		try {
//			FileOutputStream fos = new FileOutputStream("test.txt");
			
			objectMapper.writer(new DefaultPrettyPrinter()).writeValueAsString(s);
			} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Stock {
	String name;
	String location;
	public Stock(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}


