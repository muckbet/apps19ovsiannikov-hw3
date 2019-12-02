package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return (int) GPA + 1221 * year + 13 * surname.hashCode()
                + 7 * name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student other = (Student) o;
        if (other.hashCode() != hashCode()) {
            return false;
        }
        return name.equals(other.name) && surname.equals(other.surname)
                && GPA == other.GPA && year == other.year;

    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname="
                + surname + ", " + "GPA=" + GPA
                + ", year=" + year + '}';
    }

}
