package ru.justneed.logisticssystem.init

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredRegister
import ru.justneed.logisticssystem.LogisticsSystem
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val REGISTRY = DeferredRegister.createItems(LogisticsSystem.MOD_ID)

    val TEST_ITEM by REGISTRY.registerItem(
        "test_item",
        ::Item,
        Item.Properties()
            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(
                LogisticsSystem.MOD_ID, "test_item"
            )))
    )
}