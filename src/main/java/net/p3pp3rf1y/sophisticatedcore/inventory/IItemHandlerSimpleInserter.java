package net.p3pp3rf1y.sophisticatedcore.inventory;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public interface IItemHandlerSimpleInserter extends IItemHandlerModifiable {
	ItemStack insertItem(ItemStack stack, boolean simulate);
}
