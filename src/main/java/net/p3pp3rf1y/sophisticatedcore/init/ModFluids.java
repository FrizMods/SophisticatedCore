package net.p3pp3rf1y.sophisticatedcore.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.p3pp3rf1y.sophisticatedcore.SophisticatedCore;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModFluids {
	private ModFluids() {
	}

	private static BaseFlowingFluid.Properties fluidProperties() {
		return new BaseFlowingFluid.Properties(XP_FLUID_TYPE, XP_STILL, XP_FLOWING);
	}

	public static final ResourceLocation EXPERIENCE_TAG_NAME = new ResourceLocation("forge:experience");

	public static final TagKey<Fluid> EXPERIENCE_TAG = TagKey.create(Registries.FLUID, EXPERIENCE_TAG_NAME);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, SophisticatedCore.MOD_ID);

	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, SophisticatedCore.MOD_ID);
	public static final Supplier<FlowingFluid> XP_STILL = FLUIDS.register("xp_still", () -> new BaseFlowingFluid.Source(fluidProperties()));

	public static final Supplier<FlowingFluid> XP_FLOWING = FLUIDS.register("xp_flowing", () -> new BaseFlowingFluid.Flowing(fluidProperties()));
	public static final Supplier<FluidType> XP_FLUID_TYPE = FLUID_TYPES.register("experience", () -> new FluidType(FluidType.Properties.create().lightLevel(10).density(800).viscosity(1500)) {
		@Override
		public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
			consumer.accept(new IClientFluidTypeExtensions() {
				private static final ResourceLocation XP_STILL_TEXTURE = new ResourceLocation(SophisticatedCore.MOD_ID, "block/xp_still");
				private static final ResourceLocation XP_FLOWING_TEXTURE = new ResourceLocation(SophisticatedCore.MOD_ID, "block/xp_flowing");

				@Override
				public ResourceLocation getStillTexture() {
					return XP_STILL_TEXTURE;
				}

				@Override
				public ResourceLocation getFlowingTexture() {
					return XP_FLOWING_TEXTURE;
				}
			});
		}
	});

	public static void registerHandlers(IEventBus modBus) {
		FLUIDS.register(modBus);
		FLUID_TYPES.register(modBus);
	}
}
