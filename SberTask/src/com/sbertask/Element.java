package com.sbertask;

import java.util.LinkedList;
import java.util.List;


public class Element {
    private int x;
    private int y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + " " + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return getX() == element.getX() && getY() == element.getY();
    }

}

class Test {

    Element[][] elements = {
            {new Element(1,1), new Element(1, 2), new Element(1, 3)},
            {new Element(2,1), new Element(2, 2), new Element(2, 3)},
            {new Element(3,1), new Element(3, 2), new Element(3, 3)}
    };

    public List<Element> getNeighborElements(Element element) {
        List<Element> neighborElements = new LinkedList<>();
        int currentX = element.getX();
        int currentY = element.getY();

        if(element.getX() < elements[0][0].getX() || element.getY() < elements[0][0].getY()
                || element.getX() > elements[elements.length - 1][elements.length - 1].getX()
                || element.getY() > elements[elements.length - 1][elements.length - 1].getY()){
            return new LinkedList<>();
        }

        for (Element[] els : elements) {
            for(Element el : els){
                if (!el.equals(element) && Math.abs(el.getX() - currentX) <= 1 && Math.abs(el.getY() - currentY) <= 1){
                    neighborElements.add(el);
                }
            }
        }
        return neighborElements;
    }

    public static void main(String[] args) {
        Element testExample = new Element(3, 3);
        Element testExample1 = new Element(2, 2);
        Element testExample2 = new Element(1, 1);
        Element testExample3 = new Element(3, 2);
        Element testExample4 = new Element(1, 3);

        List<Element> neighborElements = new Test().getNeighborElements(testExample);

        if(!neighborElements.isEmpty()){
            System.out.println("Список «соседних» элементов: " + testExample.toString());
            for(Element e : neighborElements){
                System.out.println(e.toString());
            }
        }
        else {
            System.out.println("Нет «соседних» элементов");
        }
    }
}



