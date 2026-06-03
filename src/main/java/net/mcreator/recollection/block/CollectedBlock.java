package net.mcreator.recollection.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CollectedBlock extends Block {
	public CollectedBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WART_BLOCK).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}