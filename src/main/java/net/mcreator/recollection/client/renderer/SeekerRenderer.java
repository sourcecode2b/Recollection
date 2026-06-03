package net.mcreator.recollection.client.renderer;

public class SeekerRenderer extends MobRenderer<SeekerEntity, Modelseeker<SeekerEntity>> {
	public SeekerRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelseeker.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SeekerEntity entity) {
		return ResourceLocation.parse("recollection:textures/entities/seekerpng.png");
	}

	private static final class AnimatedModel extends Modelseeker<SeekerEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<SeekerEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(SeekerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, seekerAnimation.idle, ageInTicks, 1f);
				this.animateWalk(seekerAnimation.running, limbSwing, limbSwingAmount, 1f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(SeekerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}