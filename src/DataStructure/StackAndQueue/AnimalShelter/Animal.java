package DataStructure.StackAndQueue.AnimalShelter;

public abstract class Animal {
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String info() {
        return order + ") type: " + type + ", name: " + name;
    }
}
