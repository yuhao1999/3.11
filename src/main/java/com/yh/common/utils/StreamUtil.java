package com.yh.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 流处理工具类
 * @ClassName: StreamUtil 
 * @Description: TODO
 * @author: admin
 * @date: 2020年03月11日 下午14.49
 * 
 */
public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传无限个。(3分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	*/
	public static void closeAll(AutoCloseable ... autoCloseables ){
		if(autoCloseables.length!=0) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	//TODO 实现代码
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	*/
	public static String readTextFile(InputStream src){
		//字节输出流
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		String str ="";
		int x = 0;
		try {
			while((x=src.read(b))!=-1) {
				out.write(b,0,x);	
			}
			//
			 str =out.toString("utf-8");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeAll(out,src);
		return str;
	//TODO 实现代码
	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile){
		try {
			return readTextFile(new FileInputStream(txtFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	//TODO 实现代码
	}
	
	//返回个某一个时间段的随机日期

		public static Date random(Date minDate, Date maxDate) {
			// 开始毫秒数
			long t1 = minDate.getTime();
			// 结束毫秒数
			long t2 = maxDate.getTime();
	     //介于t2 t1之间的毫米数
			long t3 = (long) (Math.random() * (t2 - t1 + 1) + t1);

			return new Date(t3);

		}
	
public static List<String> read(InputStream inputStream) throws IOException{
		
		BufferedReader read=new BufferedReader(new InputStreamReader(inputStream));
		List<String> list=new ArrayList<String>();
		String str="";
		while((str=read.readLine())!=null) {
			
			list.add(str);
		}
		
		return list;
	}

}
