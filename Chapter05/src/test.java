class Element {
    int num;
    double weight;
    void printMyDetails() {
        System.out.println(this.num);
    }
}
public class test {
    public static void main(String[] args) {
        Element e = new Element();
        e.printMyDetails();
    }
}
