package net.mobz.Items.Armor;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class ArmorBase2 extends ArmorItem {
    double a = 3.0D;
    private static final UUID[] MODIFIERS = new UUID[] { UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
            UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
            UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
            UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150") };

    public ArmorBase2(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Item.Settings());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mobz.life_armor.tooltip"));
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getModifiers(EquipmentSlot equipmentSlot_1) {
        Multimap<String, EntityAttributeModifier> multimap_1 = super.getModifiers(equipmentSlot_1);
        if (equipmentSlot_1 == this.slot) {
            multimap_1.put(EntityAttributes.MAX_HEALTH.getId(),
                    new EntityAttributeModifier(MODIFIERS[equipmentSlot_1.getEntitySlotId()], "Life", (double) this.a,
                            EntityAttributeModifier.Operation.ADDITION));

        }

        return multimap_1;
    }
}
