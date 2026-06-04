package net.mcreator.recollection.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class HeartBlock extends Block {
	public HeartBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.NYLIUM).strength(1.2f, 12f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		HeartBlockDestroyedByPlayerProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}
}