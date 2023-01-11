package com.mowitnow.kata.util;

import com.mowitnow.kata.model.Mower;
import com.mowitnow.kata.model.MowerDirection;
import com.mowitnow.kata.model.Position;

import java.util.Arrays;
import java.util.List;

public class MowerUtil {
    public static List<MowerDirection> directions = Arrays.asList(MowerDirection.values());

    public static void turnRight(Mower m) {
        int index = directions.indexOf(m.getDirection());
        MowerDirection newDirection = (index == directions.size() - 1) ? directions.get(0)
                : directions.get(index + 1);
        m.setDirection(newDirection);
    }

    public static void turnLeft(Mower m) {
        int index = directions.indexOf(m.getDirection());
        MowerDirection newDirection = (index == 0) ? directions.get(directions.size() - 1)
                : directions.get(index - 1);
        m.setDirection(newDirection);
    }

    public static void goForward(Mower m, Position lawnTopRightCorner) {
        int x = m.getPosition().getX();
        int y = m.getPosition().getY();

        switch (m.getDirection()) {
            case E:
                if (x < lawnTopRightCorner.getX()) x++;
                break;
            case N:
                if (y < lawnTopRightCorner.getY()) y++;
                break;
            case S:
                if (y > 0) y--;
                break;
            case W:
                if (x > 0) x--;
                break;
        }
        m.setPosition(new Position(x, y));
    }
}
