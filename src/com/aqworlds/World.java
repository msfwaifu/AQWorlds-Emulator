package com.aqworlds;

import it.gotoandplay.smartfoxserver.data.Zone;
import it.gotoandplay.smartfoxserver.extensions.AbstractExtension;

public class World {

    private final AbstractExtension extension;
    public final Zone zone;

    public World(AQWorlds aqw) {
        this.extension = aqw;
        this.zone = aqw.helper.getZone(aqw.getOwnerZone());
    }
}
