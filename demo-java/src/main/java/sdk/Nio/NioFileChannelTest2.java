package sdk.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannelTest2 {
    public static void main(String[] args) throws Exception{

        File file = new File("F://test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        FileChannel channel = fileInputStream.getChannel();

        channel.read(byteBuffer);

        byteBuffer.flip();

        byte[] array = byteBuffer.array();

        System.out.println(new String(array));

        fileInputStream.close();
    }
}
