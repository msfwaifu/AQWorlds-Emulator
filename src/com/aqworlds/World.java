package com.aqworlds;

import com.aqworlds.config.ConfigData;
import it.gotoandplay.smartfoxserver.data.Zone;
import it.gotoandplay.smartfoxserver.extensions.AbstractExtension;

public class World {

    private AQWorlds aqworlds;
    public ConfigData config;
    private final AbstractExtension extension;
    public final Zone zone;

    public World(AQWorlds aqworlds) {
        this.aqworlds = aqworlds;
        this.extension = aqworlds;
        this.zone = this.aqworlds.helper.getZone(this.aqworlds.getOwnerZone());
    }
}
