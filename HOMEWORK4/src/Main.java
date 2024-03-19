import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng học viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Student> students = new ArrayList<>();

        // Nhập thông tin học viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin học viên " + (i + 1) + ":");
            System.out.print("Mã sinh viên: ");
            String maSinhVien = scanner.nextLine();
            System.out.print("Họ và tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Giới tính: ");
            String gioiTinh = scanner.nextLine();
            System.out.print("Điểm Python: ");
            double diemPython = scanner.nextDouble();
            System.out.print("Điểm Java: ");
            double diemJava = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students.add(new Student(maSinhVien, hoTen, gioiTinh, diemPython, diemJava));
        }

        // Ghi danh sách học viên vào file
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.println(student);
            }
        }

        // Đọc danh sách học viên từ file và sắp xếp theo điểm trung bình giảm dần
        Collections.sort(students, Comparator.comparingDouble((Student s) -> s.diemTB).reversed());

        // In danh sách học viên sau khi sắp xếp và ghi vào file
        System.out.println("Danh sách học viên sau khi sắp xếp:");
        try (PrintWriter writer = new PrintWriter(new FileWriter("sorted_students.txt"))) {
            for (Student student : students) {
                System.out.println(student);
                writer.println(student);
            }
        }

        // Tìm kiếm học viên
        System.out.print("Nhập họ tên học viên cần tìm: ");
        String tenCanTim = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.hoTen.equalsIgnoreCase(tenCanTim)) {
                System.out.println("Thông tin học viên cần tìm:");
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy học viên có họ tên: " + tenCanTim);
        }

        // Hiển thị thông tin các bạn đã đậu và các bạn đã trượt
        System.out.println("\nThông tin các bạn đã đậu:");
        for (Student student : students) {
            if (student.ketQua.equals("Đậu")) {
                System.out.println(student);
            }
        }

        System.out.println("\nThông tin các bạn đã trượt:");
        for (Student student : students) {
            if (student.ketQua.equals("Trượt")) {
                System.out.println(student);
            }
        }

        // Tìm học viên có điểm trung bình cao nhất
        double maxDiemTB = Double.MIN_VALUE;
        for (Student student : students) {
            maxDiemTB = Math.max(maxDiemTB, student.diemTB);
        }
        System.out.println("\nThông tin các bạn có điểm trung bình cao nhất:");
        for (Student student : students) {
            if (student.diemTB == maxDiemTB) {
                System.out.println(student);
            }
        }
    }
}