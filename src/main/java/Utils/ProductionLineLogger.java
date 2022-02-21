package Utils;

import model.Action;
import model.Resources;
import model.Robot;

import java.util.logging.Logger;

public class ProductionLineLogger {
    private static Logger LOGGER = Logger.getLogger(ProductionLineLogger.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT %1$tL]  %5$s %n");
        LOGGER = Logger.getLogger(ProductionLineLogger.class.getName());
    }

    private ProductionLineLogger() {
        throw new IllegalStateException("Utility class");
    }

    public static void printAction(Robot robot, Action action, Resources resource) {
        LOGGER.info(resource.toString() + "\t" + robot.toString() + " is executing action " + action.getActionName());
    }

    public static void printExecutedAction(Robot robot, Action action, Resources resource) {
        LOGGER.info(resource.toString() + "\t" + robot.toString() + " has executed action " + action.getActionName());
    }

    public static void printChooseAction(Robot robot, Resources resource) {
        LOGGER.info(resource.toString() + "\t" + robot.toString() + " is asking for action ");
    }

    public static void printAssembleFoobarResult(boolean isSuccess) {
        if (isSuccess) {
            LOGGER.info("Assemle Foobar SUCCESS");
        } else {
            LOGGER.info("Assemle Foobar FAILURE");

        }
    }

    public static void printBuyRobot(int nbRobots) {
        LOGGER.info("New Robot bought, " + nbRobots + " robots availables");
    }

    public static void endOfProduction(long elapsedTime) {
        LOGGER.info("\n**************************************************************************\n " +
                "***** END OF PRODUCTION, WE TOOK CONTROL OF THE MARKET IN " + elapsedTime * 100 + "s *****\n"
                + "**************************************************************************\n ");
    }

    public static void robotInterrupted(Robot robot) {
        LOGGER.info("****  " + robot.toString() + " was interrupted when finishing his job  ****");
    }
}
