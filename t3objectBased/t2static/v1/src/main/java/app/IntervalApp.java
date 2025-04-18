package app;

import util.collection.list.FractionIntervalLinkedList;
import util.collection.list.iterator.DoubleIntervalIterator;
import util.collection.list.iterator.FractionIntervalIterator;
import util.collection.list.DoubleIntervalLinkedList;
import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        DoubleIntervalLinkedList doubleIntervalList = DoubleIntervalLinkedList.of(
            doubleIntervalDialog.read(),
            new DoubleInterval(-1, 1),
            new DoubleInterval(0, 0),
            DoubleIntervalDialog.create("[100,200]"));
        DoubleIntervalIterator doubleIntervalIterator = doubleIntervalList.iterator();
        while (doubleIntervalIterator.hasNext()) {
            doubleIntervalDialog.writeDetails(doubleIntervalIterator.next());
        }

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        FractionIntervalLinkedList fractionIntervalList = FractionIntervalLinkedList.of(
            fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                FractionIntervalDialog.create("[1/2,2/3]"));
        FractionIntervalIterator fractionIntervalIterator = fractionIntervalList.iterator();
        while (fractionIntervalIterator.hasNext()) {
            fractionIntervalDialog.writeDetails(fractionIntervalIterator.next());
        }
        Console.close("0");
    }

}
