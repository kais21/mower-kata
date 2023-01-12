package com.mowitnow.kata.model;

import lombok.*;

import java.util.Arrays;
import java.util.List;


@EqualsAndHashCode
@Getter
@Setter
@Builder(toBuilder = true)
public class Mower {
    private Long id;
    private Position position;
    private MowerDirection direction;

    public void turnRight() {
        List<MowerDirection> directions = Arrays.asList(MowerDirection.values());
        int index = directions.indexOf(getDirection());
        MowerDirection newDirection = (index == directions.size() - 1) ? directions.get(0)
                : directions.get(index + 1);
        setDirection(newDirection);
    }

    public void turnLeft() {
        List<MowerDirection> directions = Arrays.asList(MowerDirection.values());
        int index = directions.indexOf(getDirection());
        MowerDirection newDirection = (index == 0) ? directions.get(directions.size() - 1)
                : directions.get(index - 1);
        setDirection(newDirection);
    }

    public void goForward(Position lawnTopRightCorner) {
        int x = getPosition().getX();
        int y = getPosition().getY();

        switch (getDirection()) {
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
        setPosition(new Position(x, y));
    }

    @Override
    public String toString() {
        return position + " " + direction;
    }
}
