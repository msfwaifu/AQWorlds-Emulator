package com.aqworlds;

import it.gotoandplay.smartfoxserver.data.User;
import it.gotoandplay.smartfoxserver.events.InternalEventObject;
import it.gotoandplay.smartfoxserver.extensions.AbstractExtension;
import it.gotoandplay.smartfoxserver.extensions.ExtensionHelper;
import it.gotoandplay.smartfoxserver.lib.ActionscriptObject;

public class AQWorlds extends AbstractExtension {
    private World world;
    public ExtensionHelper helper;

    public void init() {
        this.helper = ExtensionHelper.instance();
        this.world = new World(this);
    }

    public void handleInternalEvent(InternalEventObject ieo) {
        String event = ieo.getEventName();
        switch (event) {
            case "serverReady":
                break;
        }
    }

    public void handleRequest(String cmd, String[] params, User user, int fromRoom) {

    }

    public void handleRequest(String cmd, ActionscriptObject ao, User user, int fromRoom) {
        throw new UnsupportedOperationException("ActionScriptObject requests are not supported.");
    }
}
