class Person implements Comparable<Person> {
    private String name;
    private int priority;

    public Person(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(other.priority, this.priority);
    }
}
