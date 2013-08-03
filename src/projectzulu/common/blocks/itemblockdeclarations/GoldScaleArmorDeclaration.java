package projectzulu.common.blocks.itemblockdeclarations;

import net.minecraft.item.Item;
import projectzulu.common.ProjectZulu_Core;
import projectzulu.common.api.ItemList;
import projectzulu.common.blocks.ItemZuluArmor;
import projectzulu.common.core.itemblockdeclaration.ItemSetDeclaration;

import com.google.common.base.Optional;

public class GoldScaleArmorDeclaration extends ItemSetDeclaration {

    public final int renderIndex;

    public GoldScaleArmorDeclaration(int renderIndex) {
        super(new String[] { "GoldScaleHelmet", "GoldScaleChest", "GoldScaleLegs", "GoldScaleBoots" });
        this.renderIndex = renderIndex;
    }

    @Override
    protected boolean createItem(int iD, int partIndex) {
        Item item = new ItemZuluArmor(iD, ProjectZulu_Core.goldScaleMaterial, renderIndex, partIndex,
                name[partIndex].toLowerCase());

        switch (partIndex) {
        case 0:
            ItemList.goldScaleArmorHead = Optional.of(item);
            return true;
        case 1:
            ItemList.goldScaleArmorChest = Optional.of(item);
            return true;
        case 2:
            ItemList.goldScaleArmorLeg = Optional.of(item);
            return true;
        case 3:
            ItemList.goldScaleArmorBoots = Optional.of(item);
            return true;
        }
        return false;
    }

    @Override
    protected void registerItem(int partIndex) {
    }
}
