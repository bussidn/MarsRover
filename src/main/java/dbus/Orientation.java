package dbus;

enum Orientation {
    NORTH, WEST, SOUTH;

    public Orientation left() {
        return values()[this.ordinal() + 1];
    }
}
