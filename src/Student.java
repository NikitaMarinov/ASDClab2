import java.util.Objects;


public class Student implements Cloneable {
    private int id;
    private String firstName;
    private String lastName;

    private Faculties faculty;
    private int yearOfBirth;
    private int yearOfGraduation;

    public Student(int id, String firstName, String lastName,int faculty, int yearOfBirth, int yearOfGraduation) {
        this.id = id;
        this.firstName = firstName;
        this.faculty = Faculties.getFaculty(faculty);
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.yearOfGraduation = yearOfGraduation;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public Student(){
        this.id = 0;
        this.firstName = null;
        this.lastName = null;
        this.yearOfBirth = 0;
        this.yearOfGraduation =0;
    }
    public Student(Student other){
        this.id = other.id;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.faculty = other.faculty;
        this.yearOfBirth = other.yearOfBirth;
        this.yearOfGraduation = other.yearOfGraduation;
    }

    @Override
    public String toString(){
        return ("Student ID:" + id + " FirstName:"+ firstName + " LastName:"+ lastName +" Faculty:"+ faculty +
                " Year of birth:" + yearOfBirth + " Year of graduation:" + yearOfGraduation);
    }

    public Student clone() throws CloneNotSupportedException {
        return  (Student) super.clone();
    }

    public Student copy(){
        return new Student(this.id,this.firstName,this.lastName,this.faculty.getIndex(this),
                this.yearOfBirth,this.yearOfGraduation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId() == student.getId() && getYearOfBirth() == student.getYearOfBirth() &&
                getYearOfGraduation() == student.getYearOfGraduation() && Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getLastName(), student.getLastName()) && getFaculty() == student.getFaculty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getFaculty(), getYearOfBirth(), getYearOfGraduation());
    }


}
