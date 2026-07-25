import java.util.ArrayList;
import java.util.List;

public class AdmissionManager {

    List<Student> students = new ArrayList<>();
    
    
    public boolean isFormNumberDuplicate(String formNumber) {
        for (Student student : students) {
            if (student.formNumber.equals(formNumber)) {
                return true; 
            }
        }
        return false; 
    }
    
    public boolean isCnicDuplicate(String CNIC) {
        for (Student student : students) {
            if (student.CNIC.equals(CNIC)) {
                return true; 
            }
        }
        return false; 
    }
    
    
    int rollCounter = 1000;
    
    Student registerStudent(String formNumber, String name, String fatherName, String CNIC, double matricMarks, double fscMarks) {
        Student student = new Student(formNumber, name, fatherName, CNIC, matricMarks, fscMarks, rollCounter++);
        students.add(student);
        return student;
    }

    
    Student findStudentByRollNumber(int rollNumber) {
        for (Student s : students) {
            if (s.rollNumber == rollNumber) return s;
        }
        return null;
    }

    
    List<Student> getEligibleStudentsForMeritList() {
        List<Student> eligibleStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.isEligibleForMeritList()) {
                s.calculateFinalScore();  
                eligibleStudents.add(s);
            }
        }
        
        eligibleStudents.sort((s1, s2) -> Double.compare(s2.finalScore, s1.finalScore));
        return eligibleStudents;
    }

    
    public Student recoverRollNumber(String CNIC) {
       
        for (Student student : students) {
            if (student.getCNIC().equals(CNIC)) {  
                return student;  
            }
        }
        return null;  
    }
}