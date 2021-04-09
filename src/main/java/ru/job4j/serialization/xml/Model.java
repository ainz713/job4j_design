package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class Model {
    @XmlAttribute
    private int number;

    public Model() {

    }

    public Model(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Model{"
                + "number=" + number
                + '}';
    }
}
