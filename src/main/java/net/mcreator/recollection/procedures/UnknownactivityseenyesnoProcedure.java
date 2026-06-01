package net.mcreator.recollection.procedures;

import net.minecraftforge.eventbus.api.Event;

public class UnknownactivityseenyesnoProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity ) {
if (
entity == null ) return ;
if (==false) {if(entity instanceof ServerPlayer _ent) {
BlockPos _bpos = BlockPos.containing(x,y,z);
NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
@Override public Component getDisplayName() {
return Component.literal("UnknownActivity");
}
@Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
return new UnknownActivityMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
}
}, _bpos);
}
}
}
}