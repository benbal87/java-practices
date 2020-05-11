package com.ben.javapractices.utils.generatecoordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CoordinateGenerator {

    private final double EARTH_RADIUS_METERS = 6371000.0;

    private final int MIN_NUMBER_OF_SEGMENTS = 5;

    private final int HALF_CIRCLE_IN_DEGREES = 180;

    private final int RIGHT_ANGLE = 90;

    private final double THETA_INACCURACY = 0.1;

    private final int TWO = 2;

    private final float CHANGE_TO_DEGREE = 111000f;

    /*
     * This method creates random coordinate pairs within a given radius around a given coordinate.
     * */
    public List<Coordinate> getRandomCoordinates(
        double longitude,
        double latitude,
        int radiusInMeters,
        int numberOfCoordinates
    ) {
        List<Coordinate> result = new ArrayList<>();
        for (int i = 0; i < numberOfCoordinates; i++) {
            Coordinate coordinate = getRandomCoordinate(longitude, latitude, radiusInMeters);
            result.add(coordinate);
        }

        return result;
    }

    public Coordinate getRandomCoordinate(double longitude, double latitude, int radiusInMeters) {
        Random random = new Random();

        // Convert radius from meters to degrees
        double radiusInDegrees = radiusInMeters / CHANGE_TO_DEGREE;

        double u = random.nextDouble();
        double v = random.nextDouble();
        double w = radiusInDegrees * Math.sqrt(u);
        double t = 2 * Math.PI * v;
        double x = w * Math.cos(t);
        double y = w * Math.sin(t);

        // Adjust the x-coordinate for the shrinking of the east-west distances
        double new_x = x / Math.cos(Math.toRadians(longitude));

        double randomLatitude = new_x + latitude;
        double randomLongitude = y + longitude;

        return new Coordinate(randomLatitude, randomLongitude);
    }

    /*
     * This method creates a certain number of GPS coordinates around a given coordinate in a given radius.
     * */
    public List<Coordinate> generatePolygonRadius(
        int numberOfSegments,
        double latitude,
        double longitude,
        double radiusInMeters
    ) {
        if (numberOfSegments < MIN_NUMBER_OF_SEGMENTS) {
            throw new IllegalArgumentException("you need a minimum of 5 numberOfSegments");
        }

        List<Coordinate> coordinateList = new ArrayList<>();

        double relativeLatitude = radiusInMeters / EARTH_RADIUS_METERS * HALF_CIRCLE_IN_DEGREES / Math.PI;

        // things get funny near the north and south pole, so doing a modulo 90
        // to ensure that the relative amount of degrees doesn't get too crazy.
        double relativeLongitude = relativeLatitude / Math.cos(Math.toRadians(latitude)) % RIGHT_ANGLE;

        for (int i = 0; i < numberOfSegments; i++) {
            // radians go from 0 to 2*PI; we want to divide the circle in nice
            // numberOfSegments
            double theta = 2 * Math.PI * i / numberOfSegments;

            // trying to avoid theta being exact factors of pi because that results in some funny behavior around the
            // north-pole
            theta += THETA_INACCURACY;
            if (theta >= TWO * Math.PI) {
                theta = theta - 2 * Math.PI;
            }

            // on the unit circle, any point of the circle has the coordinate
            // cos(t),sin(t) where t is the radian. So, all we need to do that
            // is multiply that with the relative latitude and longitude
            // note, latitude takes the role of y, not x. By convention we
            // always note latitude, longitude instead of the other way around
            double latitudeOnCircle = latitude + relativeLatitude * Math.sin(theta);
            double longitudeOnCircle = longitude + relativeLongitude * Math.cos(theta);
            if (longitudeOnCircle > HALF_CIRCLE_IN_DEGREES) {
                longitudeOnCircle = -HALF_CIRCLE_IN_DEGREES + (longitudeOnCircle - HALF_CIRCLE_IN_DEGREES);
            } else if (longitudeOnCircle < -HALF_CIRCLE_IN_DEGREES) {
                longitudeOnCircle = HALF_CIRCLE_IN_DEGREES - (longitudeOnCircle + HALF_CIRCLE_IN_DEGREES);
            }

            if (latitudeOnCircle > RIGHT_ANGLE) {
                latitudeOnCircle = RIGHT_ANGLE - (latitudeOnCircle - RIGHT_ANGLE);
            } else if (latitudeOnCircle < -RIGHT_ANGLE) {
                latitudeOnCircle = -RIGHT_ANGLE - (latitudeOnCircle + RIGHT_ANGLE);
            }

            coordinateList.add(new Coordinate(latitudeOnCircle, longitudeOnCircle));
        }

        return coordinateList;
    }

}
