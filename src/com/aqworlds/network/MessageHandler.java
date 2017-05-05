package com.aqworlds.network;

import com.aqworlds.world.World;
import it.gotoandplay.smartfoxserver.data.Room;
import it.gotoandplay.smartfoxserver.data.User;

public abstract class MessageHandler {

    public String[] params;

    public World world;
    public Room room;
    public User user;

    public abstract void process() throws RequestException;
}