package projectzulu.experimental.defaultentities;

import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraftforge.common.Configuration;

import org.lwjgl.util.Point;

import projectzulu.common.ProjectZulu_Mobs;

public abstract class DefaultWithEgg extends DefaultCreature{

	int eggColor1;
	int eggColor2;
	
	protected DefaultWithEgg(String mobName, Class mobClass) {
		super(mobName, mobClass);
	}
	
	@Override
	public void loadCreatureFromConfig(Configuration config) {
		super.loadCreatureFromConfig(config);
		eggColor1 = config.get("MOB CONTROLS."+mobName, mobName.toLowerCase()+" EggColor1", eggColor1).getInt(eggColor1);
		eggColor2 = config.get("MOB CONTROLS."+mobName, mobName.toLowerCase()+" EggColor2", eggColor2).getInt(eggColor2);
	}
	
	@Override
	public void registerEgg() {
		super.registerEgg();
		int eggID = ProjectZulu_Mobs.getNextDefaultEggID();
		while(EntityList.IDtoClassMapping.containsKey(eggID)){ eggID = ProjectZulu_Mobs.getNextDefaultEggID(); }
		EntityList.IDtoClassMapping.put(eggID, mobClass); 
		EntityList.entityEggs.put(eggID, new EntityEggInfo(eggID, eggColor1, eggColor2 ));
	}
}