package item;
import com.github.darkcat974.workshop_modMinecraft.My_package;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.tools.nsc.backend.icode.Members;

import java.util.ArrayList;
import static net.minecraft.client.util.SearchTreeManager.ITEMS;

@Mod.EventBusSubscriber(value =  Side.CLIENT, modid = My_package.MODID)
public class ModidItems {
    public static final ArrayList<Item> ITEMS = new ArrayList<>();
    public static void setItemName ( Item item , String name ) {
        item.setRegistryName(My_package.MODID , name ).setUnlocalizedName(My_package.MODID
                + "." + name);
        ITEMS.add(item);
    }
    public static void setItemBlockName ( Item item , Block block ) {
        item.setRegistryName(block.getRegistryName());
        ITEMS.add(item);
    }
    @SideOnly(Side.CLIENT) // Forge annotation for Side managing
    @SubscribeEvent // Forge annotation to subscribe to an event
    protected static void registerItemModels ( ModelRegistryEvent e ) {
        ITEMS.forEach(item->registerModel(item, 0) ); //A simple forEach to call the
        Members.IMethod below;
    }
    @SideOnly ( Side . CLIENT )
    protected static void registerModel ( Item item , int metadata ) {
        ModelLoader. setCustomModelResourceLocation (item, metadata , new
                ModelResourceLocation( item.getRegistryName(), " inventory ") ) ;
    }
}
