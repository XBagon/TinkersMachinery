package xbagon.timac;

import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tools.ToolPart;

public class CasingPart extends ToolPart{
    public CasingPart() {
        super(Material.VALUE_Ingot*4);
        setUnlocalizedName(TinkersMachinery.MOD_ID + ".casing").setRegistryName("casing");

    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        return super.getAttributeModifiers(slot, stack);
    }
}
