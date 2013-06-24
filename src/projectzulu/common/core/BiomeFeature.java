package projectzulu.common.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;

/** Terrain Feature that is Restricted by Biome */
public abstract class BiomeFeature extends BaseFeature {

    protected ArrayList<BiomeGenBase> biomesToSpawn = new ArrayList<BiomeGenBase>();

    public BiomeFeature(String featureName, Size size) {
        super(featureName, size);
    }

    @Override
    public boolean canGenerateHere(World world, int chunkX, int chunkZ, ChunkCoordinates genBlockCoords, Random random) {
        if (super.canGenerateHere(world, chunkX, chunkZ, genBlockCoords, random)) {
            return biomesToSpawn.contains(world.getBiomeGenForCoords(genBlockCoords.posX, genBlockCoords.posZ));
        } else {
            return false;
        }
    }

    protected abstract Collection<String> getDefaultBiomeList();

    @Override
    protected void loadSettings(Configuration config) {
        Collection<String> defaultBiomesToSpawn = getDefaultBiomeList();
        for (int i = 0; i < BiomeGenBase.biomeList.length; i++) {
            if (BiomeGenBase.biomeList[i] == null) {
                continue;
            }
            if (config.get("Mob Spawn Biome Controls." + getFeatureName(),
                    getFeatureName() + " in " + BiomeGenBase.biomeList[i].biomeName,
                    defaultBiomesToSpawn.contains(BiomeGenBase.biomeList[i].biomeName)).getBoolean(false)) {
                biomesToSpawn.add(BiomeGenBase.biomeList[i]);
            }
        }
    }
}
