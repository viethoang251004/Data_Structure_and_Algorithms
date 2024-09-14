import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        BasicLinkedList<QuanLySinhVien> studentList = new BasicLinkedList<>();

        // a/ Khởi tạo danh sách sinh viên từ bàn phím
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Nhập số lượng sinh viên: ");
        n = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi đọc số lượng sinh viên

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("Mã số: ");
            String maSV = scanner.nextLine();
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Điểm Toán: ");
            double diemToan = scanner.nextDouble();
            System.out.print("Điểm Lý: ");
            double diemLy = scanner.nextDouble();
            System.out.print("Điểm Hóa: ");
            double diemHoa = scanner.nextDouble();

            QuanLySinhVien student = new QuanLySinhVien(maSV, hoTen, diemToan, diemLy, diemHoa);
            studentList.add(student);

            scanner.nextLine(); // Đọc ký tự newline sau khi đọc điểm Hóa
        }

        // b/ In danh sách sinh viên
        printStudentList(studentList);

        // c/ Thêm sinh viên vào cuối danh sách
        QuanLySinhVien student4 = new QuanLySinhVien("522H0010", "David", 85.0, 90.5, 87.0);
        studentList.add(student4);
        printStudentList(studentList);

        // d/ Xóa sinh viên dựa theo mã số
        String studentIdToDelete = "522H0129";
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getMaSV().equals(studentIdToDelete)) {
                studentList.remove(i);
                break;
            }
        }
        printStudentList(studentList);

        // e/ Sắp xếp tăng dần theo mã số
        studentList.sort(Comparator.comparing(QuanLySinhVien::getMaSV));

        // f/ Sắp xếp giảm dần theo điểm trung bình
        studentList.sort(Comparator.comparingDouble(student -> -1 * ((student.getDiemToan() + student.getDiemLy() + student.getDiemHoa()) / 3)));

        // g/ Tìm kiếm sinh viên dựa vào họ tên
        String searchName = "Charlie";
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getHoTen().equals(searchName)) {
                System.out.println("Found student: " + studentList.get(i));
                break;
            }
        }
    }

    public static void printStudentList(BasicLinkedList<QuanLySinhVien> studentList) {
        System.out.println("Student List:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.println();
    }
}
