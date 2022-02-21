package Administrators;

import model.Action;
import model.Resources;

public final class ResourcesAdministrator {

    private static ResourcesAdministrator INSTANCE;
    private Resources resources;

    private ResourcesAdministrator() {
        resources = new Resources(0, 0, 0, 0);
    }

    public static synchronized ResourcesAdministrator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResourcesAdministrator();
        }
        return INSTANCE;
    }

    public synchronized Action getAnAction() {
        Action action = ActionAdministrator.chooseAction(getResources());
        if (action.getNeededResources() != null) {
            updateResources(action.getNeededResources());
        }
        return action;
    }

    public synchronized Resources getResources() {
        return resources;
    }

    public Resources updateResources(Resources newResources) {
        return getResources().updateResources(newResources);
    }
}
