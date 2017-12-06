package xbagon.timac;

import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;

import java.util.List;

public class CasingStats extends AbstractMaterialStats {

    public final static String LOC_Durability   = "stat.head.durability.name";

    public final static String LOC_DurabilityDesc    = "stat.head.durability.desc";

    public final static String COLOR_Durability = CustomFontColor.valueToColorCode(1f);

    public final int heatResistance;
    public final int hardness;

    public CasingStats(int heatResistance, int hardness){
        super("MachineCasing");
        this.heatResistance = heatResistance;
        this.hardness = hardness;
    }

    @Override
    public String getIdentifier() {
        return "casing";
    }

    @Override
    public List<String> getLocalizedInfo() {
        return null;
    }

    @Override
    public List<String> getLocalizedDesc() {
        return null;
    }
}
