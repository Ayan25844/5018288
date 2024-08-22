public class Test_10 {
    public static void main(String[] args) {

        // Create a Student object (Model)
        Student student = new Student("John Doe", "12345", "A");

        // Create a StudentView object (View)
        StudentView view = new StudentView();

        // Create a StudentController object (Controller)
        StudentController controller = new StudentController(student, view);

        // Display initial details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");

        // Display updated details
        controller.updateView();
    }
}
