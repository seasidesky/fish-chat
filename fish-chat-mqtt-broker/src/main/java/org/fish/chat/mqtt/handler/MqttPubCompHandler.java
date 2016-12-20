package org.fish.chat.mqtt.handler;

import io.netty.channel.ChannelHandlerContext;
import org.fish.chat.mqtt.protocol.wire.MqttPubComp;
import org.fish.chat.mqtt.session.ChannelSession;

/**
 * Comments for MqttPubCompHandler.java
 *
 */
public class MqttPubCompHandler extends AbstractMqttHandler<MqttPubComp> {

    /* (non-Javadoc)
     * @see cn.techwolf.mqtt.handler.AbstractMqttHandler#channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object)
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, MqttPubComp msg) throws Exception {
        ChannelSession channelSession = channelSessionManager.getChannelSession(ctx.channel());
        if (channelSession != null) {
            mqttBizService.pubComp(channelSession.getUserId(), channelSession.getCid(), msg);
        } else {
            ctx.close();
        }
    }

}