package net.p3pp3rf1y.sophisticatedcore.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;

public class DataGenerators {
	private DataGenerators() {}

	public static void gatherData(GatherDataEvent evt) {
		DataGenerator generator = evt.getGenerator();
		generator.addProvider(evt.includeServer(), new SCFluidTagsProvider(generator, evt.getExistingFileHelper()));
		generator.addProvider(evt.includeServer(), new SCRecipeProvider(generator));
	}
}
