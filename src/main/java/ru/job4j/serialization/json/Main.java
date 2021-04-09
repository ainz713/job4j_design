package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonModel = new JSONObject("{\"number\":\"335\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("semerka");
        list.add("dvoika");
        JSONArray jsonSeries = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Car car = new Car(false, 3, "BMW", new Model(335),
                "troyka", "pyaterka");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("privod", car.isPrivod());
        jsonObject.put("obemDvigatelya", car.getObemDvigatelya());
        jsonObject.put("marka", car.getMarka());
        jsonObject.put("model", jsonModel);
        jsonObject.put("seria", jsonSeries);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект car в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}
