package muyi.tiny.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Yang Fan
 * @date: 2019-05-19
 * @desc: 不使用netty时 我们怎么去实现一个NIO服务器
 */
public class PlainNIOServer {
    static final ByteBuffer HI = ByteBuffer.wrap("Hi! ".getBytes());


    public static void main(String[] args) throws Exception {
        PlainNIOServer server = new PlainNIOServer();
        server.server(8080);
    }

    public void server(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //配置服务器 serverSocketChannel不阻塞
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        //将服务器绑定到指定的端口
        InetSocketAddress address = new InetSocketAddress(port);
        serverSocket.bind(address);

        //打开selector来处理Channel
        Selector selector = Selector.open();
        //将serverSocketChannel注册到selector以接受连接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            try {
                //阻塞直到下一个传入事件
                selector.select();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            //获取所有接收事件的SelectionKey实例
            Set<SelectionKey> readyKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                try {
                    if (key.isAcceptable()) {
                        accept(key, selector);
                    }
                    if (key.isValid() && key.isReadable()) {
                        read(key);
                    }
                    if (key.isValid() && key.isWritable()) {
                        send(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException ex) {
                        //ignore on close
                    }
                }
            }

        }
    }

    public void accept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();

        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, HI.duplicate());
        System.out.println("Accepted connection from " + client);

    }


    public void read(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer readBuff = ByteBuffer.allocate(32);
        client.read(readBuff);
        readBuff.flip();

//        System.out.println("received msg: " + readBuff.toString() + " from " + client);
        key.attach(readBuff);
    }

    public void send(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        while (buffer.hasRemaining()) {
            if (client.write(buffer) == 0) {
                break;
            }
        }
//                        client.close();
    }
}

