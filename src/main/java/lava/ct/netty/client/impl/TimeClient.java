package lava.ct.netty.client.impl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import lava.ct.netty.client.BoostrapClient;
import lava.ct.netty.server.impl.TimeServer;
import lava.ct.netty.server.impl.TimeServer.Order;


public class TimeClient extends BoostrapClient<SocketChannel> {

	
	
	
	
	
	protected class ChildChannleHandler extends ChannelHandler<SocketChannel>{

		private final ByteBuf msg;
		
		protected  ChildChannleHandler() {
			// TODO Auto-generated constructor stub
			byte[] req=(Order.queryTime.getText()+SystemPropperty.lineSeparator.value).getBytes();
			msg=Unpooled.buffer(req.length);
			msg.writeBytes(req);
		}
		
		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// TODO Auto-generated method stub
			ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
			//ch.pipeline().addLast(new StringDecoder());
			ch.pipeline().addLast(
					
                   
					new ChannelHandlerAdapter() {

				@Override
				public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
					// TODO Auto-generated method stub
					ctx.close();
				}

				@Override
				public void channelActive(ChannelHandlerContext ctx) throws Exception {
					// TODO Auto-generated method stub
					
					ctx.writeAndFlush(msg);
					
				}

				@Override
				public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
					// TODO Auto-generated method stub
					ByteBuf buf=(ByteBuf) msg;
					byte[] req=new byte[buf.readableBytes()];
					buf.readBytes(req);
					String body=ChildChannleHandler.this.toString(req);
					System.out.println(TimeClient.class.getName()+" now is:"+body);
				}

				
				
				
				
				
				
			});
		}
		
	}

	@Override
	public Class<? extends SocketChannel> channelClass() {
		// TODO Auto-generated method stub
		return NioSocketChannel.class;
	}

	@Override
	public BoostrapClient<SocketChannel>.ChannelHandler<SocketChannel> createChannelHandler() {
		// TODO Auto-generated method stub
		return new ChildChannleHandler();
	}

	

	
	public  static void main(String[] args) throws Exception {
		
		BoostrapClient server=new TimeClient();
		server.connect("localhost",8000);
		
}
	
	
	

}
