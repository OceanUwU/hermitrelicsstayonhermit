package patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import java.util.ArrayList;



@SpirePatch(
    clz=AbstractDungeon.class,
    method="initializeRelicList"
)
public class RemoveHermitRelics {
    public static String hermitRelics[] = { "hermit:BloodyTooth", "hermit:BrassTacks", "hermit:Horseshoe" };
        
    @SpireInsertPatch(
        rloc=8,
        localvars={"tmp"}
    )
    public static void Prefix(AbstractDungeon __instance) {
        if (AbstractDungeon.player.chosenClass.name() != "HERMIT") {
            for (String i : hermitRelics) {
                AbstractDungeon.relicsToRemoveOnStart.add(i);
            }
        }
    }
}