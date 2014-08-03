package wasliecore.handlers.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import wasliecore.misc.items.ItemSwordCheat;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OnEntityDamageEvent {
	@SubscribeEvent
	public void onEntityDamage(LivingHurtEvent e){
		EntityLivingBase living = (EntityLivingBase)e.entityLiving;
		if(!(living instanceof EntityPlayer)){
			if(e.source.getSourceOfDamage() instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.source.getSourceOfDamage();
				if(player.getHeldItem().getItem() instanceof ItemSwordCheat){
					living.onDeath(e.source);
					living.setDead();
				}
			}
		}
	}
}