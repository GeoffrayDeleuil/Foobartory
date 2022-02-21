package model;

public class Resources {
    private int foo;
    private int bar;
    private int foobar;
    private int euros;

    public Resources(int foo, int bar, int foobar, int euros) {
        this.foo = foo;
        this.bar = bar;
        this.foobar = foobar;
        this.euros = euros;
    }

    public int getFoo() {
        return foo;
    }

    public int getBar() {
        return bar;
    }

    public int getFoobar() {
        return foobar;
    }

    public int getEuros() {
        return euros;
    }

    public synchronized Resources updateResources(Resources newResources) {
        this.foo += newResources.getFoo();
        this.bar += newResources.getBar();
        this.foobar += newResources.getFoobar();
        this.euros += newResources.getEuros();
        return this;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "foo=" + foo +
                ", bar=" + bar +
                ", foobar=" + foobar +
                ", euros=" + euros +
                '}';
    }
}
