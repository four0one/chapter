package com.demo.server.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.ArrayList;
import java.util.List;

public class ByteToIntDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf,
						  List<Object> list) throws Exception {
		if (byteBuf.readableBytes() >= 4) {
			int i = byteBuf.readInt();
			list.add(i);
		}
	}
}
