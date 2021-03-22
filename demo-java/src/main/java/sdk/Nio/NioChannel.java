package sdk.Nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioChannel {

    public static void main(String[] args) throws Exception{

        FileOutputStream fileOutputStream = new FileOutputStream("F://2.txt");
        FileChannel channel = fileOutputStream.getChannel();

        FileInputStream fileInputStream = new FileInputStream("F://test.txt");
        FileChannel channel1 = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            // 将byteBuffer 清空
            byteBuffer.clear();
            // channel 读取数据
            int read = channel1.read(byteBuffer);

            if (read == -1){
                break;
            }
            // bytebuffer 翻转
            byteBuffer.flip();
            // 将数据写入到channel 中
            channel.write(byteBuffer);
        }



    }
}
