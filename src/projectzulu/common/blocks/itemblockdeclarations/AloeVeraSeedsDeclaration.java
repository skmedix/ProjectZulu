package projectzulu.common.blocks.itemblockdeclarations;

import projectzulu.common.api.BlockList;
import projectzulu.common.api.ItemList;
import projectzulu.common.blocks.ItemAloeVeraSeeds;
import projectzulu.common.core.itemblockdeclaration.ItemDeclaration;

import com.google.common.base.Optional;

public class AloeVeraSeedsDeclaration extends ItemDeclaration {

    public AloeVeraSeedsDeclaration() {
        super("AloeVeraSeeds", 1);
    }

    @Override
    protected boolean createItem(int iD) {
        if (BlockList.aloeVera.isPresent()) {
            ItemList.aloeVeraSeeds = Optional.of(new ItemAloeVeraSeeds(iD, BlockList.aloeVera.get().blockID, name
                    .toLowerCase()));
            return true;
        }
        return false;
    }

    @Override
    protected void registerItem() {
    }
}
