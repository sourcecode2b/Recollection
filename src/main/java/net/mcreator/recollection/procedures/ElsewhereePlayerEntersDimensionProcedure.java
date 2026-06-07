package net.mcreator.recollection.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.recollection.init.RecollectionModItems;

public class ElsewhereePlayerEntersDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(RecollectionModItems.SHARD_OF_A_BROKEN_PORTAL.get()).copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}