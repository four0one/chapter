package com.demo.server.main;

import com.demo.server.decoder.ByteToIntDecoder;
import com.demo.server.handler.EchoServerHandler;
import com.demo.server.handler.HeartBeatServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class EchoServer {

	public static void main(String[] args) {
		new EchoServer().start(8888);
	}

	public void start(int port) {
		port = port == 0 ? 8088 : port;
		NioEventLoopGroup group = new NioEventLoopGroup();
		ServerBootstrap bootstrap = new ServerBootstrap();
		bootstrap.group(group).channel(NioServerSocketChannel.class)
				.localAddress(new InetSocketAddress(port))
				.childHandler(new ChannelInitializer<SocketChannel>() {
					protected void initChannel(SocketChannel socketChannel) throws Exception {
						ChannelPipeline pipeline = socketChannel.pipeline();
						pipeline.addLast(new IdleStateHandler(60,0,0, TimeUnit.SECONDS));
						pipeline.addLast(new HeartBeatServerHandler());
					}
				});
		try {
			ChannelFuture channelFuture = bootstrap.bind().sync();
			System.out.println("服务器启动，监听端口：" + port);
			channelFuture.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
