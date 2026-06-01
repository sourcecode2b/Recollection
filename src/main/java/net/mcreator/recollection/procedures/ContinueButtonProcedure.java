package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ContinueButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}