package caractions;

import java.util.HashMap;
import java.util.Map;

public class ActionManager {
    private static Map<String, CarAction> actionMap = new HashMap<>();
    static{
        actionMap.put("drive", new DriveAction());
        actionMap.put("explode", new ExplodeAction());
    }
    public static CarAction getActionByName(String actionName){
        return actionMap.get(actionName);
    }
}
