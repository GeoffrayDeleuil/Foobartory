package model;

import Utils.ProductionLineLogger;

import java.util.Random;

public enum Action {
    MINE_FOO("Mine Foo") {
        @Override
        public int getTimeMin() {
            return 10;
        }

        @Override
        public Resources getResultResources() {
            return new Resources(1, 0, 0, 0);
        }
    },
    MINE_BAR("Mine Bar") {
        @Override
        public int getTimeMin() {
            return 5;
        }

        @Override
        public int getTimeMax() {
            return 20;
        }

        @Override
        public Resources getResultResources() {
            return new Resources(0, 1, 0, 0);
        }
    },
    ASSEMBLE_FOOBAR("Assemble Foobar") {
        @Override
        public int getTimeMin() {
            return 20;
        }

        @Override
        public Resources getNeededResources() {
            return new Resources(-1, -1, 0, 0);
        }

        @Override
        public Resources getResultResources() {
            if (ASSEMBLE_FOOBAR.assembleFoobarIsSuccess()) {
                return new Resources(0, 0, 1, 0);
            } else {
                return new Resources(0, 1, 0, 0);
            }
        }
    },
    SELL_FOOBAR("Sell Foobar") {
        @Override
        public int getTimeMin() {
            return 100;
        }

        @Override
        public Resources getNeededResources() {
            return new Resources(0, 0, -5, 0);
        }

        @Override
        public Resources getResultResources() {
            return new Resources(0, 0, 0, 5);
        }
    },
    BUY_ROBOT("Buy model.Robot") {
        @Override
        public int getTimeMin() {
            return 0;
        }

        @Override
        public Resources getNeededResources() {
            return new Resources(-6, 0, 0, -3);
        }

        @Override
        public Resources getResultResources() {
            return null;
        }
    };

    private Random rand = new Random();

    private final String name;

    Action(String name) {
        this.name = name;
    }

    public String getActionName() {
        return name;
    }

    public abstract int getTimeMin();

    public int getTimeMax() {
        return getTimeMin();
    }

    public abstract Resources getResultResources();

    public Resources getNeededResources() {
        return null;
    }

    private boolean assembleFoobarIsSuccess() {
        int randomNumber = rand.nextInt(10) +1;
        boolean assembleFoobarIsSuccess = randomNumber <= 6;
        ProductionLineLogger.printAssembleFoobarResult(assembleFoobarIsSuccess);
        return assembleFoobarIsSuccess;
    }
}
