package DataStructure.ArrayAndString.ArrayList;

public class ArrayList {
    private Object[] data;
    private int size;
    private int index;

    public ArrayList() {
        this.size = 1;
        this.data = new Object[this.size];
        this.index = 0;
    }

    public void add(Object obj) {
        System.out.println("index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
        if(this.index == this.size - 1) {
            doubling();
        }
        data[this.index] = obj;
        this.index++;
    }

    // newData의 크기를 n이라고 한다면, doubling 작업에 소요되는 시간복잡도는 O(n/2 + n/4 + n/8 + ...) = O(1).
    private void doubling() {
        this.size = this.size * 2;
        Object[] newData = new Object[this.size];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
        System.out.println("*** index: " + this.index + ", size: " + this.size + ", data size: " + this.data.length);
    }

    public Object get(int i) throws Exception {
        if(i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } else if(i < 0) {
            throw new Exception("Negative Value");
        }
        return this.data[i];
    }

    public void remove(int i) throws Exception {
        if(i > this.index - 1) {
            throw new Exception("ArrayIndexOutOfBound");
        } else if(i < 0) {
            throw new Exception("Negative Value");
        }
        System.out.println("data removed: " + this.data[i]);
        for(int x = i; x < this.data.length - 1; x++) {
            data[x] = data[x + 1];
        }
        this.index--;
    }
}
