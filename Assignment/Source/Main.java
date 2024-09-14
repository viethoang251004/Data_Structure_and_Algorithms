import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    // cac thuoc tinh nay sẽ chạy khi duoc goi den
    // thiet lap ba thuoc tinh String va gan 3 duong dan den cac file duoi csv
    public static String MOVIE_DATASET_PATH = ".\\data\\movies.csv";
    public static String USER_DATASET_PATH = ".\\data\\users.csv";
    public static String RATING_DATASET_PATH = ".\\data\\ratings.csv";

    // thuoc tinh nay cung se chay khi duoc goi den
    // thiet lap mot doi tuong mang String bang duong dan den folder output co duoi
    // file la txt
    public static String[] REQUIREMENT_OUTPUT_FILES = new String[] {
            ".\\output\\Req1.txt",
            ".\\output\\Req2.txt",
            ".\\output\\Req3.txt",
            ".\\output\\Req4.txt",
            ".\\output\\Req5.txt",
            ".\\output\\Req6.txt",
            ".\\output\\Req7.txt"
    };

    // phuong thuc main chay dau tien
    public static void main(String[] args) {
        // tao mot doi tuong File va gan cho no la duong dan output
        File f = new File(".\\output");
        // kiem tra xem thu muc do co ton tai hay chua, neu chua thi su dung phuong thuc
        // mkdirs cua lop File de tao thu muc do
        if (!f.exists()) {
            f.mkdirs();
        }

        // tao mot doi tuong moi de truyen vao doi tuong do 3 doi tuong duong dan
        RatingManagement movieManagement = new RatingManagement(MOVIE_DATASET_PATH, RATING_DATASET_PATH,
                USER_DATASET_PATH);
        // duyet qua tung phan tu arg so voi agrs <=> for (int arg = 1; arg <= args;
        // arg++)
        for (String arg : args) {
            switch (arg) {
                case "1":
                    // requirement 1
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<String> moi ten la req1
                    ArrayList<String> req1 = new ArrayList<>();
                    // them so luong bo phim va so luong nguoi dung vao danh sach mang kieu String req1
                    req1.add(String.valueOf(movieManagement.getMovies().size() + movieManagement.getUsers().size()));
                    // them so luong danh gia vao danh sach req1 bang cach ep kieu int cua phuong thuc size thanh kieu String giong voi ArrayList<String>
                    req1.add(String.valueOf(movieManagement.getRating().size()));
                    // Ghi ra phan tu vi tri thu 0 cua mang REQUIREMENT_OUTPUT_FILES bang req1
                    writeFile(REQUIREMENT_OUTPUT_FILES[0], req1);
                    // out truong hop
                    break;
                case "2":
                    // requirement 2
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<Movie> ten la req2 bang
                    // cach truyen vao 2 tham so la userId va rating trong method cua movieMangement
                    // la findMoviesByNameAndMatchRating
                    ArrayList<Movie> req2 = movieManagement.findMoviesByNameAndMatchRating(1, 5);
                    // Ghi ra phan tu vi tri thu 1 cua mang REQUIREMENT_OUTPUT_FILES bang req2
                    writeFile(REQUIREMENT_OUTPUT_FILES[1], req2);
                    // out truong hop
                    break;
                case "3":
                    // requirement 3
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<User> ten la req3 bang
                    // cach truyen vao 2 tham so la userId va movieId trong method cua
                    // movieMangement la findUsersHavingSameRatingWithUser
                    ArrayList<User> req3 = movieManagement.findUsersHavingSameRatingWithUser(1, 1193);
                    // ghi ra phan tu vi tri thu 2 cua mang REQUIREMENT_OUTPUT_FILES bang req3
                    writeFile(REQUIREMENT_OUTPUT_FILES[2], req3);
                    // out truong hop
                    break;
                case "4":
                    // requirement 4
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<String> ten la req4 bang
                    // cach gan cho no method findMoviesNameHavingSameReputation cua doi tuong
                    // movieManagement duoc tao trong method nay
                    ArrayList<String> req4 = movieManagement.findMoviesNameHavingSameReputation();
                    // ghi ra phan tu vi tri thu 3 cua mang REQUIREMENT_OUTPUT_FILES bang req4
                    writeFile(REQUIREMENT_OUTPUT_FILES[3], req4);
                    // out truong hop
                    break;
                case "5":
                    // requirement 5
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<String> ten la req5 bang
                    // cach truyen vao 4 tham so la occupation, gender, k, rating trong method cua
                    // movieMangement la findMoviesMatchOccupationAndGender
                    ArrayList<String> req5 = movieManagement.findMoviesMatchOccupationAndGender("Lawyer", "M", 20, 3);
                    // ghi ra phan tu vi tri thu 4 cua mang REQUIREMENT_OUTPUT_FILES bang req5
                    writeFile(REQUIREMENT_OUTPUT_FILES[4], req5);
                    // out truong hop
                    break;
                case "6":
                    // requirement 6
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<String> ten la req6 bang
                    // cach truyen vao 3 tham so la occupation, k, rating trong method cua
                    // movieMangement la findMoviesByOccupationAndLessThanRating
                    ArrayList<String> req6 = movieManagement.findMoviesByOccupationAndLessThanRating("Lawyer", 20, 2);
                    // ghi ra phan tu vi tri thu 5 cua mang REQUIREMENT_OUTPUT_FILES bang req6
                    writeFile(REQUIREMENT_OUTPUT_FILES[5], req6);
                    // out truong hop
                    break;
                case "7":
                    // requirement 7
                    // tao mot doi tuong kieu du lieu long ghep ArrayList<String> ten la req7 bang
                    // cach truyen vao 3 tham so la userId, rating, k trong method cua
                    // movieMangement la findMoviesMatchLatestMovieOf
                    ArrayList<String> req7 = movieManagement.findMoviesMatchLatestMovieOf(3, 3, 20);
                    // ghi ra phan tu vi tri thu 6 cua mang REQUIREMENT_OUTPUT_FILES bang req7
                    writeFile(REQUIREMENT_OUTPUT_FILES[6], req7);
                    // out truong hop
                    break;
            }
        }
    }

    // sau khi chay phuong thuc main xong se chay phuong thuc writeFile khi duoc goi
    // den
    public static <E> boolean writeFile(String path, ArrayList<E> rows) {
        // tao cap try catch de truy xuat loi ra man hinh cho chung ta dễ nhận diện và fix
        try {
            // tao mot doi tuong writer kiểu FileWriter cua package java.io
            FileWriter writer = new FileWriter(path);
            // duyet qua tung phan tu row so voi rows <=> for (int row = 1; row <= rows;
            // row++)
            for (E row : rows) {
                // ghi ra tung dong cua tham so duoc truyen vao file txt trong folder
                // output(output duoc tao bang duong dan co gia tri la cac phan tu cua
                // REQUIREMENT_OUTPUT_FILES) bang phuong thuc write cua lop Writer trong goi
                // java.io
                writer.write(row.toString());
                // Ký tự \r\n voi "\r" la carriage return va "\n" line feed, đại diện cho việc
                // xuống dòng trên nền tảng Windows bang phuong thuc write cua lop Writer trong
                // goi java.io.
                writer.write("\r\n");
            }
            // Dong cac phuong thuc write/flush bang phuong thuc close cua lop
            // OutputStreamWriter, neu co tinh goi method write/flush thi se quang ra loi
            // IOException
            writer.close();
            // In ra dong thong bao tao file thanh cong
            System.out.println("Successfully wrote to the file.");
        }
        // Bat loi I/O bang method IOException trong goi java.io de thong bao cho chung
        // ta biet loi do nam o input/output
        catch (IOException e) {
            // In ra dong thong bao Error
            System.out.println("Error.");
            // Tra ve false theo dung kieu du lieu cua method writeFile
            return false;
        }
        // Bat loi tong quat bang lop Exception trong goi java.lang de thong bao cho
        // chung ta biet loi do nam o dau do trong cac lop cua project
        catch (Exception e) {
            // In ra dong Cannot write file bao cho nguoi dung la khong the tao tep
            System.out.println("Cannot write file");
            // Tra ve false theo dung kieu du lieu cua method writeFile
            return false;
        }
        // Tra ve true theo dung kieu du lieu cua method writeFile
        return true;
    }
}
