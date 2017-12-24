package xbagon.timac.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.TinkerToolCore;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.library.utils.TooltipBuilder;
import xbagon.timac.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TinkersFurnace extends TinkerToolCore{

    static Block block = ModBlocks.TINKERS_FURNACE_BLOCK;


    public TinkersFurnace(){
        super(new PartMaterialType(ModToolParts.CASING_PART, CasingStats.TYPE));

        addCategory(new Category("Machine"));

        setUnlocalizedName(TinkersMachinery.MOD_ID + ".furnace").setRegistryName("furnace");
    }

    @Override
    public FurnaceNBT buildTagData(List<Material> materials) {

        FurnaceNBT nbt = new FurnaceNBT();

        nbt.casing(materials.get(0).getStatsOrUnknown(CasingStats.TYPE));

        return nbt;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (!block.isReplaceable(worldIn, pos))
        {
            pos = pos.offset(facing);
        }

        ItemStack itemstack = player.getHeldItem(hand);

        if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(this.block, pos, false, facing, (Entity)null))
        {
            int i = this.getMetadata(itemstack.getMetadata());
            IBlockState iblockstate1 = this.block.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, player, hand);

            if (placeBlockAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1))
            {
                iblockstate1 = worldIn.getBlockState(pos);
                SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, player);
                worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
                itemstack.shrink(1);
            }

            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
//        pos = pos.offset(facing);
//        ItemStack itemstack = player.getHeldItem(hand);
//
//        if (!player.canPlayerEdit(pos, facing, itemstack))
//        {
//            return EnumActionResult.FAIL;
//        }
//        else
//        {
//            if (worldIn.mayPlace(ModBlocks.TINKERS_FURNACE_BLOCK,pos,false,facing,null))
//            {
//                int i = this.getMetadata(itemstack.getMetadata());
//                worldIn.setBlockState(pos, ModBlocks.TINKERS_FURNACE_BLOCK.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, player, hand));
//
//                TileEntity tileEntity = worldIn.getTileEntity(pos);
//                if(tileEntity instanceof TinkersFurnaceTileEntity){
//                    TinkersFurnaceTileEntity furnaceEntity = (TinkersFurnaceTileEntity) tileEntity;
//                    int cookTime = ((NBTTagCompound) itemstack.getTagCompound().getTag("StatsOriginal")).getInteger("TinkersMachinerycookSpeed");
//                    if(cookTime == 0) cookTime = 200;
//                    furnaceEntity.setCookTime(cookTime);
//                }
//            }
//
////            if (player instanceof EntityPlayerMP)
////            {
////                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
////            }
//
//            itemstack.setCount(0);
//            return EnumActionResult.SUCCESS;
//        }
    }

    @Override
    public int[] getRepairParts() {
			return new int[] {0,1};
    }

    @Override
    public float damagePotential() {
        return 0;
    }

    @Override
    public double attackSpeed() {
        return 0;
    }

    @Override
    public void getTooltipDetailed(ItemStack stack, List<String> tooltips) {
        super.getTooltipDetailed(stack,tooltips);
    }

    @Override
    public void getTooltipComponents(ItemStack stack, List<String> tooltips) {
        super.getTooltipComponents(stack,tooltips);
    }

    @Override
    public void getTooltip(ItemStack stack, List<String> tooltips) {
        super.getTooltip(stack, tooltips);
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState)
    {
        if (!world.setBlockState(pos, newState, 11)) return false;

        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == this.block)
        {
            setTileEntityNBT(world, player, pos, stack);
            this.block.onBlockPlacedBy(world, pos, state, player, stack);

            if (player instanceof EntityPlayerMP)
                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, stack);
        }

        return true;
    }

    public static boolean setTileEntityNBT(World worldIn, @Nullable EntityPlayer player, BlockPos pos, ItemStack stackIn) {

        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity != null) {
            if (!worldIn.isRemote && tileentity.onlyOpsCanSetNbt() && (player == null || !player.canUseCommandBlock())) {
                return false;
            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound temp = stackIn.getSubCompound("StatsOriginal");
            if(temp != null) nbttagcompound.setTag("StatsOriginal", temp);
            temp = stackIn.getSubCompound("Stats");
            if(temp != null) nbttagcompound.setTag("Stats", temp);
            temp = stackIn.getSubCompound("Special");
            if(temp != null) nbttagcompound.setTag("Special", temp);
            temp = stackIn.getSubCompound("TinkerData");
            if(temp != null) nbttagcompound.setTag("TinkerData", temp);
            temp = stackIn.getSubCompound("Modifiers");
            if(temp != null) nbttagcompound.setTag("Modifiers", temp);
            temp = stackIn.getSubCompound("Traits");
            if(temp != null) nbttagcompound.setTag("Traits", temp);

            tileentity.getTileData().setTag("ItemNBT",nbttagcompound);

            return true;
        }
        return false;
    }

    @Override
    public List<String> getInformation(ItemStack stack, boolean detailed) {
        TooltipBuilder info = new TooltipBuilder(stack);
        info.add(String.format("%s: %.2f", I18n.format("stat.furnace.cookingspeed.name"), TagUtil.getToolTag(stack).getFloat("CookSpeed")));

        if(ToolHelper.getFreeModifiers(stack) > 0) {
            info.addFreeModifiers();
        }

        if(detailed) {
            info.addModifierInfo();
        }

        return info.getTooltip();
    }

    @Nonnull
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(@Nonnull EntityEquipmentSlot slot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();

        //multimap.put("Cook Speed", new AttributeModifier("cookSpeed", TagUtil.getToolTag(stack).getFloat("CookSpeed"), 0));

        NBTTagList traitsTagList = TagUtil.getTraitsTagList(stack);
        for(int i = 0; i < traitsTagList.tagCount(); i++) {
            ITrait trait = TinkerRegistry.getTrait(traitsTagList.getStringTagAt(i));
            if(trait != null) {
                trait.getAttributeModifiers(slot, stack, multimap);
            }
        }

        return multimap;
    }
}
