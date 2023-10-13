package P5PokemonTrainer;

import java.util.List;

public class Trainer {
    private String  name;
    private int badges;
    private List<Pokemon> pokemons;

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badges, pokemons.size());
    }

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        setName(name);
        setBadges(badges);
        setPokemons(pokemons);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
