package Administrators;

import Utils.ProductionLineLogger;
import model.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotAdministrator {

    private int nbRobots;
    private List<Robot> robots;
    long start;

    public RobotAdministrator(int nbRobots) {
        this.nbRobots = nbRobots;
        robots = new ArrayList<>();
    }

    public void launchProductionLine() {
        start = System.currentTimeMillis();
        launchRobots();
    }

    public void launchRobots() {
        for (int i = 1; i <= nbRobots; i++) {
            addRobotToProductionLine(i);
        }
    }

    private void addRobotToProductionLine(int robotNumber) {
        Robot robot = new Robot(robotNumber, this);
        robots.add(robot);
        robot.start();
    }

    public synchronized void buyAndAddRobot() {
        nbRobots++;
        ProductionLineLogger.printBuyRobot(nbRobots);
        if (nbRobots < 30) {
            addRobotToProductionLine(nbRobots);
        } else {
            stopProductionLine();
        }
    }

    private void stopProductionLine() {
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        stopRobots();
        ProductionLineLogger.endOfProduction(timeElapsed);
        System.exit(0);
    }

    private void stopRobots() {
        for (Robot robot : robots) {
            robot.interrupt();
        }
    }
}
