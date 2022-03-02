package Administrators;

import model.Action;
import model.Resources;

public interface IResourcesAdministrator {
    public Action getAnAction();
    public Resources getResources();
    public Resources updateResources(Resources newResources);
}
