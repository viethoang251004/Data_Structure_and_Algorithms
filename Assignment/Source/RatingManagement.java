import java.io.*;
import java.util.*;
// import java.util.stream.*;

public class RatingManagement {
    // thiet lap ba thuoc tinh ratings, movies, users theo datatype ArrayList<Rating>, ArrayList<Movie>, ArrayList<User>
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    // Phuong thuc khoi tao truyen RatingManagement cua lop RatingManagement truyen vao 3 tham so la moviePath, ratingPath, userPath
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        // gan cho thuoc tinh movies cua lop RatingManagement la method loadMovies voi tham so moviePath duoc truyen vao
        this.movies = loadMovies(moviePath);
        // gan cho thuoc tinh users cua lop RatingManagement la method loadUsers voi tham so userPath duoc truyen vao
        this.users = loadUsers(userPath);
        // gan cho thuoc tinh ratings cua lop RatingManagement la method loadEdgeList voi tham ratingPath duoc truyen vao
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        /* code here */
        // tao mot doi tuong moi la list_of_ratings voi datatype ghep la ArrayList<Rating>
        ArrayList<Rating> list_of_ratings = new ArrayList<>();
        // tao cap try catch de truy xuat loi ra man hinh cho chung ta dễ nhận diện và fix
        // trong lenh try tao mot doi tuong reader voi datatype la BufferedReader cua package java.io voi tham so dau vao la ratingPath duoc truyen vao method cua FileReader cua lop FileReader trong package java.io
        try (BufferedReader reader = new BufferedReader(new FileReader(ratingPath))) {
            // tao doi tuong line voi datatype la String
            String line;
            // Bo dong dau tien(header)
            // reader.readLine() doc mot dong tu BufferedReeader nhung gia tri cua dong nay duoc bo qua vi dong dau tien trong file csv la tieu de, sau do doc cac dong con lai
            reader.readLine();
            // tao mot vong lap while voi dieu kien la doi tuong line duoc gan gia tri mot dong du lieu tu BufferedReader(file ratings.csv) va line khac null
            while ((line = reader.readLine()) != null) {
                // tao mot mang parts voi datatype la String gom cac phan tu duoc phan cach bang dau phay lay tu file ratings.csv
                String[] parts = line.split(",");
                // tao mot doi tuong moi ten la id_user voi datatype la int va gan cho no phan tu dau tien cua mang voi method ep kieu sang kieu int ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                int id_user = Integer.parseInt(parts[0].trim());
                // tao mot doi tuong moi ten la id_movie voi datatype la int va gan cho no phan tu thu hai cua mang voi method ep kieu sang kieu int ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                int id_movie = Integer.parseInt(parts[1].trim());
                // tao mot doi tuong moi ten la rating_score voi datatype la int va gan cho no phan tu thu ba cua mang voi method ep kieu sang kieu int ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                int rating_score = Integer.parseInt(parts[2].trim());
                // tao mot doi tuong moi ten la timestamp_of_the_rating voi datatype la long va gan cho no phan tu thu tu cua mang voi method ep kieu sang kieu long ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                long timestamp_of_the_rating = Long.parseLong(parts[3].trim());
                // tao mot doi tuong rating voi datatype la Rating voi cac tham so duoc ep kieu phu hop duoc truyen vao method Rating cua lop Rating
                Rating rating = new Rating(id_user, id_movie, rating_score, timestamp_of_the_rating);
                // Them doi tuong rating vua tao vao danh sach list_of_ratings
                list_of_ratings.add(rating);
            }
        }
        // Xu ly ngoai le neu do la ngoai le I/O khi doc file bang cach in thong diep va chi tiet loi
        catch (IOException e) {
            e.printStackTrace();
        }
        // tra ve danh sach danh gia list_of_ratings
        return list_of_ratings;
        // return null; /* change here */
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        /* code here */
        // tao mot doi tuong moi la moviesList (con goi la danh sach bo phim) voi datatype la ArrayList<Movie>
        ArrayList<Movie> moviesList = new ArrayList<>();
        // tao cap try catch de truy xuat loi ra man hinh cho chung ta dễ nhận diện và fix
        // trong lenh try tao mot doi tuong reader voi datatype la BufferedReader cua package java.io voi tham so dau vao la moviePath duoc truyen vao method cua FileReader cua lop FileReader trong package java.io
        try (BufferedReader reader = new BufferedReader(new FileReader(moviePath))) {
            // tao doi tuong line voi datatype la String
            String line;
            // Bo dong dau tien(header)
            // reader.readLine() doc mot dong tu BufferedReeader nhung gia tri cua dong nay duoc bo qua vi dong dau tien trong file csv la tieu de, sau do doc cac dong con lai
            reader.readLine();
            // tao mot vong lap while voi dieu kien la doi tuong line duoc gan gia tri mot dong du lieu tu BufferedReader(file movies.csv) va line khac null
            while ((line = reader.readLine()) != null) {
                // tao mot mang parts voi datatype la String gom cac phan tu duoc phan cach bang dau phay lay tu file movies.csv
                String[] parts = line.split(",");
                // tao mot doi tuong moi ten la id voi datatype la int va gan cho no phan tu dau tien cua mang voi method ep kieu sang kieu int ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                int id = Integer.parseInt(parts[0].trim());
                // tao mot doi tuong moi ten la name voi datatype la String va gan cho no phan tu thu hai cua mang voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                String name = parts[1].trim();
                // tạo một đối tượng ArrayList<String> tên là genres voi tham so truyen vao duoc su dung method asList cua class Arrays trong package java.util voi phan tu thu ba cua movies.csv ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi va method split() duoc phan cach bang dau - lay tu file movies.csv
                ArrayList<String> genres = new ArrayList<>(Arrays.asList(parts[2].trim().split("-")));
                // tao mot doi tuong moi ten la movie voi datatype la Movie va truyen vao 3 tham so do la id(ma so bo phim), name(ten bo phim), genres(danh sach cac the loai bo phim) cua method Movie trong Movie.java
                Movie movie = new Movie(id, name, genres);
                // su dung method add() cua class ArrayList trong package java.util de them doi tuong movie vao danh sach phim(movieList)
                moviesList.add(movie);
            }
        }
        // Xu ly ngoai le neu do la ngoai le I/O khi doc file bang cach in thong diep va chi tiet loi
        catch (IOException e) {
            e.printStackTrace();
        }
        // tra ve danh sach bo phim moviesList
        return moviesList;
        // return null; /* change here */
    }

    private ArrayList<User> loadUsers(String userPath) {
        /* code here */
        // tao mot doi tuong moi la usersList voi datatype ghep la ArrayList<User>
        ArrayList<User> usersList = new ArrayList<>();
        // tao cap try catch de truy xuat loi ra man hinh cho chung ta dễ nhận diện và fix
        // trong lenh try tao mot doi tuong reader voi datatype la BufferedReader cua package java.io voi tham so dau vao la userPath duoc truyen vao method cua FileReader cua lop FileReader trong package java.io
        try (BufferedReader reader = new BufferedReader(new FileReader(userPath))) {
            // tao doi tuong line voi datatype la String
            String line;
            // Bo dong dau tien(header)
            // reader.readLine() doc mot dong tu BufferedReeader nhung gia tri cua dong nay duoc bo qua vi dong dau tien trong file csv la tieu de, sau do doc cac dong con lai
            reader.readLine();
            // tao mot vong lap while voi dieu kien la doi tuong line duoc gan gia tri mot dong du lieu tu BufferedReader(file users.csv) va line khac null
            while ((line = reader.readLine()) != null) {
                // tao mot mang parts voi datatype la String gom cac phan tu duoc phan cach bang dau phay lay tu file users.csv
                String[] parts = line.split(",");
                // tao mot doi tuong moi ten la id voi datatype la int va gan cho no phan tu dau tien cua mang voi method ep kieu sang kieu int ket hop voi method trim() de loai bo khoang trang o 2 dau cua chuoi
                int id = Integer.parseInt(parts[0].trim());
                // tao mot doi tuong moi ten la gender voi datatype la String va gan cho no phan
                // tu thu hai cua mang voi method trim() de loai bo khoang trang o 2 dau cua
                // chuoi
                String gender = parts[1].trim();
                // tao mot doi tuong moi ten la age voi datatype la int va gan cho no phan tu
                // thu 3 cua mang voi method ep kieu sang kieu int ket hop voi method trim() de
                // loai bo khoang trang o 2 dau cua chuoi
                int age = Integer.parseInt(parts[2].trim());
                // tao mot doi tuong moi ten la occupation voi datatype la String va gan cho no
                // phan tu thu 4 cua mang voi method trim() de loai bo khoang trang o 2 dau cua
                // chuoi
                String occupation = parts[3].trim();
                // tao mot doi tuong moi ten la zipCode voi datatype la String va gan cho no
                // phan tu thu 5 cua mang voi method trim() de loai bo khoang trang o 2 dau cua
                // chuoi
                String zipCode = parts[4].trim();
                // tao mot doi tuong moi ten la user voi datatype la User va truyen vao 5 tham
                // so do la id(ma so nguoi dung), gender(gioi tinh), age(tuoi tac),
                // occupation(nghe nghiep) va zipCode(ma buu dien) cua method User trong
                // User.java
                User user = new User(id, gender, age, occupation, zipCode);
                // su dung method add() cua class ArrayList trong package java.util de them doi
                // tuong user vao danh sach nguoi dung(usersList)
                usersList.add(user);
            }
        }
        // Xu ly ngoai le neu do la ngoai le I/O khi doc file bang cach in thong diep va
        // chi tiet loi
        catch (IOException e) {
            e.printStackTrace();
        }
        // tra ve danh sach nguoi dung usersList
        return usersList;
        // return null; /* change here */
    }

    // method lay danh sach bo phim
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    // method lay danh sach nguoi dung
    public ArrayList<User> getUsers() {
        return users;
    }

    // method lay danh sach danh gia
    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {
        /* code here */
        // Lọc ra danh sách các đánh giá của người dùng có UserID đã đánh giá với điểm
        // số lớn hơn hoặc bằng rating
        // tao mot doi tuong moi la userRatings voi datatype ghep la List<Rating>
        List<Rating> userRatings = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tat ca ratings
        for (Rating r : ratings) {
            // Moi lan lap no kiem tra xem method get_id_user() cua class Rating co bang
            // tham so userId truyen vao hay khong va method get_rating_score() cua class
            // Rating co lon hon hoac bang tham so rating truyen vao hay khong
            if (r.get_id_user() == userId && r.get_rating_score() >= rating) {
                // Neu thoa dieu kien thi su dung method add() cua class List trong package
                // java.util de them danh gia do vao danh sach userRatings
                userRatings.add(r);
            }
        }
        // Sau khi vong lap ket thuc thi userRatings sẽ chứa tất cả các đánh giá thỏa
        // mãn điều kiện của userId và rating.

        // Lấy danh sách ID phim từ các đánh giá của người dùng
        // tao mot doi tuong moi la movieIds voi datatype ghep la List<Integer>
        List<Integer> movieIds = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tung danh gia trong danh sach
        // userRatings(danh sach cac danh gia ma nguoi dung co userId da danh gia voi
        // diem so lon hon hoac bang rating)
        // moi lan lap thi no lay id_movie tu danh gia hien tai va them no vao danh sach
        // movieIds
        for (Rating userRating : userRatings) {
            // lay id_movie tu danh gia cua userRating va them no vao danh sach movieIds
            movieIds.add(userRating.get_id_movie());
        }
        // Sau khi vong lap ket thuc thi movieIds se chua tat ca cac id_movie cua cac
        // danh gia ma nguoi dung co userId da danh gia voi diem so lon hon hoac bang
        // rating

        // Lọc ra danh sách các bộ phim có ID thuộc danh sách ID phim của người dùng
        // tao mot doi tuong moi la result voi datatype ghep la List<Movie>
        List<Movie> result = new ArrayList<>();
        // vong lap for-each duyet qua tung bo phim trong danh sach movies
        for (Movie movie : movies) {
            // kiem tra xem id cua bo phim co nam trong danh sach movieIds hay khong
            if (movieIds.contains(movie.getId())) {
                // neu co thi them bo phim vao danh sach result
                result.add(movie);
            }
        }
        // Sau khi vong lap ket thuc thi result se chua danh sach cac bo phim ma nguoi
        // dung co userId da danh gia voi diem so lon hon hoac bang rating

        // Sắp xếp danh sách theo tên theo bảng chữ cái
        result.sort(Comparator.comparing(Movie::getName));

        // return null; /* change here */
        // Trả về danh sách kết quả, chuyển đổi sang ArrayList để đảm bảo trả về kiểu dữ
        // liệu mong muốn
        return new ArrayList<>(result);
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        /* code here */
        // Lọc ra danh sách các đánh giá của người dùng có userId đã đánh giá bộ phim có
        // movieId
        // tao mot doi tuong moi la userRatings voi datatype ghep la List<Rating>
        List<Rating> user_ratings = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tat ca ratings
        for (Rating r : ratings) {
            // Moi lan lap no kiem tra xem method get_id_user() cua class Rating co bang
            // tham so userId truyen vao hay khong va method get_id_movie() cua class
            // Rating co bang tham so movieId truyen vao hay khong
            if (r.get_id_user() == userId && r.get_id_movie() == movieId) {
                // Neu thoa dieu kien thi su dung method add() cua class List trong package
                // java.util de them danh gia do vao danh sach userRatings
                user_ratings.add(r);
            }
        }
        // Sau khi vong lap ket thuc thi userRatings sẽ chứa tất cả các đánh giá thỏa
        // mãn điều kiện của userId và movieId.

        // Lấy số điểm của người dùng có userId cho bộ phim có movieId
        // Method isEmpty() kiem tra danh sach user_ratings co rong hay khong.
        // Neu rong thi tra ve true, nguoc lai tra ve false
        // '?' la toan tu ba ngoi(ternary operator). No kiem tra dieu kien truoc dau
        // '?'. Neu dieu kien la true thi gia tri sau dau '?' duoc su dung, neu dieu
        // kien la false thi gia tri sau dau ':' duoc su dung
        // '0' la gia tri duoc gan cho user_rating_score neu danh sach user_ratings la
        // rong
        // neu danh sach user_rating_score khong rong thi su dung method get() cua class
        // List trong package java.util va method get_rating_score() cua class Rating de
        // lay diem danh gia tu phan tu dau tien cua danh sach.
        int user_rating_score = user_ratings.isEmpty() ? 0 : user_ratings.get(0).get_rating_score();

        // Lọc ra danh sách các người dùng khác có cùng chính xác số điểm
        // tao mot doi tuong moi la result voi datatype ghep la List<User>
        List<User> result = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tat ca ratings
        for (Rating r : ratings) {
            // Moi lan lap no kiem tra xem method get_id_user() cua class Rating co khac
            // tham so userId truyen vao hay khong, method get_id_movie() cua class Rating
            // co bang tham so movieId truyen vao hay khong, method get_rating_score() cua
            // class Rating co bang doi tuong user_rating_score da duoc khoi tao va gan phia
            // tren hay khong.
            if (r.get_id_user() != userId && r.get_id_movie() == movieId && r.get_rating_score() == user_rating_score) {
                // Tìm người dùng có userId và thêm vào danh sách kết quả
                // Neu thoa dieu kien thi vong lap for-each se duoc thuc thi de duyet qua tat ca
                // users
                for (User user : users) {
                    // Moi vong lap for-each se kiem tra xem method getId() cua class User co bang
                    // method get_id_user() cua class Rating hay khong
                    if (user.getId() == r.get_id_user()) {
                        // Neu thoa dieu kien thi su dung method add() cua class List trong package
                        // java.util de them nguoi dung do vao danh sach nguoi dung result
                        result.add(user);
                        // Khi doi tuong user thuoc class User thoa man dieu kien, thoat khoi vong lap
                        // for-each cua users. Dieu nay dam bao rang moi doi tuong cua class User chi
                        // duoc them user mot lan ngay khi no duoc tim thay
                        break;
                    }
                }
            }
        }
        // Sắp xếp danh sách theo tên theo bảng chữ cái
        result.sort(Comparator.comparing(User::getId));
        // Trả về danh sách kết quả, chuyển đổi sang ArrayList để đảm bảo trả về kiểu dữ
        // liệu mong muốn
        return new ArrayList<>(result);
        // return null; /* change here */
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {
        /* code here */
        // Tạo một danh sách để lưu trữ ID phim được ít nhất hai người dùng yêu thích
        // (rating > 3)
        // tao mot doi tuong moi la favorite_movie_ids voi datatype ghep la
        // List<Integer>
        List<Integer> favorite_movie_ids = new ArrayList<>();
        // Tạo một danh sách để lưu trữ số lượng đánh giá tích cực (rating > 3) của từng
        // phim
        // Map<Integer, Integer> khai bao 2 datatype cho key va value cua Map là Integer
        // Trong ngu canh nay thi key la ID cua phim, value la so luong danh gia tich
        // cuc cua phim do
        // positive_rating_counts la ten bien cua Map noi len muc dich cua Hashmap, do
        // la luu tru so luong danh gia tich cuc cho tung phim
        // new HashMap<>() tao doi tuong HashMap moi de luu tru cac cap key-value
        Map<Integer, Integer> positive_rating_counts = new HashMap<>();
        // Lọc và đếm số lượng đánh giá tích cực của từng phim
        // tao mot vong lap for-each duyet qua tat ca ratings
        for (Rating rating : ratings) {
            // Moi lan lap no kiem tra xem method get_rating_score() cua class Rating có lon
            // hon 3 khong
            if (rating.get_rating_score() > 3) {
                // Neu dieu kien la true thi khoi tao bien moi la movieId de lay ID cua phim tu
                // doi tuong Rating la 'rating' bang method get_id_movie() va gan vao movieId
                int movieId = rating.get_id_movie();
                // Neu movieId da co trong positive_rating_counts thi gia tri cua no se dc tang
                // len 1
                // Neu movieId chua co trong positive_rating_counts thi method getOrDefault() se
                // tra ve 0 va sau do 1 dc them vao, ban chat la khoi tao gia tri la 1
                // Giup bang dem dang theo doi so luong danh gia tich cuc cua tung phim
                positive_rating_counts.put(movieId, positive_rating_counts.getOrDefault(movieId, 0) + 1);
            }
        }
        // Lọc ra các phim được ít nhất hai người dùng yêu thích
        // tao mot vong lap for-each duyet qua tat ca cac cap key-value trong
        // positive_rating_counts, trong do key la ID cua phim va value la so luong danh
        // gia tich cuc cua phim do
        // su dung bien entry de tham chieu den tung cap key-value
        for (Map.Entry<Integer, Integer> entry : positive_rating_counts.entrySet()) {
            // Moi lan lap no kiem tra xem method getValue() cua class Map trong package
            // java.util có lon hon hoac bang 2 khong(nghia la kiem tra so luong danh gia
            // tich cuc cua phim co lon hon hoac bang 2 khong)
            // Neu có ít nhất 2 đánh giá tích cực thì đoạn mã trong if sẽ dc thực thi
            if (entry.getValue() >= 2) {
                // neu phim co it nhat 2 danh gia tich cuc thi id cua phim do dc them vao danh
                // sach favorite_movie_ids bang method getKey() trong interface Entry cua class
                // Map trong package java.util
                favorite_movie_ids.add(entry.getKey());
            }
        }
        // Tạo một danh sách để lưu trữ tên của các phim được ít nhất hai người dùng yêu
        // thích
        List<String> result = new ArrayList<>();
        // Lọc tên của các phim từ danh sách các phim được ít nhất hai người dùng yêu
        // thích
        // tao mot vong lap for-each duyet qua tung doi tuong Movie trong danh sach
        // movies
        // moi Movie dai dien cho mot bo phim trong he thong
        for (Movie movie : movies) {
            // Moi lan lap no kiem tra xem favorite_movie_ids(danh sach cac ID cua cac bo
            // phim duoc it nhat hai nguoi dung yeu thich) co chua ID cua bo phim dang xet
            // khong
            if (favorite_movie_ids.contains(movie.getId())) {
                // Neu ID cua bo phim dang xet co trong danh sach favorite_movie_ids thi ten cua
                // bo phim movie.getName() se duoc them vao danh sach ket qua result
                result.add(movie.getName());
            }
        }
        // Sau khi ket thuc vong lap danh sach result se chua ten cua tat ca cac bo phim
        // duoc it nhat hai nguoi dung yeu thich (theo dieu kien rating > 3)
        // Sắp xếp danh sách theo tên theo bảng chữ cái
        result.sort(Comparator.naturalOrder());
        // Trả về danh sách kết quả
        return new ArrayList<>(result);
        // return null; /* change here */
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        /* code here */
        // Lọc ra danh sách các đánh giá từ người dùng có cùng ngành nghề và giới tính
        // tao mot doi tuong moi la userRatings voi datatype ghep la List<Rating>
        List<Rating> user_ratings = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tung doi tuong Rating trong danh sach
        // ratings
        for (Rating r : ratings) {
            // int userId = r.get_id_user() lay ID cua nguoi dung tu danh gia hien tai 'r'
            int userId = r.get_id_user();
            // tao mot doi tuong User la user tuong ung voi tung ID nguoi dung trong danh
            // sach users.
            // vi danh sach users duoc danh so bat dau tu 0 trong mang ma ID nguoi dung
            // thuong bat dau bang 1 nen chung ta su dung userId - 1 de lay dung vi tri cua
            // nguoi dung trong danh sach users
            User user = users.get(userId - 1); // Vì ID user bắt đầu từ 1
            // Moi lan lap no kiem tra trong menh de if coi thong tin ve nguoi dung
            // (occupation va gender) va diem danh gia co khop voi dieu kien de bai dat ra
            // khong
            // user.getOccupation().equals(occupation) so sanh nganh nghe cua nguoi dung voi
            // gia tri cua occupation truyen vao method equals() cua class String trong
            // package java.lang
            // user.getGender().equals(gender) so sanh gioi tinh cua nguoi dung voi gia tri
            // cua gender truyen vao method equals() cua class String trong package
            // java.lang
            // r.get_rating_score() == rating so sanh diem danh gia hien tai 'rating_score'
            // voi gia tri 'rating' truyen vao
            if (user.getOccupation().equals(occupation) && user.getGender().equals(gender)
                    && r.get_rating_score() == rating) {
                // Neu thoa dieu kien thi danh gia hien tai duoc them vao danh sach danh gia
                // nguoi dung userRatings
                user_ratings.add(r);
            }
        }

        // Lấy danh sách ID phim từ các đánh giá của người dùng
        List<Integer> movie_Ids = new ArrayList<>();
        for (Rating userRating : user_ratings) {
            movie_Ids.add(userRating.get_id_movie());
        }

        // Lọc ra danh sách các bộ phim có ID thuộc danh sách ID phim của người dùng
        // tao mot doi tuong moi la result voi datatype ghep la List<Movie>
        List<Movie> result = new ArrayList<>();
        // tao mot vong lap for-each duyet qua tung doi tuong Movie trong danh sach
        // movies
        // moi Movie dai dien cho mot bo phim trong he thong
        for (Movie movie : movies) {
            // Moi lan lap no kiem tra xem movieIds(danh sach cac ID cua cac bo phim phu hop
            // voi nghe nghiep va gioi tinh) co chua ID cua bo phim dang xet khong
            if (movie_Ids.contains(movie.getId())) {
                // Neu ID cua bo phim dang xet co trong danh sach movieIds bo phim 'movie' do se
                // duoc them vao danh sach ket qua result
                result.add(movie);
            }
        }
        // Sắp xếp danh sách theo tên theo bảng chữ cái
        Collections.sort(result, Comparator.comparing(Movie::getName));
        // Chỉ giữ lại tối đa k bộ phim
        if (result.size() > k) {
            // method subList(0,k) cua class List trong package java.util tra ve mot phan
            // cua danh sach tu vi tri 0 den k-1
            result = result.subList(0, k);
        }
        // Tao mot bien finalResult voi datatype la ArrayList<String> de chua ten cac bo
        // phim
        ArrayList<String> final_result = new ArrayList<>();
        // Tao vong lap for-each duyet qua tung doi tuong Movie trong danh sach result
        // Moi Movie la mot doi tuong dai dien cho mot bo phim
        for (Movie movie : result) {
            // Voi moi lan lap thi no se lay ten cua bo phim bang cach goi method getName()
            // cua class Movie trong danh sach result
            // Sau do them ten cua bo phim nay vao danh sach 'finalResult'
            final_result.add(movie.getName());
        }
        // Trả về danh sách kết quả
        return final_result;
        // return null; /* change here */
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        /* code here */
        // Lọc ra danh sách các ID của người dùng (userIDs) có nghề nghiệp (occupation)
        // bằng với giá trị được truyền vào phương thức.
        // tao mot doi tuong moi la userIDs voi datatype ghep la List<Integer>
        List<Integer> user_IDs = new ArrayList<>();
        // Tao vong lap for-each duyet qua tung doi tuong User trong danh sach users
        // Moi User la mot doi tuong dai dien cho mot nguoi dung
        for (User user : users) {
            // Voi moi lan lap thi no kiem tra xem nghe nghiep cua nguoi dung hien tai
            // user.getOccupation() co phai la nghe nghiep cua tham so occupation duoc
            // truyen vao method hay khong
            if (user.getOccupation().equals(occupation)) {
                // Neu co thi them ID cua nguoi dung vao danh sach userIDs\
                // Neu khong thi bo qua nguoi dung do va tiep tuc voi nguoi dung tiep theo trong
                // loop
                user_IDs.add(user.getId());
            }
        }
        // Sau khi ket thuc vong lap thi userIDs se chua cac ID cua nhung nguoi dung co
        // nghe nghiep la tham so occupation duoc truyen vao method
        // findMoviesByOccupationAndLessThanRating()

        // tao mot doi tuong moi la movieIDs voi datatype ghep la List<Integer>
        List<Integer> movie_IDs = new ArrayList<>();
        // Tao vong lap for-each duyet qua tung doi tuong Rating trong danh sach ratings
        // Moi Rating la mot doi tuong dai dien cho mot danh gia ve mot bo phim tu mot
        // nguoi dung
        for (Rating r : ratings) {
            // Voi moi lan lap thi no kiem tra xem ID cua nguoi dung tu danh gia hien tai co
            // namm trong danh sach user_IDs hay khong bang
            // user_IDs.contains(r.get_id_user())
            // Neu co thi danh gia nay thuoc ve mot nguoi dung co nghe nghiep da duoc xac
            // dinh truoc do(do user_IDs duoc su dung truoc do roi)
            // r.get_rating_score() < rating dung de kiem tra diem danh gia rating_score
            // bang method get_rating_score() cua class Rating co nho hon gia tri rating
            // truyen vao method findMoviesByOccupationAndLessThanRating() hay khong
            if (user_IDs.contains(r.get_id_user()) && r.get_rating_score() < rating) {
                // neu thoa dieu kien thi them ID cua phim vao danh sach movie_IDs
                movie_IDs.add(r.get_id_movie());
            }
        }
        // Sau khi ket thuc vong lap thi movie_IDs se chua cac ID cua phim thoa man dieu
        // kien cua vong lap

        // tao mot doi tuong moi la result voi datatype ghep la List<Movie>
        List<Movie> result = new ArrayList<>();
        // Tao vong lap for-each duyet qua tung doi tuong Movie trong danh sach movies
        // Moi Movie la mot doi tuong dai dien cho mot bo phim trong he thong
        for (Movie movie : movies) {
            // Voi moi lan lap thi no kiem tra xem ID cua bo phim hien tai movie.getId() co
            // nam trong danh sach movie_IDs hay khong
            // Neu ID cua bo phim hien tai nam trong danh sach movie_IDs, dieu nay co nghia
            // la day la mot bo phim ma nguoi dung voi nghe nghiep da duoc xac dinh truoc do
            // da danh gia duoi muc diem rating
            if (movie_IDs.contains(movie.getId())) {
                // Neu thoa man dieu kien thi them doi tuong movie vao danh sach result
                result.add(movie);
            }
        }
        // Sau khi ket thuc vong lap result se chua danh sach cac bo phim ma nguoi dung
        // voi nghe nghiep da duoc xac dinh truoc do da danh gia duoi muc diem duoc yeu
        // cau

        // Sắp xếp danh sách theo tên theo bảng chữ cái
        result.sort(Comparator.comparing(Movie::getName));

        // Chỉ giữ lại tối đa k bộ phim
        if (result.size() > k) {
            // method subList(0,k) cua class List trong package java.util tra ve mot phan
            // cua danh sach tu vi tri 0 den k-1
            result = result.subList(0, k);
        }

        // Tao mot bien finalResult voi datatype la ArrayList<String> de chua ten cac bo
        // phim
        ArrayList<String> finalResult = new ArrayList<>();
        // Tao vong lap for-each duyet qua tung doi tuong Movie trong danh sach result
        // Moi Movie la mot doi tuong dai dien cho mot bo phim
        for (Movie movie : result) {
            // Voi moi lan lap thi no se lay ten cua bo phim bang cach goi method getName()
            // cua class Movie trong danh sach result
            // Sau do them ten cua bo phim nay vao danh sach 'finalResult'
            finalResult.add(movie.getName());
        }

        // Trả về danh sách kết quả
        return finalResult;
        // return null; /* change here */
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        /* code here */
        // List<Rating> userRatings = new ArrayList<>();

        // tao mot doi tuong moi la user_genres voi datatype ghep la Set<String>
        // luu tru the loai cua bo phim duoc xep hang gan day nhat cua nguoi dung
        //HashSet duoc su dung de dam bao rang khong co the loai nao bi trung lap trong tap hop
        Set<String> user_genres = new HashSet<>();
        //khoi tao bien latest_timestamp de theo doi thoi diem xep hang gan day nhat cua nguoi dung
        //gan cho no bang 0
        long latest_timestamp = 0;

        // Find user's latest rated movie and genres
        // Tao vong lap for-each duyet qua tat ca danh gia trong danh sach ratings
        // Moi Rating la mot doi tuong dai dien cho mot danh gia trong he thong
        for (Rating r : ratings) {
            // Voi moi lan lap thi no kiem tra xem danh gia nay co thuoc ve userId hay khong va co thoi diem xep hang lon hon thoi diem xep hang gan day nhat hay khong
            if (r.get_id_user() == userId && r.get_timestamp_of_the_rating() > latest_timestamp) {
                // Neu thoa dieu kien thi cap nhat gia tri latest_timestamp voi thoi diem xep hang moi nhat
                latest_timestamp = r.get_timestamp_of_the_rating();
                // Cap nhat user_genres la the loai cua bo phim duoc xep hang gan day nhat bang cach tao mot HashSet moi
                user_genres = new HashSet<>(getMovieGenres(r.get_id_movie()));
            }
        }
        // Find movies rated by users with the same gender, higher rating, and at least one common genre
        // tao mot doi tuong moi la result voi datatype ghep la List<String>
        List<String> result = new ArrayList<>();
        // Tao vong lap for-each duyet qua tat ca danh gia trong danh sach ratings
        // Moi Rating la mot doi tuong dai dien cho mot danh gia trong he thong
        for (Rating r : ratings) {
            // Voi moi lan lap thi no kiem tra xem danh gia dang xet khong thuoc ve nguoi dung hien tai bang r.get_id_user() != userId\
            // Va chi xet cac bo phim co diem xep hang r.get_rating_score() lon hon hoac bang tham so rating truyen vao method findMoviesMatchLatestMovieOf()
            if (r.get_id_user() != userId && r.get_rating_score() >= rating) {
                // Neu thoa dieu kien thi tao mot List<String> ten la movieGenres va gan gia tri cho no bang viec goi ham getMovieGenres(r.get_id_movie())
                //Ham getMovieGenres() dung de lay danh sach the loai cua mot bo phim dua tren movieId
                List<String> movieGenres = getMovieGenres(r.get_id_movie());
                // Va tiep tuc kiem tra xem bo phim co it nhat mot the loai chung voi bo phim duoc xep hang gan day nhat cua nguoi dung
                if (hasCommonGenre(user_genres, movieGenres)) {
                    // Neu thoa dieu kien thi ten cua bo phim duoc them vao danh sach result thong qua result.add(getMovieName(r.get_id_movie()));
                    //Ham getMovieName() lay ten cua bo phim tu danh sach movies dua tren movieId cua danh gia hien tai
                    result.add(getMovieName(r.get_id_movie()));
                }
            }
        }
        //Sau khi ket thuc vong lap thi danh sach result chua cac ten bo phim thoa man cac dieu kien da neu tren

        // Remove duplicates and sort alphabetically
        // Mot HashSet duoc tao ra voi cac phan tu tu danh sach result
        //HashSet tu dong loai bo cac phan tu trung lap, giu lai chi mot ban sao cua moi phan tu duy nhat
        Set<String> uniqueMovies = new HashSet<>(result);
        // Cac phan tu cua uniqueMovies duoc chuyen doi thanh mot ArrayList moi sortedMovies
        List<String> sortedMovies = new ArrayList<>(uniqueMovies);
        // Sau do sortedMovies duoc sap xep theo thu tu bang chu cai
        Collections.sort(sortedMovies);
        // Trim the result to the top k movies
        // Neu so luong phan tu trong sortedMovies lon hon gia tri k thi chi lay k phan tu dau tien
        // Giup dam bao rang danh sach ket qua cuoi cung chi chua toi da k bo phim
        if (sortedMovies.size() > k) {
            sortedMovies = sortedMovies.subList(0, k);
        }
        //Ket qua cuoi cung la mot doi tuong ArrayList<String>
        return new ArrayList<>(sortedMovies);
    }

    // Helper method to get genres of a movie
    private List<String> getMovieGenres(int movieId) {
        //Tao mot vong lap for-each duyet qua danh sach cac doi tuong Movie trong movies
        for (Movie movie : movies) {
            //Neu ID cua mot doi tuong Movie trung khop voi movieId truyen vao thi tra ve danh sach the loai cua bo phim do bang movie.getGenres()
            if (movie.getId() == movieId) {
                return movie.getGenres();
            }
        }
        //Neu khong tim thay doi tuong Movie nao voi ID tuong ung thi tra ve mot danh sach rong bang method emptyList cua class Collections trong package java.util
        return Collections.emptyList();
    }
    // Helper method to get the name of a movie
    // Tuong tu method getMovieGenres
    private String getMovieName(int movieId) {
        //Tao mot vong lap for-each duyet qua danh sach cac doi tuong Movie trong movies
        for (Movie movie : movies) {
            //Neu ID cua mot doi tuong Movie trung khop voi movieId truyen vao thi tra ve ten cua bo phim do bang movie.getName()
            if (movie.getId() == movieId) {
                return movie.getName();
            }
        }
        //Neu khong tim thay doi tuong Movie nao voi ID tuong ung thi tra ve mot chuoi rong
        return "";
    }
    // Helper method to check if there is at least one common genre between two lists
    private boolean hasCommonGenre(Set<String> genres1, List<String> genres2) {
        //Duyet qua tung phan tu trong danh sach genres2
        for (String genre : genres2) {
            //Neu mot phan trong genres2 cung co trong genres1 thi tra ve true
            if (genres1.contains(genre)) {
                //Nghia la co it nhat mot the loai chung
                return true;
            }
        }
        //Neu khong co the loai nao chung thi tra ve false
        return false;
    
    }
}
