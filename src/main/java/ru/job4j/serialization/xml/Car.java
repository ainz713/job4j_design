package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
        private boolean privod;
        private int obemDvigatelya;
        private String marka;
        private Model model;
        private String[] seria;

        public Car() {

        }

        public Car(boolean privod, int obemDvigatelya, String marka, Model model, String...seria) {
            this.privod = privod;
            this.obemDvigatelya = obemDvigatelya;
            this.marka = marka;
            this.model = model;
            this.seria = seria;
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
}
