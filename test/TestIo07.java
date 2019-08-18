package cn.com.io;


import java.io.*;

public class TestIo07 {
    public static void main(String[] args) {
        //字节数组输入流
        //1 创建源 字节数组
        //2 选择流 ByteArrayInputStream()
        //3 操作
        //4 可以不用关闭
        byte[] bytes = "talk is cheap show me the code".getBytes();
        InputStream is = new ByteArrayInputStream(bytes);

        byte[] flush = new byte[3];
        int tmp;
        try {
            while((tmp = is.read(flush)) != -1) {
                String str = new String(flush,0,tmp);
                System.out.println(str);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }

        //字节数组输出流
        //1 没有源
        //2 选择流 不需要传参
        //3 操作
        //4 可以不用关闭
        //获取数据 toByteArray()
        OutputStream os = new ByteArrayOutputStream();
        String str = "show me the code";
        byte[] flushs = str.getBytes();
        try {
            os.write(flushs,0,flushs.length);
            os.flush();
            byte[] flag = ((ByteArrayOutputStream) os).toByteArray();
            System.out.println(flag.length+"--->"+new String(flushs,0,((ByteArrayOutputStream) os).size()));
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}
