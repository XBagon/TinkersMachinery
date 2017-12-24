package xbagon.timac;

import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.Tags;

public class FurnaceNBT extends ToolNBT{
    public static final String TAG_COOK_SPEED = "CookSpeed";

    public float cookSpeed;
    public float hardness;
    public float efficency;
    public float isolation;
    public int modifiers;

    public FurnaceNBT() {
        modifiers = 3;
    }

    public FurnaceNBT(NBTTagCompound nbt) {
        super(nbt);
    }

    public FurnaceNBT casing(CasingStats stats){
        cookSpeed = stats.heatResistance;
        return this;
    }

    @Override
    public void read(NBTTagCompound tag) {
        tag.getFloat(TAG_COOK_SPEED);
        tag.getInteger(Tags.FREE_MODIFIERS);
    }

    @Override
    public void write(NBTTagCompound tag) {
        tag.setFloat(TAG_COOK_SPEED,cookSpeed);
        tag.setInteger(Tags.FREE_MODIFIERS,modifiers);
    }
}
