package net.mcreator.recollection.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ShardOfABrokenPortalItem extends Item {
	public ShardOfABrokenPortalItem() {
		super(new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.recollection.shard_of_a_broken_portal.description_0"));
		list.add(Component.translatable("item.recollection.shard_of_a_broken_portal.description_1"));
	}
}