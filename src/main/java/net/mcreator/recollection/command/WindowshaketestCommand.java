package net.mcreator.recollection.command;

@Mod.EventBusSubscriber
public class WindowshaketestCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("windowshaketest")

				.executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();

					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();

					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);

					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					WindowShakeTestCommandProcedure.execute();
					return 0;
				}));
	}

}