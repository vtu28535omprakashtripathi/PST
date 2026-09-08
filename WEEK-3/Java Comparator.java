class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            // Sort by score in descending order
            return Integer.compare(b.score, a.score);
        }
        // If scores are equal, sort alphabetically by name (ascending order)
        return a.name.compareTo(b.name);
    }
}
