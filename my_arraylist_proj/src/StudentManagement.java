import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManagement {
    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        while(true) {
            System.out.println("Press 1 to add a student, " + "\nPress 2 to update a student " + "\nPress 3 to delete a student" + "\nPress 4 to view all students " +"\nPress 5 to sort students by age" + "\nPress 6 to exit");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) {
                System.out.println("Enter the name: ");
                String tmpName = scanner.nextLine();
                System.out.println("Enter the age: ");
                int tmpAge = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the major: ");
                String tmpMajor = scanner.nextLine();
                students.add(new Student(tmpName, tmpAge, tmpMajor));
                System.out.println("Student added successfully!");
            }
            else if (userAction.equals("2")) {
                System.out.println("Enter the index of the student you want to update ");
                int chgIdx = Integer.parseInt(scanner.nextLine());
                if(chgIdx >= 0 && chgIdx < students.size()) {
                    System.out.println("Enter the name of the student");
                    String chgName = scanner.nextLine();
                    System.out.println("Enter the age of the student");
                    int chgAge = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the major of the student");
                    String chgMajor = scanner.nextLine();
                    students.get(chgIdx).setName(chgName);
                    students.get(chgIdx).setAge(chgAge);
                    students.get(chgIdx).setMajor(chgMajor);
                    System.out.println("Student updated successfully!");
                } else {
                    System.out.println("A student with this index does not exist!");
                }
            }
            else if (userAction.equals("3")) {
                System.out.println("Enter the index of the student to be deleted ");
                int delIdx = Integer.parseInt(scanner.nextLine());
                if(delIdx >= 0 && delIdx < students.size()) {
                    students.remove(delIdx);
                    System.out.println("Student was successfully removed!");
                } else {
                    System.out.println("A student with this index does not exist!");
                }
            }
            else if (userAction.equals("4")) {
                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {
                    students.forEach(student -> System.out.println(student));
                }
            }
            else if (userAction.equals("5")) {
                Collections.sort(students, new Comparator<Student>() {
	            	@Override
	            	public int compare(Student t1, Student t2) {
	            		return Integer.compare(t2.getAge(), t1.getAge());
	            	}
        		});
                System.out.println("Students are sorted by age (from High to Low)");
                students.forEach(student -> System.out.println(student));
            }
            else if (userAction.equals("6")) { 
                System.out.println("Thank you for using the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}