package xbagon.timac;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.resources.I18n;
import slimeknights.tconstruct.library.client.CustomFontColor;
import slimeknights.tconstruct.library.materials.AbstractMaterialStats;
import slimeknights.tconstruct.library.materials.Material;

import java.util.List;

public class CasingStats extends AbstractMaterialStats {

    public final static String LOC_HEAT_RESISTANCE  = "stat.casing.heatresistance.name";

    public final static String LOC_HEAT_RESISTANCE_DESC   = "stat.casing.heatresistance.desc";

    public final static String COLOR_HEAT_RESISTANCE = CustomFontColor.valueToColorCode(1f);

    public final static String LOC_HARDNESS  = "stat.casing.hardness.name";

    public final static String LOC_HARDNESS_DESC   = "stat.casing.hardness.desc";

    public final static String COLOR_HARDNESS  = CustomFontColor.valueToColorCode(1f);

    public static final String TYPE = "casing";

    public final int heatResistance;
    public final int hardness;

    static {
        Material.UNKNOWN.addStats(new CasingStats(0,0));
    }

    public CasingStats(int heatResistance, int hardness){
        super(TYPE);
        this.heatResistance = heatResistance;
        this.hardness = hardness;
    }

    @Override
    public String getIdentifier() {
        return TYPE;
    }

    @Override
    public List<String> getLocalizedInfo() {
        return ImmutableList.of(I18n.format(LOC_HEAT_RESISTANCE) + ": " + heatResistance,I18n.format(LOC_HARDNESS) + ": " + hardness);
    }

    @Override
    public List<String> getLocalizedDesc()
    {
        return ImmutableList.of(I18n.format(LOC_HEAT_RESISTANCE_DESC),I18n.format(LOC_HARDNESS_DESC));
    }
}
