package Administrators;

import model.Action;
import model.Resources;

public class ActionAdministrator {

    private ActionAdministrator(){
        throw new IllegalStateException("Utility class");
    }

    public static Action chooseAction(Resources resources) {
        if (resources.getEuros() >= 3 && resources.getFoo() < 6) {
            return Action.MINE_FOO;
        }
        if (resources.getFoobar() >= 5) {
            return Action.SELL_FOOBAR;
        }
        if (resources.getEuros() >= 3 && resources.getFoo() >= 6) {
            return Action.BUY_ROBOT;
        }
        if (resources.getFoo() == 0) {
            return Action.MINE_FOO;
        }
        if (resources.getBar() < 1) {
            return Action.MINE_BAR;
        }
        if (resources.getFoobar() < 5) {
            return Action.ASSEMBLE_FOOBAR;
        }
        return Action.MINE_FOO;
    }
}
