/**
 * Created by Sanjay on 10/15/2017.
 */
public class Temperature {
    public static final String CELCIUS = "C";
    public static final String FAHRENHEIT = "F";

    private double currTemp;
    private String units;

    public Temperature() {
        this.currTemp = 0.0d;
        this.units = Temperature.CELCIUS;
    }

    public Temperature(Temperature other) {
        // getTemp
    }

    public Temperature(double temp, String units) {
        if (units.equals(Temperature.CELCIUS) && units.equals(Temperature.FAHRENHEIT)) {
            throw new IllegalArgumentException();
        } else {
            this.currTemp = temp;
            this.units = units;
        }
    }

    public double getTemperature() {
        return this.currTemp;
    }

    public final void setTemperature(double temp) {
        this.currTemp = temp;
    }

    public String getUnits() {
        return this.units;
    }

    public final void setUnits(String units) {
        if (units.equals(Temperature.CELCIUS) && units.equals(Temperature.FAHRENHEIT)) {
            throw new IllegalArgumentException();
        } else if (!(units.equals(this.units))) {
            switch (units) {
                case Temperature.CELCIUS:
                    this.currTemp = toCelcius(this.currTemp);
                    break;

                case Temperature.FAHRENHEIT:
                    this.currTemp = toFahrenheit(this.currTemp);
                    break;
            }
        }
    }

    public static double toCelcius(double degF) {
        return ((degF * 32.0d) * (5.0d / 9.0d));
    }

    public static double toFahrenheit(double degC) {
        return (degC * (9.0d / 5.0d)) + 32.0d;
    }

    @Override
    public String toString() {
        return this.currTemp + this.units;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.getClass() == Temperature.class) &&
                (Temperature.toCelcius(((Temperature) (obj)).getTemperature()) == Temperature.toCelcius(this.currTemp));
    }
}
