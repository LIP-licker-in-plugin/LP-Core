package com.darksoldier1404.dppc.api.twitch;

import com.darksoldier1404.dppc.DPPCore;
import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import com.github.twitch4j.common.events.domain.EventChannel;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.helix.domain.Stream;
import org.bukkit.Bukkit;

public class TwitchAPI {
    private static final DPPCore plugin = DPPCore.getInstance();
    private static TwitchClient tc;

    public static void init() {
        String key,secret,cbid,cbtoken;
        key = plugin.config.getString("Settings.twitch-api-key");
        secret = plugin.config.getString("Settings.twitch-api-secret");
        cbid = plugin.config.getString("Settings.twitch-chatbot-clientID");
        cbtoken = plugin.config.getString("Settings.twitch-chatbot-accessToken");
        if(key == null || secret == null) {
            plugin.log.warning("Twitch API Key 또는 Secret이 설정되지 않았습니다.");
            plugin.log.warning("Twitch API 사용 불가.");
            return;
        }
        if(cbid == null || cbtoken == null) {
            plugin.log.warning("Twitch Chatbot ClientID 또는 AccessToken이 설정되지 않았습니다.");
            plugin.log.warning("Twitch API 사용 불가.");
            return;
        }
        tc = TwitchClientBuilder.builder()
                .withEnableHelix(true)
                .withClientId(plugin.config.getString("Settings.twitch-api-key"))
                .withClientSecret(plugin.config.getString("Settings.twitch-api-secret"))
                .withDefaultEventHandler(SimpleEventHandler.class)
                .withEnableChat(true)
                .withChatAccount(new OAuth2Credential(cbid, cbtoken))
                .build();
        registerEvents();
    }

    public static void enableStreamTracking(String username) {
        tc.getClientHelper().enableStreamEventListener(username);
    }

    private static void registerEvents() {
        tc.getEventManager().onEvent(ChannelGoLiveEvent.class, e -> {
            EventChannel ec = e.getChannel();
            Stream s = e.getStream();
            Bukkit.getServer().getPluginManager().callEvent(new TwitchLiveEvent(ec, s, e));
        });
        tc.getEventManager().onEvent(ChannelMessageEvent.class, e -> {
            Bukkit.getServer().getPluginManager().callEvent(new TwitchMessageEvent(e));
        });
    }

    public static TwitchClient getTwitchClient() {
        return tc;
    }
}
