package de.gurknator.items;

import de.gurknator.AugmentaCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final RegistryKey<ItemGroup> CUSTOM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AugmentaCraft.MOD_ID, "augmenta_group"));
    public static final ItemGroup CUSTOM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.RAW_TITAN))
            .displayName(Text.translatable("itemGroup.augmentacraft"))
            .build();

    public static final Item RAW_TITAN = register(new Item(new Item.Settings()), "raw_titan");
    public static final Item TITAN_INGOT = register(new Item(new Item.Settings()), "titan_ingot");

    public static Item register(Item item, String id) {
        Identifier identifier = Identifier.of(AugmentaCraft.MOD_ID, id);
        return Registry.register(Registries.ITEM, identifier, item);
    }

    public static void initialize() {
        //add items to custom group
        Registry.register(Registries.ITEM_GROUP, CUSTOM_GROUP_KEY, CUSTOM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_GROUP_KEY).register(group -> {
                group.add(RAW_TITAN);
                group.add(TITAN_INGOT);
            }
        );
    }
}
