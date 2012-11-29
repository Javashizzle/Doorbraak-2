import greenfoot.*;
import java.util.ArrayList;
import javax.swing.*;

public class DoorbraakWorld extends World {
    private ArrayList<Water> waterBlocks;
    private ArrayList<Sandstone> floodbankBlocks;

    public DoorbraakWorld() {
        super(800, 800, 1);
        waterBlocks = new ArrayList<Water>();
        floodbankBlocks = new ArrayList<Sandstone>();
        populate();
    }

    private void populate() {
        for (int x = 0; x < 800; x += 50) {
            for (int y = 0; y < 200; y += 50) {
                Water water = new Water();
                waterBlocks.add(water);
                addObject(water, x, y);
            }

            for (int y = 200; y < 350; y += 50) {
                Sandstone sandstone = new Sandstone();
                floodbankBlocks.add(sandstone);
                addObject(sandstone, x, y);
            }

            for (int y = 350; y < 800; y += 50) {
                addObject(new Sand(), x, y);
            }
        }
    }

    @Override
    public void act() {
        if (!floodbankAlive()) {
            Greenfoot.stop();
            JOptionPane.showMessageDialog(null, "Je hebt verloren!");
        }
    }

    public void addWater(Water water) {
        waterBlocks.add(water);
    }

    private boolean floodbankAlive() {
        for (Water water : waterBlocks) {
            if (water.hitsSand()) return false;
        }
        return true;
    }
}
