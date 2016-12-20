package org.fish.chat.chat.service;


import org.fish.chat.chat.ChatProtocol;
import org.fish.chat.chat.model.UserSession;

import java.util.List;

/**
 * Comments for UserSessionService.java
 *
 */
public interface UserSessionService {

    public UserSession connect(long userId, long cid, String ip, int identity, String clientId, int type, float protocolVersion);

    public boolean disconnect(long userId, long cid, int type);

    public List<UserSession> getAllUserSession(long userId);

    public UserSession getUserSession(long userId, int type);

    public boolean destroyUserSession(long userId, long cid, int type);

    public boolean heartBeat(long userId, int type);

    public void presence(long userId, ChatProtocol.FishPresence presence, int type);

}