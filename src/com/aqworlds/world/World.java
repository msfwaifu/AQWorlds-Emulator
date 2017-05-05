package com.aqworlds.world;

import com.aqworlds.AQWorlds;
import com.aqworlds.config.ConfigData;
import com.aqworlds.network.RequestManage;
import it.gotoandplay.smartfoxserver.data.Zone;
import it.gotoandplay.smartfoxserver.extensions.AbstractExtension;

public class World {

    private AQWorlds aqworlds;
    public ConfigData config;
    public RequestManage requestManage;
    private final AbstractExtension extension;
    public final Zone zone;

    public World(AQWorlds aqworlds) {
        this.aqworlds = aqworlds;
        this.extension = aqworlds;
        this.zone = this.aqworlds.helper.getZone(this.aqworlds.getOwnerZone());
    }
}
