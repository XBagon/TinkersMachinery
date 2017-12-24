package xbagon.timac.blocks;

import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xbagon.timac.ModItems;
import xbagon.timac.TinkersMachinery;
import xbagon.timac.entities.TinkersFurnaceTileEntity;

@Mod.EventBusSubscriber
public class TinkersFurnaceBlock extends BlockFurnace{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    boolean shouldDrop = true;

    public TinkersFurnaceBlock(){
        super(false);

        blockHardness = 1f;
        setUnlocalizedName(TinkersMachinery.MOD_ID + ".furnace_block");
        setRegistryName("furnace_block");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TinkersFurnaceTileEntity();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if(shouldDrop) {
            ItemStack itemstack = new ItemStack(Item.getItemFromBlock(this));
            ItemStack toDrop = new ItemStack(ModItems.TINKERS_FURNACE);
            toDrop.setTagCompound(worldIn.getTileEntity(pos).getUpdateTag().getCompoundTag("ForgeData").getCompoundTag("ItemNBT"));
            spawnAsEntity(worldIn, pos, toDrop);
        }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
       shouldDrop = !player.capabilities.isCreativeMode;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        //ModelLoader.setCustomStateMapper(ModBlocks.TINKERS_FURNACE_BLOCK,);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

    }
}