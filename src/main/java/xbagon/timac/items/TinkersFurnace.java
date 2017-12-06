package xbagon.timac.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.tools.TinkerTools;
import xbagon.timac.CasingStats;
import xbagon.timac.ModBlocks;
import xbagon.timac.ModToolParts;
import xbagon.timac.TinkersMachinery;
import xbagon.timac.blocks.TinkersFurnaceBlock;
import xbagon.timac.entities.TinkersFurnaceTileEntity;

import java.util.List;

public class TinkersFurnace extends ToolCore {


    public TinkersFurnace(){
        super(PartMaterialType.head(ModToolParts.CASING_PART),PartMaterialType.extra(TinkerTools.largePlate));

        addCategory(Category.TOOL);

        setUnlocalizedName(TinkersMachinery.MOD_ID + ".furnace").setRegistryName("furnace");
    }

    @Override
    public NBTTagCompound buildTag(List<Material> materials) {
        CasingStats head = materials.get(0).getStatsOrUnknown("casing");
        ExtraMaterialStats extra = materials.get(1).getStatsOrUnknown(MaterialTypes.EXTRA);

        NBTTagCompound nbt = new NBTTagCompound();
        if(head != null) nbt.setInteger("TinkersMachinerycookSpeed",head.heatResistance);


        return nbt;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos, facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            EnumFacing placeSide = player.getHorizontalFacing().getOpposite();
            if (worldIn.mayPlace(ModBlocks.TINKERS_FURNACE_BLOCK,pos,false,placeSide,player))
            {
                worldIn.setBlockState(pos, ModBlocks.TINKERS_FURNACE_BLOCK.getDefaultState().withProperty(TinkersFurnaceBlock.FACING,placeSide));

                TileEntity tileEntity = worldIn.getTileEntity(pos);
                if(tileEntity instanceof TinkersFurnaceTileEntity){
                    TinkersFurnaceTileEntity furnaceEntity = (TinkersFurnaceTileEntity) tileEntity;
                    int cookTime = ((NBTTagCompound) itemstack.getTagCompound().getTag("StatsOriginal")).getInteger("TinkersMachinerycookSpeed");
                    if(cookTime == 0) cookTime = 200;
                    furnaceEntity.setCookTime(cookTime);
                }
            }

//            if (player instanceof EntityPlayerMP)
//            {
//                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, pos, itemstack);
//            }

            itemstack.setCount(0);
            return EnumActionResult.SUCCESS;
        }
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

    }

    @Override
    public void getTooltipComponents(ItemStack stack, List<String> tooltips) {

    }

    @Override
    public void getTooltip(ItemStack stack, List<String> tooltips) {
        super.getTooltip(stack, tooltips);
    }


}
