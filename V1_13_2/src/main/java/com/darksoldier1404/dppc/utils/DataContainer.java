package com.darksoldier1404.dppc.utils;

import com.darksoldier1404.dppc.lang.DLang;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
public class DataContainer {
    private final JavaPlugin plugin;
    private YamlConfiguration config;
    private DLang lang;
    private String prefix;
    private final Map<String, Object> data = new HashMap<>();

    public DataContainer(JavaPlugin plugin) {
        this.plugin = plugin;
        this.config = ConfigUtils.loadDefaultPluginConfig(plugin);
        this.prefix = ColorUtils.applyColor(config.getString("Settings.prefix"));
        this.lang = new DLang(config.getString("Settings.Lang") == null ? "Korean" : config.getString("Settings.Lang"), plugin);
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void setConfig(YamlConfiguration config) {
        this.config = config;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void addUserData(UUID uuid, YamlConfiguration data) {
        if(this.data.containsKey("udata")) {
            Map<UUID, YamlConfiguration> udata = (Map<UUID, YamlConfiguration>) this.data.get("udata");
            udata.put(uuid, data);
        }else{
            Map<UUID, YamlConfiguration> udata = new HashMap<>();
            udata.put(uuid, data);
            this.data.put("udata", udata);
        }
    }

    public void removeUserData(UUID uuid) {
        if(this.data.containsKey("udata")) {
            Map<UUID, YamlConfiguration> udata = (Map<UUID, YamlConfiguration>) this.data.get("udata");
            udata.remove(uuid);
        }
    }

    @Nullable
    public YamlConfiguration getUserData(UUID uuid) {
        if(this.data.containsKey("udata")) {
            Map<UUID, YamlConfiguration> udata = (Map<UUID, YamlConfiguration>) this.data.get("udata");
            return udata.get(uuid);
        }
        return null;
    }

    public boolean hasUserData(UUID uuid) {
        if(this.data.containsKey("udata")) {
            Map<UUID, YamlConfiguration> udata = (Map<UUID, YamlConfiguration>) this.data.get("udata");
            return udata.containsKey(uuid);
        }
        return false;
    }

    public void clearUserData() {
        if(this.data.containsKey("udata")) {
            Map<UUID, YamlConfiguration> udata = (Map<UUID, YamlConfiguration>) this.data.get("udata");
            udata.clear();
        }
    }

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public void reload() {
        config = ConfigUtils.reloadPluginConfig(plugin, config);
        prefix = ColorUtils.applyColor(config.getString("Settings.prefix"));
        lang = new DLang(config.getString("Settings.Lang") == null ? "Korean" : config.getString("Settings.Lang"), plugin);
    }
}
