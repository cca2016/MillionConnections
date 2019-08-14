package net.millionconnection;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ChannelHandler.Sharable
public class TcpCountHandler extends ChannelInboundHandlerAdapter {


    private AtomicInteger atomicInteger = new AtomicInteger();


    public TcpCountHandler(){

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{

            System.out.println("Current connection = "+ atomicInteger.get());

        }, 0, 3, TimeUnit.SECONDS);

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        atomicInteger.incrementAndGet();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        atomicInteger.decrementAndGet();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("TcpCountHandler exceptionCaught");
        cause.printStackTrace();
    }
}