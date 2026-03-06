package com.link.fitbody.core;

public class Health {
    public double calculateIdealWeight(Gender gender, double heightCm) {
        double idealWeight = -1;
        double correction = heightCm - 152;

        if (gender == Gender.MALE) {
            idealWeight = 48;

            if (correction > 0) {
                idealWeight += (correction * 1.1);
            }
        } else if (gender == Gender.FEMALE) {
            idealWeight = 45.5;

            if (correction > 0) {
                idealWeight += (correction) * 0.9;
            }
        }
        return idealWeight;
    }

    public BodyShape calculateBodyType(double bustCm, double waistCm, double hipCm) {

        BodyShape shape;

        double bustWaistRatio = bustCm / waistCm;
        double hipWaistRatio = hipCm / waistCm;

        if (bustWaistRatio < 1.4 && hipWaistRatio < 1.4) {
            shape = BodyShape.BANANA;
        } else if (bustWaistRatio - hipWaistRatio >= 0.2) {
            shape = BodyShape.APPLE;
        } else if (hipWaistRatio - bustWaistRatio >= 0.2) {
            shape = BodyShape.PEAR;
        } else {
            shape = BodyShape.HOURGLASS;
        }
        return shape;
    }

    public int calculateCalorie(Gender gender, int age, double heightCm, double weightKg, double activityFactor) {

        double calorieResult = -1;
        int correction = 0;

        if (gender == Gender.MALE) {
            correction = 5;
        } else if (gender == Gender.FEMALE) {
            correction = -161;
        }

        calorieResult = (10 * weightKg + 6.25 * heightCm - 5 * age + correction) * activityFactor;

        return (int) calorieResult;
    }
}
