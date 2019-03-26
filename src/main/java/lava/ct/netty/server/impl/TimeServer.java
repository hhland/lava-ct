package lava.ct.netty.server.impl;

import java.util.Calendar;
import java.util.Date;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lava.ct.netty.server.BoostrapServer;

public class TimeServer extends BoostrapServer<SocketChannel> {

	
	
	
	public TimeServer() {
		super();
		// TODO Auto-generated constructor stub
	}






	public TimeServer(ServerBootstrap bootstrap) {
		super(bootstrap);
		// TODO Auto-generated constructor stub
	}






	public enum Order{
		
		
		
		queryTime("QUERY TIME");
		
		String text;
		
		

		private Order(String... vals) {
			this.text = vals[0];
		}



		public String getText() {
			return text;
		}
		
		
		
		
	}
	
	
	
	
	
	
	protected class ChildChannleHandler extends ChildHandler{

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// TODO Auto-generated method stub
			ch.pipeline().addLast(lineBasedDecoder(1024));
			ch.pipeline().addLast(
			        new ChannelHandlerAdapter() {

				@Override
				public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
					// TODO Auto-generated method stub
					//ByteBuf buf=(ByteBuf) msg;
					//byte[] req=new byte[buf.readableBytes()];
					//buf.readBytes(req);
					String body=(String)msg;//TimeServer.toString(req);
					System.out.println(TimeServer.class.getName()+" receive order:"+body);
					String currentTime=Order.queryTime.getText().equals(body)?now().toString():"BAD ORDER";
					ByteBuf resp=Unpooled.copiedBuffer(currentTime.getBytes());
					ctx.writeAndFlush(resp);
				}

				@Override
				public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
					// TODO Auto-generated method stub
					cause.printStackTrace();
					ctx.close();
				}

				@Override
				public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
					// TODO Auto-generated method stub
					ctx.flush();
				}

				
				
				
				
				
				
			});
		}
		
	}






	@Override
	public Class channelClass() {
		// TODO Auto-generated method stub
		return NioServerSocketChannel.class;
	}






	@Override
	public ChildHandler createChildHandler() {
		// TODO Auto-generated method stub
		return new ChildChannleHandler();
	}
	
	
	
	
	public  static void main(String[] args) throws Exception {
		ServerBootstrap sb=new ServerBootstrap();
		sb.option(ChannelOption.SO_BACKLOG,100);
		BoostrapServer server=new TimeServer(sb);
		server.bind(8000);
		
}
	
	
}
