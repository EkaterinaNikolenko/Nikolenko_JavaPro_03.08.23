package edu.hillel.nikolenko.homeworks.homework20_patterns.builder;

public class Car {
    private String body;
    private String engine;
    private String transmission;
    private int seats;
    private String navigator;

    public Car(Builder builder) {
        this.body = builder.body;
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.seats = builder.seats;
        this.navigator = builder.navigator;
    }

    public String getBody() {
        return body;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getSeats() {
        return seats;
    }

    public String getNavigator() {
        return navigator;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    static final class Builder {
        private String body;
        private String engine;
        private String transmission;
        private int seats;
        private String navigator;

        private Builder() {

        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder seats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder navigator(String navigator) {
            this.navigator = navigator;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
