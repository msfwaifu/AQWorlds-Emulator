package com.aqworlds.world.users;

import com.aqworlds.log.Logging;
import com.aqworlds.world.World;
import it.gotoandplay.smartfoxserver.data.User;
import it.gotoandplay.smartfoxserver.exceptions.LoginException;

import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class UsersManage {

    private final World world;

    public UsersManage(World world) {
        this.world = world;
    }

    public void login(String nick, String pass, SocketChannel channel) {
        boolean result = this.world.database.getPool().queryForBoolean("SELECT * FROM users WHERE Name = ? AND Hash = ?", nick, pass);
        if (result) {
            if (this.world.zone.getUserByName(nick) != null) {
                this.sendResponse(new String[]{"multiLoginWarning"}, channel);
            } else {
                try {
                    User user = this.world.aqworlds.helper.canLogin(nick, pass, channel, this.world.zone.getName(), true);
                } catch (LoginException error) {
                    Logging.error(error);
                }
            }
        }
    }

    public void lost(User user) {
        if (!user.properties.isEmpty()) {
            user.properties.clear();
        }
    }

    public void sendResponse(String[] params, SocketChannel chan) {
        if (chan != null && params != null) {
            LinkedList channels = new LinkedList();
            channels.add(chan);
            this.world.aqworlds.sendResponse(params, -1, null, channels);
        }
    }

    public void sendResponse(String[] params, User user) {
        if (user != null && params != null) {
            LinkedList channels = new LinkedList();
            channels.add(user.getChannel());
            this.world.aqworlds.sendResponse(params, -1, null, channels);
        }
    }
}
