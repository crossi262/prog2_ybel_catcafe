package catcafe;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    public long getCatCount() {
        return clowder.size();
    }

/**
     * Returns an Optional containing the cat with the given name if found.
     *
     * @param name the name of the cat
     * @return an Optional containing the cat if found, otherwise an empty Optional
     */
    public Optional<FelineOverLord> getCatByName(String name) {
        if (name == null) return Optional.empty();

        for (FelineOverLord c : clowder) {
            if (c.name().equals(name)) return Optional.of(c);
        }

        return Optional.empty();
    }

    /**
     * Returns an Optional containing the cat within the given weight range if found.
     *
     * @param minWeight the minimum weight of the cat
     * @param maxWeight the maximum weight of the cat
     * @return an Optional containing the cat if found, otherwise an empty Optional
     */
    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0) return Optional.empty();
        if (maxWeight < minWeight) return Optional.empty();

        for (FelineOverLord c : clowder) {
            if (c.weight() >= minWeight && c.weight() < maxWeight) return Optional.of(c);
        }

        return Optional.empty();
    }

    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
