package com.lung.gateway;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/30 - 18:49
 * @implSpec gateway-starter
 */
public class GateWayApplication {
    public static void main(String[] args) throws InterruptedException {

        final NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        final NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap()
                .option(ChannelOption.SO_BACKLOG, Integer.MAX_VALUE)
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class);
//                .handler(new LoggingHandler(LogLevel.INFO))
        try {
            //  ws://127.0.0.1:8080
            // 绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(8080).sync();

            // 等待服务器端监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
