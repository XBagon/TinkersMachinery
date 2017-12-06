package xbagon.timac;

import slimeknights.tconstruct.library.tools.ToolPart;

public class CasingPart extends ToolPart{
    public CasingPart(int cost) {
        super(cost);
        setUnlocalizedName(TinkersMachinery.MOD_ID + ".casing").setRegistryName("casing");
    }
}
