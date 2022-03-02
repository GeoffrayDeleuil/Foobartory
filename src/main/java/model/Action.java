package model;

import Utils.ProductionLineLogger;

import java.util.Random;

public enum Action {
    MINE_FOO("Mine Foo", 10, 10, new Resources(0,0,0,0),new Resources(1, 0, 0, 0)),

    MINE_BAR("Mine Bar", 5, 20, new Resources(0,0,0,0), new Resources(0,1,0,0)) {
    },
    ASSEMBLE_FOOBAR("Assemble Foobar",20, 20, new Resources(-1,-1,0,0), getResultResources()) {
    },
    SELL_FOOBAR("Sell Foobar", 100, 100, new Resources(0, 0, -5, 0), new Resources(0, 0, 0, 5)) {
    },
    BUY_ROBOT("Buy Robot", 0, 0, new Resources(-6, 0, 0, -3), null) {
    };

    private final String name;
    private final int timeMin;
    private final int timeMax;
    private final Resources neededResources;
    private final Resources finalResources;


    Action(String name, int timeMin, int timeMax, Resources neededResources, Resources finalResources) {
        this.name = name;
        this.timeMin = timeMin;
        this.timeMax = timeMax;
        this.neededResources = neededResources;
        this.finalResources = finalResources;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public int getTimeMax() {
        return timeMax;
    }

    public String getName() {
        return name;
    }

    public Resources getNeededResources() {
        return neededResources;
    }

    public Resources getFinalResources() {
        return finalResources;
    }

    public int getRandomTime(){
        if (getTimeMax() != getTimeMin()) {
            return getTimeMin() + (int) (Math.random() * ((getTimeMax() - getTimeMin()) + 1));
        }else{
            return getTimeMin();
        }
    }

    private static Resources getResultResources() {
        if (assembleFoobarIsSuccess()) {
            return new Resources(0, 0, 1, 0);
        } else {
            return new Resources(0, 1, 0, 0);
        }
    }

    private static boolean assembleFoobarIsSuccess() {
        //there is only 60% chance of success for this operation
        int randomNumber = new Random().nextInt(10) +1;
        boolean assembleFoobarIsSuccess = randomNumber <= 6;
        ProductionLineLogger.printAssembleFoobarResult(assembleFoobarIsSuccess);
        return assembleFoobarIsSuccess;
    }
}
