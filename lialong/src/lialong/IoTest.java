package lialong;

import java.io.*;
// 字节流
class IoTest{
  public static void main(String[] args){
    // 声明输入流引用
    FileInputStream fis = null;
    // 声明输出流引用
    FileOutputStream fos = null;
    try{
      // 字节流-读数据： 生成代表输入流的对象
      fis = new FileInputStream("D:/from.txt");
      // 生成代表输出流的对象
      fos = new FileOutputStream("D:/to.txt");
      // 生成一个字节数组
      byte[] buffer = new byte[100];
      // 调用输入流的read方法，读取数据
      int temp = fis.read(buffer, 0, 100);
      // 写入到文件中
      fos.write(buffer,0, temp);
      String s = new String(buffer); // 将字节转为字符
      // 去除空格
      s = s.trim();
      System.out.println(s);
    }
    catch(Exception e){
      System.out.println(e);
    }
  }
}