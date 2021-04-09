package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean privod;
    private final int obemDvigatelya;
    private final String marka;
    private final Model model;
    private final String[] seria;

    public Car(boolean privod, int obemDvigatelya, String marka, Model model, String...seria) {
        this.privod = privod;
        this.obemDvigatelya = obemDvigatelya;
        this.marka = marka;
        this.model = model;
        this.seria = seria;
    }

    public Model getModel() {
        return model;
    }

    public String[] getSeria() {
        return seria;
    }

    public boolean isPrivod() {
        return privod;
    }

    public int getObemDvigatelya() {
        return obemDvigatelya;
    }

    public String getMarka() {
        return marka;
    }

       @Override
    public String toString() {
        return "Car{"
                + "privod=" + privod
                + ", obemDvigatelya=" + obemDvigatelya
                + ", marka='" + marka + '\''
                + ", model=" + model
                + ", seria=" + Arrays.toString(seria)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(false, 3, "BMW", new Model(335),
                "troyka", "pyaterka");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        final String carJson = gson.toJson(car);
        System.out.println(carJson);

        /* Преобразуем обратно */
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
