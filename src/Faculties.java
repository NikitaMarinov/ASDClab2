public enum Faculties {
    FACULTY_OF_INFORMATICS,
    FACULTY_OF_LAW,
    FACULTY_OF_BIOENGENERY,
    FACULTY_OF_SOCIOLOGY,
    FACULTY_OF_PHILOLOGY;

    private static Faculties[] faculties = new Faculties[]{FACULTY_OF_INFORMATICS, FACULTY_OF_LAW, FACULTY_OF_BIOENGENERY, FACULTY_OF_SOCIOLOGY, FACULTY_OF_PHILOLOGY};

    private Faculties() {
    }

    public static Faculties getFaculty(int num) {
        return faculties[num - 1];
    }

    public int getIndex(Student student) {
        int buffer = 0;

        for(int i = 0; i < 5; ++i) {
            if (student.getFaculty().equals(faculties[i])) {
                buffer = i + 1;
            }
        }

        return buffer;
    }
}
