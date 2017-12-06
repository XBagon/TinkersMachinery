package xbagon.timac.entities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.utils.Tags;

import java.util.ArrayList;
import java.util.List;

public class TinkersFurnaceTileEntity extends TileEntityFurnace{

    List<Material> materials = new ArrayList();

    int cookTime;

    public TinkersFurnaceTileEntity(){
        super();
        GameRegistry.registerTileEntity(TinkersFurnaceTileEntity.class,"TinkersMachineryFurnace");
    }

    public void setCookTime(int cookTime){
        this.cookTime = cookTime;
    }



    @Override
    public int getCookTime(ItemStack stack)
    {
        return cookTime;
    }

    public void setMaterials(NBTTagCompound nbt){
        NBTBase tag = nbt.getTag(Tags.BASE_MATERIALS);
        if (tag instanceof NBTTagList) {
            NBTTagList nbtl = (NBTTagList) nbt.getTag(Tags.BASE_MATERIALS);
            //nbtl.forEach(x -> materials.add(x.));
        }
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(pos, 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }


}
