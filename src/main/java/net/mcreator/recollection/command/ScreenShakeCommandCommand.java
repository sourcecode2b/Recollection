package net.mcreator.recollection.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.commands.Commands;
import com.mojang.brigadier.arguments.StringArgumentType; // Make sure this is imported!

import net.mcreator.recollection.procedures.WindowShakeTestCommandProcedure;
import net.mcreator.recollection.procedures.ScreenShakeTestCommandProcedure;
import net.mcreator.recollection.procedures.WindowsMessageBoxTestCommandProcedure;


@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ScreenShakeCommandCommand {

    @SubscribeEvent
    public static void registerCommand(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("recollection")
            .then(Commands.literal("test")
                .then(Commands.literal("screen_shake")
                    .then(Commands.literal("ingame").executes(arguments -> {
                        ScreenShakeTestCommandProcedure.execute();
                        return 0;
                    }))
                    .then(Commands.literal("game_window").executes(arguments -> {
                        WindowShakeTestCommandProcedure.execute();
                        return 0;
                    })))

                .then(Commands.literal("windows_message_box")
                    .then(Commands.argument("windows_message_box", StringArgumentType.word()).executes(arguments -> {
                        WindowsMessageBoxTestCommandProcedure.execute(arguments);
                        return 0;
                    }))
                )
            )
        );
    }
}