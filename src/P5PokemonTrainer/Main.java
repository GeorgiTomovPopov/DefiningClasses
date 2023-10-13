package P5PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Pokemon pokemon;

        Map<String, List<Pokemon>> trainers = new LinkedHashMap<>();
        List<Pokemon> pokemons = new ArrayList<>();
        List<Trainer> trainerList = new LinkedList<>();

        while (!"Tournament".equals(line)) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            pokemon = new Pokemon(pokemonName, element, health);


            //adding trainers as name-pokemon list pairs into a map to avoid duplicity
            if (trainers.isEmpty()) {
                pokemons.add(pokemon);
                trainers.put(trainerName, pokemons);
                pokemons = new ArrayList<>();
            } else {
                if (trainers.containsKey(trainerName)) {
                    pokemons = trainers.get(trainerName);
                    pokemons.add(pokemon);
                    trainers.put(trainerName, pokemons);
                    pokemons = new ArrayList<>();
                } else {
                    pokemons.add(pokemon);
                    trainers.put(trainerName, pokemons);
                    pokemons = new ArrayList<>();
                }
            }

            line = scanner.nextLine();
        }

        //adding trainers from the map to the list of Trainers
        trainers.entrySet().stream().forEach(e -> {
            Trainer trainer = new Trainer(e.getKey(), 0, e.getValue());
            trainerList.add(trainer);
        });

        line = scanner.nextLine();

        while (!"End".equals(line)) {
            boolean hasRightElement = false;
            for (int i = 0; i < trainerList.size(); i++) {
                List<Pokemon> pokemonLineUp = trainerList.get(i).getPokemons();
                for (int j = 0; j < pokemonLineUp.size(); j++) {
                    if (pokemonLineUp.get(j).getElement().equals(line)) {
                        trainerList.get(i).setBadges(trainerList.get(i).getBadges() + 1);
                        hasRightElement = true;
                        break;
                    }
                }

                if (hasRightElement) {
                    continue;
                }

                for (int j = 0; j < pokemonLineUp.size(); j++) {
                    Pokemon currentPokemon = pokemonLineUp.get(j);
                    currentPokemon.setHealth(currentPokemon.getHealth() - 10);
                    if (currentPokemon.getHealth() <= 0) {
                        pokemonLineUp.remove(currentPokemon);
                        j--;
                    }
                }

                trainerList.get(i).setPokemons(pokemonLineUp);
            }

            line = scanner.nextLine();
        }


        List<Trainer> sortedList = trainerList.stream().sorted(Comparator.comparing(Trainer::getBadges).reversed()).collect(Collectors.toList());
        sortedList.forEach(System.out::println);


    }
}
