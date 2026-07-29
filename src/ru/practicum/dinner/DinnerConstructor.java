package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dinnersByType;
    Random random;

    public DinnerConstructor() {
        dinnersByType = new HashMap<>();
        random = new Random();
    }

    public void addNewDish(String dishType, String dishName) {
        if (dinnersByType.containsKey(dishType)) {
            ArrayList<String> dishes = dinnersByType.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinnersByType.put(dishType, dishes);
        }
    }

    public boolean checkType(String dishType) {
        return dinnersByType.containsKey(dishType);
    }

    public String getRandomDish(ArrayList<String> availableDishes) {
        int randomIndex = random.nextInt(availableDishes.size());
        return availableDishes.get(randomIndex);
    }

    public ArrayList<String> generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();

        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }
        return selectedDishes;
    }

    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }
}

