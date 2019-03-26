package lava.ct.netty.client;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lava.ct.netty.client.impl.TimeClient;

import lava.ct.netty.server.BoostrapServer;

import lava.ct.netty.server.impl.TimeServer;

public abstract class BoostrapClient <CH extends Channel>  {

	
	protected  Bootstrap bootstrap;
	
	protected enum SystemPropperty{
		lineSeparator("line.separator");
		public final String value;
		
		
		private SystemPropperty() {
			// TODO Auto-generated constructor stub
		    value=System.getProperty(name());
		}
		
		private SystemPropperty(String key) {
			// TODO Auto-generated constructor stub
		    value=System.getProperty(key);
		}
		
	}
	
	public BoostrapClient() {
		super();
		this.bootstrap = new Bootstrap();
	}
	
	 
	 public BoostrapClient(Bootstrap bootstrap) {
		super();
		this.bootstrap = bootstrap;
	}

	 public Bootstrap getBootstrap() {
			return bootstrap;
		}

	public final  void connect(String host,int port) throws Exception{
		try (
				EventLoopGroup workerkGroup=new NioEventLoopGroup();
				){
		
		    getBootstrap()
			.group(workerkGroup)
			.channel(channelClass())
			.handler(createChannelHandler())
			.option(ChannelOption.TCP_NODELAY,true )
			;
		    
		    
			
			ChannelFuture future=getBootstrap().connect(host,port).sync();
			future.channel().closeFuture().sync();
		
		}
	}
	 
	public abstract Class<? extends CH> channelClass();
	
	public abstract ChannelHandler<CH> createChannelHandler();
	 
	 protected Date now() {
			return Calendar.getInstance().getTime();
		}
	
	 
	
	 
	 protected abstract class ChannelHandler<CH extends Channel> extends ChannelInitializer<CH> {
			
			
		 protected String toString(byte[] bytes) {
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
	 
	 
	 
	 
}
