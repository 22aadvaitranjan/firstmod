package com.aadvaitranjan.firstmod.item.custom;

import com.aadvaitranjan.firstmod.block.modBlocks;
import com.aadvaitranjan.firstmod.item.moditems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class SmartBlowTorchItem extends Item {
    public static final Map<Block, Item>  BLOW_TORCK_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(modBlocks.TITANIUM_BLOCK.get(), modBlocks.TITANIUM_BLOCK.get().asItem().getSmeltingExperience())
                    .put(modBlocks.ORE_TITANIUM.get(), moditems.TITANIUM_INGOT.get().getSmeltingExperience())
                    .put(Blocks.SAND, Blocks.GLASS.asItem())
                    .put(Blocks.DIAMOND_ORE, Items.DIAMOND)
                    .put(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP)
                    .put(Blocks.COAL_ORE, Items.COAL)
                    .put(Blocks.IRON_ORE, Items.IRON_INGOT)
                    .put(Blocks.GOLD_ORE, Items.GOLD_INGOT)
                    .build();
    public SmartBlowTorchItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos postionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(postionClicked).getBlock();
            if(canBlowTorch(blockClicked)){
                ItemEntity entity = new ItemEntity(level,
                postionClicked.getX(), postionClicked.getY(), postionClicked.getZ(),
                        new ItemStack(BLOW_TORCK_ITEM_CRAFT.get(blockClicked), 10));
                level.destroyBlock(postionClicked, true);
                pContext.getItemInHand().hurtAndBreak(64, pContext.getPlayer(), p ->{
                    p.broadcastBreakEvent(pContext.getHand());
                });
            }else {
                pContext.getPlayer().sendMessage(new TextComponent("Blow Torch!!!!!"),
                        Util.NIL_UUID);
            }


        }

        return super.useOn(pContext);


    }
    private boolean canBlowTorch(Block block) {
        return BLOW_TORCK_ITEM_CRAFT.containsKey(block);
    }
}
