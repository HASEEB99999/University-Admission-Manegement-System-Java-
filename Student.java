public class Student {
    String formNumber;
    String name;
    String fatherName;
    String CNIC;
    double matricMarks;
    double fscMarks;
    int rollNumber;
    double testMarks;
    double interviewMarks;
    double finalScore;

    Student(String formNumber, String name, String fatherName, String CNIC, double matricMarks, double fscMarks, int rollNumber) {
        this.formNumber = formNumber;
        this.name = name;
        this.fatherName = fatherName;
        this.CNIC = CNIC;
        this.matricMarks = matricMarks;
        this.fscMarks = fscMarks;
        this.rollNumber = rollNumber;
        this.testMarks = 0;
        this.interviewMarks = 0;
    }
  
    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    void calculateFinalScore() {
        finalScore = ((matricMarks / 1000) * 10) + ((fscMarks / 1100) * 50) + ((testMarks / 50) * 30) + ((interviewMarks / 20) * 10);
    }

    boolean isEligibleForMeritList() {
        return testMarks >= 0 && interviewMarks >= 0;
    }


    boolean isValidMatricMarks() {
        return matricMarks >= 0 && matricMarks <= 1000;
    }

    boolean isValidFscMarks() {
        return fscMarks >= 0 && fscMarks <= 1100;
    }

    boolean isValidTestMarks() {
        return testMarks >= 0 && testMarks <= 50;
    }

    boolean isValidInterviewMarks() {
        return interviewMarks >= 0 && interviewMarks <= 20;
    }

    // Getter and setter for marks
    public double getMatricMarks() {
        return matricMarks;
    }

    public void setMatricMarks(double matricMarks) {
        this.matricMarks = matricMarks;
    }

    public double getFscMarks() {
        return fscMarks;
    }

    public void setFscMarks(double fscMarks) {
        this.fscMarks = fscMarks;
    }

    public double getTestMarks() {
        return testMarks;
    }

    public void setTestMarks(double testMarks) {
        this.testMarks = testMarks;
    }

    public double getInterviewMarks() {
        return interviewMarks;
    }

    public void setInterviewMarks(double interviewMarks) {
        this.interviewMarks = interviewMarks;
    }

    
    public double getFinalScore() {
        return finalScore;
    }
}