package com.unoriginal.ancientbeasts.proxy;

import com.unoriginal.ancientbeasts.init.ModEntities;
import com.unoriginal.ancientbeasts.init.ModItems;
import com.unoriginal.ancientbeasts.init.ModParticles;
import com.unoriginal.ancientbeasts.items.models.ModelScaleArmor;
import com.unoriginal.ancientbeasts.particles.ParticleSandSpit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    private final ModelBiped MODEL_SCALE_ARMOR = new ModelScaleArmor(0.5F);

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModEntities.initModels();
    }
    @Override
    public void registerParticles() {
        Minecraft.getMinecraft().effectRenderer.registerParticle(ModParticles.SAND_SPIT.getParticleID(), new ParticleSandSpit.Factory());
    }
    @Override
    public Object getArmorModel(Item item, EntityLivingBase entity) {
        if(item == ModItems.SCALE_ARMOR || item == ModItems.SCALE_HOOD){
            return MODEL_SCALE_ARMOR;
        }
        return null;
    }

}
