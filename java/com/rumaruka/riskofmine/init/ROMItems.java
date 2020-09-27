package com.rumaruka.riskofmine.init;

import com.google.common.base.Strings;
import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.api.EnumType;
import com.rumaruka.riskofmine.common.item.ItemTypesThings;
import com.rumaruka.riskofmine.common.item.common.ItemArmorPiercingRounds;
import com.rumaruka.riskofmine.common.item.common.ItemBustlingFungus;
import com.rumaruka.riskofmine.common.item.common.ItemMonsterTooth;
import com.rumaruka.riskofmine.common.item.lunar.ItemShapedGlass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ROMItems {


    //Common TODO:make all things
    public static Item armor_piercing_rounds;
    public static Item bustling_fungus;
    public static Item cautious_slug;
    public static Item monster_tooth;

    //Lunar
    public static Item shaped_glass;

    public static void init(){
        armor_piercing_rounds = new ItemArmorPiercingRounds();
        bustling_fungus = new ItemBustlingFungus();
        cautious_slug = new ItemTypesThings("cautious_slug",  EnumType.COMMON);
        monster_tooth = new ItemMonsterTooth();
        shaped_glass = new ItemShapedGlass();

    }



    public static void setup(){
        registerItem(armor_piercing_rounds,armor_piercing_rounds.getUnlocalizedName().substring(5));
        registerItem(bustling_fungus,bustling_fungus.getUnlocalizedName().substring(5));
        registerItem(cautious_slug,cautious_slug.getUnlocalizedName().substring(5));
        registerItem(monster_tooth,monster_tooth.getUnlocalizedName().substring(5));
        registerItem(shaped_glass,shaped_glass.getUnlocalizedName().substring(5));
    }


    @Deprecated
    public static void registerItem(Item item, String name)
    {
        if (item.getRegistryName() == null && Strings.isNullOrEmpty(name))
            throw new IllegalArgumentException("Attempted to register a item with no name: " + item);
        if (item.getRegistryName() != null && !item.getRegistryName().toString().equals(name))
            throw new IllegalArgumentException("Attempted to register a item with conflicting names. Old: " + item.getRegistryName() + " New: " + name);
        ForgeRegistries.ITEMS.register(item.getRegistryName() == null ? item.setRegistryName(name) : item);
    }

    public static void render(){

        renderItems(armor_piercing_rounds);
        renderItems(bustling_fungus);
        renderItems(cautious_slug);
        renderItems(monster_tooth);
        renderItems(shaped_glass);


    }



    public static void renderItems(Item i){

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(
                RiskOfMine.MODID + ":" + i.getUnlocalizedName().substring(5), "inventory"));

    }




}
