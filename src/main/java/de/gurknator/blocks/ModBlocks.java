package de.gurknator.blocks;

import de.gurknator.AugmentaCraft;
import de.gurknator.items.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block DEEPSLATE_TITAN_ORE = register(new Block(AbstractBlock.Settings.create()
            .resistance(1200f)
            .hardness(9f)
            .requiresTool()
            .sounds(BlockSoundGroup.DEEPSLATE)),
            "deepslate_titan_ore"
    );
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(AugmentaCraft.MOD_ID, name);
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);

    }
    public static Block register(Block block, String name) {
        return register(block, name, true);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.DEEPSLATE_TITAN_ORE.asItem());
        });
    }
}
