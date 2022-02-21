import Administrators.ActionAdministrator;
import model.Action;
import model.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActionAdministratorTest {

    @Test
    void chooseAction_EmptyResources_shouldMineFoo() {
        //GIVEN
        Resources resources = new Resources(0, 0, 0, 0);
        testCondition(resources, Action.MINE_FOO);

        resources = new Resources(0, 4, 2, 2);
        testCondition(resources, Action.MINE_FOO);

        resources = new Resources(3, 4, 2, 3);
        testCondition(resources, Action.MINE_FOO);
    }

    @Test
    void chooseAction_shouldMineBar() {
        //GIVEN
        Resources resources = new Resources(1, 0, 0, 0);
        testCondition(resources, Action.MINE_BAR);

        resources = new Resources(1, 0, 3, 2);
        testCondition(resources, Action.MINE_BAR);
    }

    @Test
    void chooseAction_shouldAssembleFooBar() {
        //GIVEN
        Resources resources = new Resources(1, 1, 0, 0);
        testCondition(resources, Action.ASSEMBLE_FOOBAR);

        resources = new Resources(1, 3, 2, 2);
        testCondition(resources, Action.ASSEMBLE_FOOBAR);
    }

    @Test
    void chooseAction_shouldSell() {
        //GIVEN
        Resources resources = new Resources(0, 0, 5, 0);
        testCondition(resources, Action.SELL_FOOBAR);

        resources = new Resources(0, 5, 5, 2);
        testCondition(resources, Action.SELL_FOOBAR);

    }

    @Test
    void chooseAction_shouldBuyRobot() {
        //GIVEN
        Resources resources = new Resources(6, 0, 0, 3);
        testCondition(resources, Action.BUY_ROBOT);

        //GIVEN
        resources = new Resources(6, 5, 0, 3);
        testCondition(resources, Action.BUY_ROBOT);

    }

    private void testCondition(Resources resources, Action expectedAction){
        //WHEN
        Action action = ActionAdministrator.chooseAction(resources);

        //THEN
        Assertions.assertEquals(expectedAction, action);
    }
}