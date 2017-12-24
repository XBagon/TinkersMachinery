package xbagon.timac;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.TinkerRegistryClient;
import slimeknights.tconstruct.library.client.ToolBuildGuiInfo;
import slimeknights.tconstruct.tools.TinkerMaterials;
import xbagon.timac.traits.TestTrait;

public class TinkerRegistrar {

    public static void init(){
        TinkerRegistry.registerToolPart(ModToolParts.CASING_PART);
        TinkerRegistry.registerTool(ModItems.TINKERS_FURNACE);
        TinkerRegistry.registerToolForgeCrafting(ModItems.TINKERS_FURNACE);
        TinkerRegistry.addMaterialStats(TinkerMaterials.wood,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.stone,new CasingStats(5,5));
        TinkerRegistry.addMaterialStats(TinkerMaterials.flint,new CasingStats(3,6));
        TinkerRegistry.addMaterialStats(TinkerMaterials.cactus,new CasingStats(0,0));
        TinkerRegistry.addMaterialStats(TinkerMaterials.bone,new CasingStats(4,4));
        TinkerRegistry.addMaterialStats(TinkerMaterials.obsidian,new CasingStats(10,10));
        TinkerRegistry.addMaterialStats(TinkerMaterials.prismarine,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.endstone,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.paper,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.sponge,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.firewood,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.knightslime,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slime,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.blueslime,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.magmaslime,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.iron,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.pigiron,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.netherrack,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.ardite,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.cobalt,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.manyullyn,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.copper,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.bronze,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.lead,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.silver,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.electrum,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.steel,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.string,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.vine,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slimevine_blue,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slimevine_purple,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.blaze,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.reed,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.ice,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.endrod,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.feather,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.leaf,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slimeleaf_blue,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slimeleaf_orange,new CasingStats(1,1));
        TinkerRegistry.addMaterialStats(TinkerMaterials.slimeleaf_purple,new CasingStats(1,1));
        TinkerRegistry.addTrait(new TestTrait());
        TinkerMaterials.paper.addTrait(TinkerRegistry.getTrait("test"),CasingStats.TYPE);
        ToolBuildGuiInfo furnaceInfo = new ToolBuildGuiInfo(ModItems.TINKERS_FURNACE);
        furnaceInfo.addSlotPosition(33, 42 - 18); // binding
        TinkerRegistryClient.addToolBuilding(furnaceInfo);
        //for(Material m: TinkerMaterials.materials){
        //    IMaterialStats[] arr = materialStats.get(m.identifier);
        //    m.addStats(arr[0]);
        //    //m.addStats(arr[1]);
        //}
    }
}
