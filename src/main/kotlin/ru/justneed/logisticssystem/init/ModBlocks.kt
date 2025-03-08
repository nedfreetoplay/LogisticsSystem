package ru.justneed.logisticssystem.init

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import ru.justneed.logisticssystem.LogisticsSystem
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
import thedarkcolour.kotlinforforge.neoforge.forge.getValue
import java.util.function.Supplier

object ModBlocks {
    val REGISTRY = DeferredRegister.createBlocks(LogisticsSystem.MOD_ID)

    // If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
    val EXAMPLE_BLOCK by registerBlock("example_block", {
        Block(BlockBehaviour.Properties.of()
            .lightLevel { 15 }
            .strength(3.0f)
            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(
                LogisticsSystem.MOD_ID,
                "example_block"
            )))
        )
    })

    private fun <T: Block>registerBlock(name: String, block: Supplier<T>): DeferredBlock<T> {
        val toReturn = REGISTRY.register(name, block)
        registerItemBlock(name, toReturn)
        return toReturn
    }

    private fun <T : Block>registerItemBlock(name: String, block: DeferredBlock<T>) {
        ModItems.REGISTRY.register(
            name, Supplier { BlockItem(block.get(), Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(LogisticsSystem.MOD_ID, name)))
            ) }
        )
    }
}
