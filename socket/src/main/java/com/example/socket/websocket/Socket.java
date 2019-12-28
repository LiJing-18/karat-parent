package com.example.socket.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lijing
 * @date 2019/12/28 15:19
 */
@ServerEndpoint("/websocket")
public class Socket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<Socket> webSocketSet = new CopyOnWriteArraySet<Socket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;


    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        //处理数据
         /*String[] arr = message.split(",");
         System.out.println(arr[0]+"***第二个"+arr[1]);*/

        //群发消息
        for(Socket item: webSocketSet){
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        //this.session.getBasicRemote().sendText(message);//同步
        this.session.getAsyncRemote().sendText(message);//异步
    }

    /**
     * websocket  session发送文本消息有两个方法：getAsyncRemote()和getBasicRemote()
     * getAsyncRemote()和getBasicRemote()是异步与同步的区别，
     * 大部分情况下，推荐使用getAsyncRemote()。
     * 由于getBasicRemote()的同步特性，
     * 并且它支持部分消息的发送即sendText(xxx,boolean isLast)
     * isLast的值表示是否一次发送消息中的部分消息
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        Socket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        Socket.onlineCount--;
    }
}
