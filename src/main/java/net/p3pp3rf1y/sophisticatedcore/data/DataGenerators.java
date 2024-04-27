package net.p3pp3rf1y.sophisticatedcore.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
	private DataGenerators() {}

	public static void gatherData(GatherDataEvent evt) {
		DataGenerator generator = evt.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		generator.addProvider(evt.includeServer(), new SCFluidTagsProvider(packOutput, evt.getLookupProvider(), evt.getExistingFileHelper()));
		generator.addProvider(evt.includeServer(), new SCRecipeProvider(packOutput));
	}
}
