package exercice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestionEmployesApp {
    public static void main(String[] args) {
        List<Employe> employes = new ArrayList<>();
        employes.add(new Employe("Alice", "IT", 50000));
        employes.add(new Employe("Bob", "HR", 45000));
        employes.add(new Employe("Charlie", "Finance", 60000));
        employes.add(new Employe("David", "IT", 55000));
        employes.add(new Employe("Eve", "Finance", 70000));

        // 1. Calculer la somme totale des salaires de tous les employés
        double sommeTotaleSalaires = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires: " + sommeTotaleSalaires);

        // 2. Trier la liste des employés par ordre alphabétique du nom
        List<Employe> employesTries = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .collect(Collectors.toList());
        System.out.println("Employés triés par nom: " + employesTries);

        // 3. Trouver l'employé avec le salaire le plus bas
        Optional<Employe> employeSalaireMin = employes.stream()
                .min(Comparator.comparingDouble(Employe::getSalaire));
        employeSalaireMin.ifPresent(employe -> System.out.println("Employé avec le salaire le plus bas: " + employe));

        // 4. Obtenir la liste des employés ayant un salaire supérieur à une valeur donnée
        double seuilSalaire = 50000;
        List<Employe> employesSalaireSuperieur = employes.stream()
                .filter(employe -> employe.getSalaire() > seuilSalaire)
                .collect(Collectors.toList());
        System.out.println("Employés avec un salaire supérieur à " + seuilSalaire + ": " + employesSalaireSuperieur);

        // 5. Trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise
        Optional<Employe> employeSalaireMax = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2);
        employeSalaireMax.ifPresent(employe -> System.out.println("Employé avec le salaire le plus élevé: " + employe));

        // 6. Concaténer les noms de tous les employés
        String nomsConcatenes = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                .orElse("");
        System.out.println("Noms concaténés de tous les employés: " + nomsConcatenes);
    }
}

