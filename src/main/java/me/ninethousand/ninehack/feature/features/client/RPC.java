package me.ninethousand.ninehack.feature.features.client;

import me.ninethousand.ninehack.feature.Category;
import me.ninethousand.ninehack.feature.Feature;
import me.ninethousand.ninehack.feature.annotation.EnabledByDefault;
import me.ninethousand.ninehack.feature.annotation.NineHackFeature;
import me.ninethousand.ninehack.feature.setting.Setting;
import me.ninethousand.ninehack.util.RPCUtil;

@EnabledByDefault
@NineHackFeature(name = "RPC", description = "Discord RPC", category = Category.Client)
public class RPC extends Feature {
    public static Feature INSTANCE;

    public static final Setting<RPCMode> rpcMode = new Setting<>("Mode", RPCMode.NineHack);

    public RPC() {
        addSettings(rpcMode);
    }

    @Override
    public void onEnable() {
        if (nullCheck()) return;

        RPCUtil.startup();
    }

    @Override
    public void onDisable() {
        if (nullCheck()) return;

        RPCUtil.shutdown();
    }

    public enum RPCMode {
        NineHack,
        TuxHack
    }
}
