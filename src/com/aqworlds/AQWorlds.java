package com.aqworlds;

import com.aqworlds.config.ConfigData;
import com.aqworlds.database.Database;
import com.aqworlds.network.RequestManage;
import com.aqworlds.world.World;
import com.aqworlds.world.users.UsersManage;
import it.gotoandplay.smartfoxserver.SmartFoxServer;
import it.gotoandplay.smartfoxserver.data.Room;
import it.gotoandplay.smartfoxserver.data.User;
import it.gotoandplay.smartfoxserver.events.InternalEventObject;
import it.gotoandplay.smartfoxserver.extensions.AbstractExtension;
import it.gotoandplay.smartfoxserver.extensions.ExtensionHelper;
import it.gotoandplay.smartfoxserver.lib.ActionscriptObject;

import java.nio.channels.SocketChannel;

public class AQWorlds extends AbstractExtension {
    private World world;
    private boolean open;
    public ExtensionHelper helper;

    public void init() {
        this.helper = ExtensionHelper.instance();
        this.world = new World(this);
        this.world.usersManage = new UsersManage(this.world);
        this.world.config = new ConfigData();
        this.world.requestManage = new RequestManage();
        this.world.database = new Database(this.world.config);
    }

    public void handleInternalEvent(InternalEventObject ieo) {
        String event = ieo.getEventName();
        switch (event) {
            case "serverReady": {
                if (this.world.config.init()) {
                    if (this.world.database.connect()) {
                        this.world.requestManage.registry();
                        this.open = true;
                    } else {
                        SmartFoxServer.log.warning("Can't connect to database.");
                    }
                } else {
                    SmartFoxServer.log.warning("Can't load configurations.");
                }
                break;
            } case "loginRequest": {
                if (this.open) {
                    String nick = ieo.getParam("nick").split("~")[1];
                    String pass = ieo.getParam("pass");
                    SocketChannel channel = (SocketChannel) ieo.getObject("chan");
                    this.world.usersManage.login(nick, pass, channel);
                }
            } case "userLost": case "logOut": {
                User user = (User) ieo.getObject("user");
                this.world.usersManage.lost(user);
                break;
            }
        }
    }

    public void handleRequest(String cmd, String[] params, User user, int fromRoom) {

    }

    public void handleRequest(String cmd, ActionscriptObject ao, User user, int fromRoom) {
        throw new UnsupportedOperationException("ActionScriptObject requests are not supported.");
    }
}
