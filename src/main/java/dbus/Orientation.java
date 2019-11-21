package dbus;

enum Orientation {
    NORTH, WEST, SOUTH, EAST;

    public Orientation left() {
        return values()[(this.ordinal() + 1)%values().length];
    }

    public Orientation right() {
        return values()[(this.ordinal() + 3)%values().length];
    }
}
