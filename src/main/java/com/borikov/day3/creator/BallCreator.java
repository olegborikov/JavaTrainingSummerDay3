package com.borikov.day3.creator;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import com.borikov.day3.exception.IncorrectDataException;
import com.borikov.day3.validator.BallValidator;

public class BallCreator {
    public Ball createBall(Color ballColor, Size ballSize, double weight) throws IncorrectDataException {
        BallValidator ballValidator = new BallValidator();
        if(!ballValidator.isWeightInLimit(weight)){
            throw new IncorrectDataException();
        }
        Ball newBall = new Ball(ballColor, ballSize, weight);
        return newBall;
    }
}
