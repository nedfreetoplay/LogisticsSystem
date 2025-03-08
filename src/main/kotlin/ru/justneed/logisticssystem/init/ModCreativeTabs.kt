package ru.justneed.logisticssystem.init

import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import ru.justneed.logisticssystem.LogisticsSystem
import java.util.function.Supplier

object ModCreativeTabs {
    val REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LogisticsSystem.MOD_ID)

    val MAIN_CREATIVE_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = REGISTRY.register(
        "main_creative_tab", Supplier
        {
            CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 1)
                .icon({ ItemStack(Items.APPLE) })
                .title(Component.translatable("itemGroup.logisticssystem.main_creative_tab"))
                .displayItems({ parametrs, output ->
                    output.accept(Items.APPLE)
                })
                .build()
        }
    )
}