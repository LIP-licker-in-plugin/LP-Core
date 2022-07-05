package com.darksoldier1404.dppc.api.twitch;

import com.darksoldier1404.dppc.DPPCore;
import com.outstandingboy.donationalert.platform.Toonation;
import com.outstandingboy.donationalert.platform.Twip;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

@SuppressWarnings("unused")
public class DonationAPI {
    private static final DPPCore plugin = DPPCore.getInstance();
    private static Twip twip;
    private static Toonation toona;

    public static void init() {
        String twipKey = plugin.config.getString("Settings.twipKey");
        String toonaKey = plugin.config.getString("Settings.toonaKey");
        if(twipKey == null) {
            plugin.log.warning("Twip API Key가 설정되지 않았습니다.");
            plugin.log.warning("Twip API 사용 불가.");
        }else{
            try {
                twip = new Twip(twipKey);
            } catch (IOException e) {
                plugin.log.warning("Twip API Key가 잘못되었습니다.");
                plugin.log.warning("Twip API 사용 불가.");
            }
        }
        if(toonaKey == null) {
            plugin.log.warning("Toonation API Key가 설정되지 않았습니다.");
            plugin.log.warning("Toonation API 사용 불가.");
        }else{
            try {
                toona = new Toonation(toonaKey);
            } catch (IOException e) {
                plugin.log.warning("Toonation API Key가 잘못되었습니다.");
                plugin.log.warning("Toonation API 사용 불가.");
            }
        }
    }

    @Nullable
    public static Twip getTwip() {
        return twip;
    }

    @Nullable
    public static Toonation getToona() {
        return toona;
    }
}
