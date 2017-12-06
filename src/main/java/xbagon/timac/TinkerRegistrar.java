package xbagon.timac;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.library.materials.IMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.util.HashMap;
import java.util.Map;

public class TinkerRegistrar {
    static Map<String,IMaterialStats[]> materialStats = new HashMap<String, IMaterialStats[]>();

    static{
        materialStats.put("wood",new IMaterialStats[]{new CasingStats(400,1)});
        materialStats.put("stone",new IMaterialStats[]{new CasingStats(200,5)});
        materialStats.put("flint",new IMaterialStats[]{new CasingStats(200,30)});
        materialStats.put("cactus",new IMaterialStats[]{new CasingStats(600,1)});
        materialStats.put("bone",new IMaterialStats[]{new CasingStats(500,1)});
        materialStats.put("obsidian",new IMaterialStats[]{new CasingStats(90,1)});
        materialStats.put("prismarine",new IMaterialStats[]{new CasingStats(160,1)});
        materialStats.put("endstone",new IMaterialStats[]{new CasingStats(140,1)});
        materialStats.put("paper",new IMaterialStats[]{new CasingStats(1000,1)});
        materialStats.put("sponge",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("firewood",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("knightslime",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slime",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("blueslime",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("magmaslime",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("iron",new IMaterialStats[]{new CasingStats(100,1)});
        materialStats.put("pigiron",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("netherrack",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("ardite",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("cobalt",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("manyullyn",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("copper",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("bronze",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("lead",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("silver",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("electrum",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("steel",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("string",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("vine",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slimevine_blue",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slimevine_purple",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("blaze",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("reed",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("ice",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("endrod",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("feather",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("leaf",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slimeleaf_blue",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slimeleaf_orange",new IMaterialStats[]{new CasingStats(1,1)});
        materialStats.put("slimeleaf_purple",new IMaterialStats[]{new CasingStats(1,1)});
    }

    public static void init(){
        TinkerRegistry.registerToolPart(ModToolParts.CASING_PART);
        TinkerRegistry.registerTool(ModItems.TINKERS_FURNACE);
        TinkerRegistry.registerToolForgeCrafting(ModItems.TINKERS_FURNACE);
        ToolBuildGuiInfo katanaInfo = new ToolBuildGuiInfo(ModItems.TINKERS_FURNACE);
        katanaInfo.addSlotPosition(33 - 18, 42); // handle
        katanaInfo.addSlotPosition(33, 42 - 18); // binding
        TinkerRegistryClient.addToolBuilding(katanaInfo);
        for(Material m: TinkerMaterials.materials){
            IMaterialStats[] arr = materialStats.get(m.identifier);
            m.addStats(arr[0]);
            //m.addStats(arr[1]);
        }
    }
}
