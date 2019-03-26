package lava.ct.netty.server.impl;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lava.ct.netty.server.BoostrapServer;

public class EchoServer extends BoostrapServer<SocketChannel>{

	@Override
	public Class<? extends ServerChannel> channelClass() {
		// TODO Auto-generated method stub
		return NioServerSocketChannel.class;
	}

	@Override
	public ChildHandler createChildHandler() {
		// TODO Auto-generated method stub
		return new EchoChildHandler();
	}
	
	
	
	protected class EchoChildHandler extends ChildHandler{

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			// TODO Auto-generated method stub
			ChannelPipeline cp= ch.pipeline();
			
		}
		
	}

}
