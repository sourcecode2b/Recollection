package net.mcreator.recollection.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.recollection.RecollectionMod;

public class VoideOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(true, world.getServer());
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.SURVIVAL);
		if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
			ResourceKey<Level> destinationType = Level.OVERWORLD;
			if (_player.level().dimension() == destinationType)
				return;
			ServerLevel nextLevel = _player.server.getLevel(destinationType);
			if (nextLevel != null) {
				_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
				_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
				_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
				for (MobEffectInstance _effectinstance : _player.getActiveEffects())
					_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
				_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
			}
		}
		if (entity instanceof Player _player) {
			_player.getAbilities().invulnerable = true;
			_player.onUpdateAbilities();
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + 70), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + 70), z, _ent.getYRot(), _ent.getXRot());
		}
		RecollectionMod.queueServerWork(10, () -> {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1000);
		});
		RecollectionMod.queueServerWork(20, () -> {
			world.getLevelData().getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set(false, world.getServer());
		});
		RecollectionMod.queueServerWork(900, () -> {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("recollection", "guide1"));
				if (template != null) {
					template.placeInWorld(_serverworld, BlockPos.containing(x, y, z), BlockPos.containing(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		});
	}
}