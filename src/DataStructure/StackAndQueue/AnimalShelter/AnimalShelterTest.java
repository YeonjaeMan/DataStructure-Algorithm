package DataStructure.StackAndQueue.AnimalShelter;

public class AnimalShelterTest {
    public static void main(String[] args) {
        Dog d1 = new Dog("puppy");
        Dog d2 = new Dog("chichi");
        Dog d3 = new Dog("choco");

        Cat c1 = new Cat("shasha");
        Cat c2 = new Cat("miumiu");
        Cat c3 = new Cat("gaga");

        AnimalShelter as = new AnimalShelter();

        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        System.out.println(as.dequeueCat().info());
        System.out.println(as.dequeueDog().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
    }
}
