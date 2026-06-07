package net.mcreator.recollection.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class SteveOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() > 0.93) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
			entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(x, y, z));
			if (Math.random() > 0.5) {
				entity.setCustomName(Component.literal("\u20B4\u20AE\u0246V\u0246"));
			} else {
				entity.setCustomName(Component.literal(
						"S\u0347\u031D\u0330\u030F\u0322\u034A\u032F\u0350\u035D\u030E\u031F\u0305\u034E\u032E\u030F\u0358\u0314\u032E\u0363\u036A\u0332\u033B_\u0334\u0365t\u035B\u031A\u0365\u0302\u034B\u0333\u036C\u0312\u031F\u036D\u0300\u0325\u031F\u0339\u0314\u030D\u030F\u032B\u036B\u0367\u0316\u036B\u0337\u033A\u032A\u0361\u0300\u0356\u0353e\u0302\u0354\u0368\u0362\u0333\u0361\u0353\u0336\u0346\u0326\u033F\u031D\u033E\u0330\u032D\u0364\u0316\u0301v\u0336\u0301\u030F\u035A\u032F\u031E\u0337\u0363_\u0332\u032A\u0313\u0300\u0367\u0300\u033D\u0300\u032C\u0300\u031C\u0333\u032A\u036C\u0300\u036E\u0361\u030B\u0347\u0305\u0339\u0301\u036D\u0318\u031E\u036A\u030F\u0359\u030E\u0309\u032E\u0347e\u0318\u034B\u0354\u0342\u0322\u0335\u0357\u031B\u0342\u035F\u033B\u031E\u0308\u0352\u0336\u0329\u0363\u0304\u031D\u0346\u030F\u0334\u0361\u0329\u0368\u0306\u0328\u032F\u0366\u0362_\u0334\u0347\u034A\u033A\u0359\u032A\u0313\u0301\u0324\u0317\u0310"));
			}
		}
	}
}