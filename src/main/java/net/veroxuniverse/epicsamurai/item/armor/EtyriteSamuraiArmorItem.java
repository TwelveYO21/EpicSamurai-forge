package net.veroxuniverse.epicsamurai.item.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.eldrithcend.EtyriteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.epicsamurai.registry.ArmorMaterialsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class EtyriteSamuraiArmorItem extends SamuraiArmorItem {

    public EtyriteSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private EtyriteSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new EtyriteSamuraiArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }
    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_NETHERITE;
    }

}