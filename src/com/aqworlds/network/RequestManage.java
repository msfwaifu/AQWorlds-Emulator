package com.aqworlds.network;

import com.aqworlds.network.events.FirstJoin;

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
        this.request(new FirstJoin());
    }

    private void request(MessageHandler handler) {
        if (handler.getClass().getAnnotations().length > 0) {
            Event event = handler.getClass().getAnnotation(Event.class);
            if (event.banned()) {
                this.banned.add(event.packet());
            }
            this.requests.put(event.packet(), handler);
        }
    }
}
