package DataStructure.StackAndQueue.AnimalShelter;

import java.util.LinkedList;

// 개와 고양이만 분양하는 분양소가 있다.
// 분양받는 사람은 동물의 종류만 고를 수 있고,
// 분양소에서 가장 오래 있은 순서로 자동으로 분양될 동물이 정해지는 클래스를 구현하시오.
// (단, 자바에서 제공하는 LinkedList로 구현하시오.)
public class AnimalShelter {
    // 강아지 연결리스트
    public LinkedList<Dog> dogs = new LinkedList<Dog>();
    // 고양이 연결리스트
    public LinkedList<Cat> cats = new LinkedList<Cat>();
    // 동물에게 부여하는 순번
    public int order;

    // 분양소 생성자
    public AnimalShelter() {
        // 동물의 순번을 처음에 1로 초기화
        this.order = 1;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if(animal.type == AnimalType.DOG) {
            dogs.addLast((Dog) animal);
        } else if(animal.type == AnimalType.CAT) {
            cats.addLast((Cat) animal);
        }
    }

    // 강아지를 분양받는 메소드
    public Animal dequeueDog() {
        // 강아지 연결리스트에서 꺼냄
        return dogs.poll();
    }

    // 고양이를 분양받는 메소드
    public Animal dequeueCat() {
        // 고양이 연결리스트에서 꺼냄
        return cats.poll();
    }

    // 동물의 종류를 고르지 않았을 때 분양하는 메소드
    public Animal dequeue() {
        // 강아지와 고양이가 있는지 확인
        if(dogs.size() == 0 && cats.size() == 0) {
            // 동물이 한마리도 없다면 null 반환
            return null;
        } else if(dogs.isEmpty()) {
            // 강아지가 없다면 고양이 분양
            return cats.poll();
        } else if(cats.isEmpty()) {
            // 고양이가 없다면 강아지 분양
            return dogs.poll();
        }

        // 강아지와 고양이 둘 다 있다면 각각 peek()를 이용해 꺼내줌
        Animal dog = dogs.peek();
        Animal cat = cats.peek();

        // 고양이와 강아지의 순번을 비교하여 꺼냄
        if(cat.order < dog.order) {
            return cats.poll();
        } else {
            return dogs.poll();
        }
    }
}
