package simple_processing_App;

public final class DisplayMenu {

    public static void display(){
        System.out.printf("%10s%n","===== Menu =====");
        System.out.printf("%s%n","1. Dodaj studenta.");
        System.out.printf("%s%n","2. Przypisz ocenę.");
        System.out.printf("%s%n","3. Wyszukaj studenta.");
        System.out.printf("%s%n","4. Pokaż wszystkich studentów.");
        System.out.printf("%s%n","5. Pokaż średnią z egzaminu.");
        System.out.printf("%s%n","6. Pokaż studenta z najwyższą oceną.");
        System.out.printf("%s%n","7. Pokaż studenta z najniższą oceną.");
        System.out.printf("%s%n","8. Usuń studenta.");
        System.out.printf("%s%n","9. Graficzne przedstawienie wyników.");
        System.out.printf("%s%n","10. Zakończ program.");
    }
}
