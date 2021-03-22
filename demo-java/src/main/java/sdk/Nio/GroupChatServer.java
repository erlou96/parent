package sdk.Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 6666;

    public GroupChatServer(){
        try {
            // 得到选择器
            selector = Selector.open();
            // ServerSocketChannel
            serverSocketChannel = ServerSocketChannel.open();
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(GroupChatServer.PORT));
            // 设置非阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 将该channel 注册到selector上
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void listen(){

        while (true){

            try {
                int count = selector.select(2000);
                if (count > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    Iterator<SelectionKey> iterator = selectionKeys.iterator();

                    while (iterator.hasNext()){
                        // 取出selectkey
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel channel = serverSocketChannel.accept();
                            // 将channel 注册到selector上
                            channel.register(selector, SelectionKey.OP_READ);
                            // 提示
                            System.out.println(channel.getRemoteAddress()+"上线");
                        }if (key.isReadable()) {

                            // 处理读 (专门写方法)

                            // 当前key删除,防止重复读
                            iterator.remove();
                        }
                    }
{                    }
                }else {
                    System.out.println("等待...");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void read(SelectionKey key) {

        // 定义一个socketChannel
        SocketChannel socketChannel = null;
        socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int read = socketChannel.read(buffer);
            // 根据read 值做处理
            if (read > 0) {
                String msg = new String(buffer.array());
                System.out.println("for 客户端"+ msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 转发消息给其他的客户端
    public void sendInfoToOtherClients(String msg, SocketChannel self) {

        HashMap<Integer,Integer> map = new HashMap<>();
    }
}

