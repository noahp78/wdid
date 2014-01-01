package noahp78.mods.wdid.modhelpers;
import ic2.api.item.Items;
import net.minecraft.block.Block;
import noahp78.mods.wdid.wdid;

public class IC2 {
	
	
	public static void InitIC2(){
		if (!(Items.getItem("copperOre") == null)) {
			noahp78.mods.wdid.wdid.RegisterBlockInfo(Block.blocksList[Items.getItem("copperOre").itemID], "Copper is a resource that is used to create various items, the most notable of which are Bronze and Copper Cable. It is found between layers 10 and 70, and usually in groups of up to 10 blocks. Any pickaxe can be used to mine copper.");
			
		}
		
	}
}
