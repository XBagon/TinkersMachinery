package xbagon.timac;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import xbagon.timac.proxy.CommonProxy;

public class Config {

    private static final String CATEGORY_GENERAL = "General";

    // This values below you can access elsewhere in your mod:


    // Call this from CommonProxy.preInit(). It will create our config if it doesn't
    // exist yet and read the values if it does exist.
    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            TinkersMachinery.logger.log(Level.INFO, "Loading config...");
            cfg.load();
            initOresConfig(cfg);
        } catch (Exception e1) {
            TinkersMachinery.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initOresConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");

        //cfg.get
    }
}
