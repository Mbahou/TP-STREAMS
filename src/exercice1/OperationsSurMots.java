package exercice1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationsSurMots {
    public static void main(String[] args) {
        List<String> mots = List.of("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        // 1. Filtrer les mots qui contiennent la lettre "a".
        List<String> motsAvecA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant 'a': " + motsAvecA);

        // 2. Filtrer les mots qui ont une longueur supérieure à 3 et transformer chaque mot en son inverse.
        List<String> motsLongsInverses = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots avec longueur > 3 inversés: " + motsLongsInverses);

        // 3. Filtrer les chaînes qui contiennent la lettre "e" et aplatir chaque chaîne en une liste de ses caractères.
        List<Character> caracteresDesMotsAvecE = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant 'e': " + caracteresDesMotsAvecE);

        // 4. Transformer chaque chaîne en sa version en majuscules.
        List<String> motsMajuscules = mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules: " + motsMajuscules);

        // 5. Convertir chaque chaîne en sa longueur.
        List<Integer> longueursDesMots = mots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueurs des mots: " + longueursDesMots);

        // 6. Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères.
        List<Character> tousLesCaracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Tous les caractères: " + tousLesCaracteres);

        // 7. À partir d'une liste de mots, transformer chaque nom en une chaîne de la forme "Nom - Index" où l'index représente la position du nom dans la liste.
        List<String> motsAvecIndex = new ArrayList<>();
        for (int i = 0; i < mots.size(); i++) {
            motsAvecIndex.add(mots.get(i) + " - " + i);
        }
        System.out.println("Mots avec index: " + motsAvecIndex);
    }
}
