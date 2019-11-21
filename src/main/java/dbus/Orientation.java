package dbus;

enum Orientation {
    NORTH(Coordinates.of(0, 1)),
    WEST(Coordinates.of(-1, 0)),
    SOUTH(Coordinates.of(0, -1)),
    EAST(Coordinates.of(1, 0));

    private Coordinates coordinates;

    Orientation(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Orientation left() {
        return values()[(this.ordinal() + 1)%values().length];
    }

    public Orientation right() {
        return values()[(this.ordinal() + 3)%values().length];
    }

    public Coordinates move(Coordinates coordinates) {
        return coordinates.add(this.coordinates);
    }
}
