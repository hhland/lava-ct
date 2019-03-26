package lava.ct.netty.server;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lava.ct.netty.server.impl.TimeServer;


public abstract class BoostrapServer<CH extends Channel> {

	
	 private  ServerBootstrap bootstrap;

	 public BoostrapServer() {
			super();
			this.bootstrap = new ServerBootstrap();
	 }
	 
	 public BoostrapServer(ServerBootstrap bootstrap) {
		super();
		this.bootstrap = bootstrap;
	}
	 
	 


	protected ServerBootstrap getBootstrap() {
		return bootstrap;
	}

	public final void bind(int port) throws Exception{
		try (EventLoopGroup bossGroup=new NioEventLoopGroup();
				EventLoopGroup workerkGroup=new NioEventLoopGroup();
				){
		    
		    getBootstrap()
			.group(bossGroup,workerkGroup)
			.channel(channelClass())
			.childHandler(createChildHandler())
			.handler(createHandler())
			
			;
		    
		    
		    	    
			ChannelFuture future=getBootstrap().bind(port).sync();
			future.channel().closeFuture().sync();
		
		}
	}
	
	public abstract Class<? extends ServerChannel> channelClass();
	
	public abstract ChildHandler createChildHandler();
	
	protected abstract class ChildHandler extends ChannelInitializer<CH>{
		
		protected ChannelHandler[] lineBasedDecoder(int maxlenght) {
             return new ChannelHandler[] {
            		 new LineBasedFrameDecoder(maxlenght),
			        new StringDecoder()};	
		}
		
	}
	
	public  ChannelHandlerAdapter createHandler(){
		  return  new LoggingHandler(LogLevel.INFO);
	}
	
	
	protected static Date now() {
		return Calendar.getInstance().getTime();
	}
 
 
   protected static String toString(byte[] bytes) {
	 String ret=null;
	 try {
		ret =new String(bytes,"UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return ret;
 }
	
	
	
	
	 
	 
	 
	 
	 
	 
	 
}
