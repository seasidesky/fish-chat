package org.fish.chat.mqtt.handler;

import org.fish.chat.common.log.LoggerManager;
import io.netty.channel.ChannelHandlerContext;
import org.fish.chat.mqtt.protocol.wire.MqttPubRec;
import org.fish.chat.mqtt.session.ChannelSession;

/**
 * 发布信息收到
 * Qos=2
 *
 * @author adre
 */
public class MqttPubRecHandler extends AbstractMqttHandler<MqttPubRec> {

    @Override
    public void channelRead(ChannelHandlerContext ctx, MqttPubRec msg) throws Exception {
        ChannelSession channelSession = channelSessionManager.getChannelSession(ctx.channel());
        if (channelSession != null) {
            mqttBizService.pubRec(channelSession.getUserId(), channelSession.getCid(), msg);
        } else {
            LoggerManager.error("channelSession was null, but receive " + msg);
            ctx.close();
        }
    }

}
