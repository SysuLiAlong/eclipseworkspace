package lialong;

import java.io.*;
class BufferIoTest{
public static void main(String[] args){
  FileReader fileReader = null;
  BufferedReader bufferedReader = null;
  try{
//	  FileReader
	  //直接用FileReader会报错，因为该类没有添加字符的构造方法，所以可以使用inputstreamreader类
    InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("D:/from.txt")),"UTF-8");
    bufferedReader = new BufferedReader(isr);
    // 按照一行一行的读取
    String line = null;
    while(true){
      line = bufferedReader.readLine();
      if (line == null){
        break;
      }
      // 打印每一行
      System.out.println(line);
    }

  }
  catch(Exception e){
    System.out.println(e);
  }
  finally{
    // 一定要在finally中关闭文件管道
    try{
      fileReader.close();
      bufferedReader.close();
    }
    catch(Exception e){
    System.out.println(e);
    }
  }
}
}