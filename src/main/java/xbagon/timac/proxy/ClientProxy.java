package xbagon.timac.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import xbagon.timac.ModBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        //ModelRegisterUtil.registerToolModel(new TinkersFurnace());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.TINKERS_FURNACE_BLOCK.initModel();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //ModelRegisterUtil.registerToolModel(new TinkersFurnace());
    }
}