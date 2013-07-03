package projectzulu.common.mobs.entitydefaults;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.Configuration;
import projectzulu.common.api.CustomMobData;
import projectzulu.common.core.DefaultProps;
import projectzulu.common.core.entitydeclaration.CreatureDeclaration;
import projectzulu.common.mobs.entity.EntityFollower;
import projectzulu.common.mobs.models.ModelElephant;
import projectzulu.common.mobs.models.ModelFollower;
import projectzulu.common.mobs.renders.RenderGenericLiving;

public class FollowerDeclaration extends CreatureDeclaration{

	public FollowerDeclaration(){
		super("Follower", EntityFollower.class, null);		
		setRegistrationProperties(128, 3, true);
	}
	
	@Override
	public void loadCreaturesFromConfig(Configuration config) {}
	
	@Override
	public void outputDataToList(Configuration config, CustomMobData customMobData) {}
	
    @Override
    @SideOnly(Side.CLIENT)
    public RenderLiving getEntityrender(Class<? extends EntityLivingBase> entityClass) {
        return new RenderGenericLiving(new ModelFollower(), 0.5f, DefaultProps.mobDiretory + "serpent.png");
    }
}
