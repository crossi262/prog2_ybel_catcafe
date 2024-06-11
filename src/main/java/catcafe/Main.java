package catcafe;

public class Main {
    public static void main(String[] args) {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Whiskers", 4));
        cafe.addCat(new FelineOverLord("Tom", 6));

        // Beispielaufrufe
        cafe.getCatByName("Whiskers").ifPresent(cat -> System.out.println("Found cat: " + cat));
        cafe.getCatByWeight(4, 5).ifPresent(cat -> System.out.println("Found cat: " + cat));
    }
}

