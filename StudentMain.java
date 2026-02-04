package com.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                Student s = new Student(id, name, age);
                list.add(s);

                System.out.println("Student Added!");

            } else if (choice == 2) {
                if(list.isEmpty()) {
                    System.out.println("No students found!");
                } else {
                    System.out.println("ID  Name  Age");
                    for (Student st : list) {
                        st.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter ID of student to update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                boolean found = false;
                for (Student st : list) {
                    if (st.id == updateId) {
                        System.out.print("Enter new Name: ");
                        st.name = sc.nextLine();
                        System.out.print("Enter new Age: ");
                        st.age = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Student Updated!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + updateId + " not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter ID of student to delete: ");
                int deleteId = sc.nextInt();
                sc.nextLine();

                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == deleteId) {
                        list.remove(i);
                        System.out.println("Student Deleted!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student with ID " + deleteId + " not found!");
                }

            } else if (choice == 5) {
                System.out.println("Thank You!");

            } else {
                System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
