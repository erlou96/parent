package sdk.Nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class NIOClient {

    public static void main(String[] args) throws Exception {
        // 1. 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
        // 2. 切换非阻塞模式
        sChannel.configureBlocking(false);
        // 3. 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 4. 发送数据给服务端
        String str = "hello";
        buf.put((new Date().toString() + "\n" + str).getBytes());
        buf.flip();
        sChannel.write(buf);
        sChannel.shutdownOutput();
        // 5. 关闭通道
        sChannel.close();
    }
}
