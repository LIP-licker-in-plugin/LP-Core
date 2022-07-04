package com.darksoldier1404.dppc.api.twitch;

import com.darksoldier1404.dppc.DPPCore;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.common.events.domain.EventChannel;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.helix.domain.Stream;
import org.bukkit.Bukkit;

public class TwitchAPI {
    private static final DPPCore plugin = DPPCore.getInstance();
    private static TwitchClient tc;

    public static void init() {
        String key,secret;
        key = plugin.config.getString("Settings.twitch-api-key");
        secret = plugin.config.getString("Settings.twitch-api-secret");
        if(key == null || secret == null) {
            plugin.log.warning("Twitch API Key 또는 Secret이 설정되지 않았습니다.");
            plugin.log.warning("Twitch API 사용 불가.");
            return;
        }
        tc = TwitchClientBuilder.builder().withEnableHelix(true).withClientId(plugin.config.getString("Settings.twitch-api-key")).withClientSecret(plugin.config.getString("Settings.twitch-api-secret")).withDefaultEventHandler(SimpleEventHandler.class).build();
        registerEvents();
    }

    public static void enableStreamTracking(String username) {
        tc.getClientHelper().enableStreamEventListener(username);
    }

    public static void registerEvents() {
        tc.getEventManager().onEvent(ChannelGoLiveEvent.class, e -> {
            EventChannel ec = e.getChannel();
            Stream s = e.getStream();
            Bukkit.getServer().getPluginManager().callEvent(new TwitchLiveEvent(ec, s, e));
        });
    }
}
