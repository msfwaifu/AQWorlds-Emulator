package com.aqworlds.world;

import com.aqworlds.AQWorlds;
import com.aqworlds.config.ConfigData;
import com.aqworlds.database.Database;
import com.aqworlds.network.RequestManage;
import com.aqworlds.world.users.UsersManage;
import it.gotoandplay.smartfoxserver.data.Zone;
import net.sf.json.JSONObject;

public class World {

    public AQWorlds aqworlds;
    public ConfigData config;
    public UsersManage usersManage;
    public RequestManage requestManage;
    public Database database;
    public final Zone zone;

    public World(AQWorlds aqworlds) {
        this.aqworlds = aqworlds;
        this.zone = this.aqworlds.helper.getZone(this.aqworlds.getOwnerZone());
    }

    public void sendResponse(JSONObject params) {
        this.aqworlds.sendResponse(params, -1, null, this.zone.getChannelList());
    }

    public void sendResponse(String[] params) {
        this.aqworlds.sendResponse(params, -1, null, this.zone.getChannelList());
    }
}
