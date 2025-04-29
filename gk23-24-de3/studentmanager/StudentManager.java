package hus.oop.studentmanager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        /* TODO */
        this.studentList = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public List<Student> getStudentList() {
        /* TODO */
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        this.studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        this.studentList.add(index, student);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        this.studentList.remove(student);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return this.studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên,
     * nếu tên như nhau thì sắp xếp theo họ.
     * Sử dụng giao diện StudentComparable để sắp xếp.
     * @return
     */
    public List<Student> sortStudentByName() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        boolean swapped;
        for (int i = 0; i < studentList.size() - 1; i++) {
            swapped = false;
            for (int j = i; j < studentList.size() - 1; j++) {
                if (studentList.get(j).
                        compareTo(studentList.get(j + 1)) > 0) {
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán tăng dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortMathsGradeIncreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getMathsGrade() > o2.getMathsGrade()) {
                return 1;
            } else if (o1.getMathsGrade() < o2.getAverageGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortMathsGradeDecreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getMathsGrade() < o2.getMathsGrade()) {
                return 1;
            } else if (o1.getMathsGrade() > o2.getAverageGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý tăng dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortPhysicsGradeIncreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getPhysicsGrade() > o2.getPhysicsGrade()) {
                return 1;
            } else if (o1.getPhysicsGrade() < o2.getPhysicsGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm lý giảm dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortPhysicsGradeDecreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getPhysicsGrade() < o2.getPhysicsGrade()) {
                return 1;
            } else if (o1.getPhysicsGrade() > o2.getPhysicsGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa tăng dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortChemistryGradeIncreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getChemistryGrade() > o2.getChemistryGrade()) {
                return 1;
            } else if (o1.getChemistryGrade() < o2.getChemistryGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm hóa giảm dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortChemistryGradeDecreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getChemistryGrade() < o2.getChemistryGrade()) {
                return 1;
            } else if (o1.getChemistryGrade() > o2.getChemistryGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortAverageGradeIncreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getAverageGrade() > o2.getAverageGrade()) {
                return 1;
            } else if (o1.getAverageGrade() < o2.getAverageGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * @return
     */
    public List<Student> sortAverageGradeDecreasing() {
        /* TODO */
        List<Student> studentList = new ArrayList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getAverageGrade() < o2.getAverageGrade()) {
                return 1;
            } else if (o1.getAverageGrade() > o2.getAverageGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortAverageGradeDecreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortAverageGradeIncreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    public static String idOfStudentsToString(List<Student> countryList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student country : countryList) {
            idOfStudents.append(country.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
