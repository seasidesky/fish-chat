package org.fish.chat.mqtt.handler;

import io.netty.channel.ChannelHandlerContext;
import org.fish.chat.mqtt.protocol.wire.MqttSuback;
import org.fish.chat.mqtt.protocol.wire.MqttSubscribe;
import org.fish.chat.mqtt.session.ChannelSession;

/**
 * Comments for MqttSubscribeHandler.java
 *
 */
public class MqttSubscribeHandler extends AbstractMqttHandler<MqttSubscribe> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, MqttSubscribe msg) throws Exception {
        ChannelSession channelSession = channelSessionManager.getChannelSession(ctx.channel());
        if (channelSession != null) {
            ctx.writeAndFlush(new MqttSuback(msg));
            mqttBizService.subscribe(channelSession.getUserId(), channelSession.getCid(), msg);
        } else {
            ctx.close();
        }
    }

}
