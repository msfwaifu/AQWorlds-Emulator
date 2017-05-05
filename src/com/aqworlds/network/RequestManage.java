package com.aqworlds.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestManage {

    private HashMap<String, MessageHandler> requests;
    private List<String> banned;

    public RequestManage() {
        this.requests = new HashMap();
        this.banned = new ArrayList<>();
    }

    public void registry() {

    }
}
