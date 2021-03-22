package sdk.Nio;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannelTest {
    public static void main(String[] args) throws Exception{

        // 创建一个字符串
        String str = new String("你好，nio");

        // 创建一个文件输出流
        File file = new File("F://test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // 通过文件输出流，创建一个filechannel
        FileChannel channel = fileOutputStream.getChannel();

        // 创建一个bytebuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 将str put到buffer中
        buffer.put(str.getBytes());

        // 将buffer 翻转
        buffer.flip();

        // 将buffer写入到channel中，write和read 是针对channel来说的
        channel.write(buffer);

        fileOutputStream.close();
    }
}
