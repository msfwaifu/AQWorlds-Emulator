package com.aqworlds.world;

import com.aqworlds.AQWorlds;
import com.aqworlds.config.ConfigData;
import com.aqworlds.network.RequestManage;
import it.gotoandplay.smartfoxserver.data.Zone;
import net.sf.json.JSONObject;

import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class World {

    private AQWorlds aqworlds;
    public ConfigData config;
    public RequestManage requestManage;
    public final Zone zone;

    public World(AQWorlds aqworlds) {
        this.aqworlds = aqworlds;
        this.zone = this.aqworlds.helper.getZone(this.aqworlds.getOwnerZone());
    }

    public void send(JSONObject params, LinkedList<SocketChannel> channels) {
        this.aqworlds.sendResponse(params, -1, null, channels);
    }
}
