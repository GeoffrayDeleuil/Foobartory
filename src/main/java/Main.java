import Administrators.ResourcesAdministrator;
import Administrators.RobotAdministrator;

public class Main {
    public static void main(String[] args){
        //No need to init this here, but I prefer to do it, to be explicit
        ResourcesAdministrator.getInstance();
        RobotAdministrator robotAdministrator = new RobotAdministrator(2);
        robotAdministrator.launchProductionLine();
    }
}
