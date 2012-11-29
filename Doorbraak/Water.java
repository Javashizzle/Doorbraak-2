import greenfoot.*;

public class Water extends Actor {
    public Water() {
        getImage().scale(50, 50);
    }

    @Override
    public void act() {
        if (Math.random() < 0.9) return;

        int dx = 0, dy = 0;
        switch ((int)(3.0 * Math.random())) {
            case 0: dx = 0; dy = 1; break;
            case 1: dx = 1; dy = 0; break;
            case 2: dx = -1; dy = 0; break;
        }

        Actor sandstone = getOneObjectAtOffset(dx * 50, dy * 50, Sandstone.class);
        if (sandstone != null) {
            getWorld().removeObject(sandstone);

            Water water = new Water();
            getWorld().addObject(water, getX() + dx * 50, getY() + dy * 50);
            ((DoorbraakWorld)getWorld()).addWater(water);
        }
    }

    public boolean hitsSand() {
        Actor sand = getOneObjectAtOffset(0, 50, Sand.class);
        return sand != null;
    }
}
