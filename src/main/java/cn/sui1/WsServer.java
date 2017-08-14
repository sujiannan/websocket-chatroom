package cn.sui1;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/** 
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端, 
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端 
 */ 
@ServerEndpoint("/wserver")
public class WsServer {

	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。  
    private static int onlineCount = 0;  
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WsServer> webSocketSet = new CopyOnWriteArraySet<WsServer>();  
    //与某个客户端的连接会话，需要通过它来给客户端发送数据  
    private Session session;  
    
	@OnOpen
    public void onopen(Session session){
        this.session = session;  
        addOnlineCount();
        webSocketSet.add(this);
        System.out.println("一个客户端连接成功,目前在线：" + this.getOnlineCount());
    }
    @OnClose
    public void onclose(Session session){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("一个客户端下线了...目前在线：" + this.getOnlineCount());
    }
    @OnMessage      
    public void onmsg(Session session,String msg){
    	 String[] str = msg.split(":");  
    	 for (WsServer ws : webSocketSet) {
    		 if(!ws.session.equals(this.session)) {  //除自己以外，群发消息
    			 try {
					ws.session.getBasicRemote().sendText("[" + str[0] + "]说：" + str[1]);
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
    		 }
		}
    }
    /** 
     * 发生错误时调用 
     */  
    @OnError  
    public void onError(Session session, Throwable error){  
        System.out.println("发生错误");  
        error.printStackTrace();  
    }  
    
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	public static synchronized void addOnlineCount() {
		WsServer.onlineCount++;
	} 
	public static synchronized void subOnlineCount() {
		WsServer.onlineCount--;
	} 
	
     
}
