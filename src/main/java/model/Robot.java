package model;

import Administrators.IRobotAdministrator;
import Administrators.ResourcesAdministrator;
import Administrators.RobotAdministrator;
import Utils.ProductionLineLogger;
import model.Action;

import java.util.concurrent.atomic.AtomicBoolean;

public class Robot implements Runnable {
    private Thread worker;
    int number;
    IRobotAdministrator robotAdministrator;
    private AtomicBoolean running = new AtomicBoolean(false);

    public Robot(int number, IRobotAdministrator robotAdministrator) {
        this.number = number;
        this.robotAdministrator = robotAdministrator;
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    boolean isRunning() {
        return running.get();
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            ProductionLineLogger.printChooseAction(this, ResourcesAdministrator.getInstance().getResources());
            Action actionToDo = ResourcesAdministrator.getInstance().getAnAction();
            ProductionLineLogger.printAction(this, actionToDo, ResourcesAdministrator.getInstance().getResources());
            takeTimeAndExecuteAction(actionToDo);
        }
    }

    private void takeTimeAndExecuteAction(Action action) {
        try {
            Thread.sleep(action.getRandomTime());
            updateResources(action);
        } catch (InterruptedException e) {
            ProductionLineLogger.robotInterrupted(this);
        }
    }

    private void updateResources(Action actionDone) {
        ResourcesAdministrator resourcesAdministrator = ResourcesAdministrator.getInstance();
        if (actionDone.equals(Action.BUY_ROBOT)) {
            robotAdministrator.buyAndAddRobot();
        } else {
            Resources updatedResources = resourcesAdministrator.updateResources(actionDone.getFinalResources());
            ProductionLineLogger.printExecutedAction(this, actionDone, updatedResources);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "number=" + number +
                '}';
    }
}
