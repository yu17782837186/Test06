package cn.com.io;
import java.io.*;
public class TestIo08 {
    public static void main(String[] args) {
        //对接流(综合运用)
        //图片转成字节数组
        //1 图片到程序 2 程序到字节数组
        //字节数组转成图片
        //1 字节数组到程序 2 程序到图片
        byte[] bytes = fileToByteArray("kt.jpg");
        System.out.println(bytes.length);
        byteArrayToFile(bytes,"kt3.jpg");
    }
    private static byte[] fileToByteArray(String src) {
        File file = new File(src);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            os = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024*10];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                os.write(bytes,0,tmp);
            }
            os.flush();
            return ((ByteArrayOutputStream) os).toByteArray();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private static void byteArrayToFile(byte[] src,String dest) {
        InputStream is = new ByteArrayInputStream(src);
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            byte[] bytes = new byte[1024*10];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                os.write(bytes,0,tmp);
            }
            os.flush();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null) {
                    os.close();
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
