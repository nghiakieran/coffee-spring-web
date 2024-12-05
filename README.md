# Coffee Spring Web Application

## Giới thiệu

Coffee Spring Web là một ứng dụng web được xây dựng bằng Spring Boot, phục vụ cho việc quản lý hoạt động kinh doanh của quán cà phê.

## Công nghệ sử dụng

- Java 17
- Maven
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Java Email
- Dịch vụ Cloudinary

## Cài đặt và Chạy ứng dụng

### Yêu cầu hệ thống

- JDK 17 trở lên
- Maven 3.6.x trở lên

### Các bước cài đặt

1. Clone repository về máy:

```bash
git clone https://github.com/nghiakieran/coffee-spring-web.git
```

2. Di chuyển vào thư mục dự án:

```bash
cd coffee-spring-web
```

3. Configure database:
   spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/coffeeshop1
   spring.datasource.username=username
   spring.datasource.password=password

4. Chạy ứng dụng bằng Maven:

```bash
mvn clean install
mvn spring-boot:run
```

Ứng dụng sẽ chạy tại địa chỉ: `http://localhost:8080`

## Cấu trúc dự án

```
coffee-spring-web/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/nghia/coffee_spring_web/
│   │   ├── resources/
│   │   └── webapp/
│   └── test/
├── pom.xml
└── README.md
```

## Chức năng chính

### Khách (Guest)

- Đăng ký tài khoản mới
  - Điền thông tin cá nhân
  - Xác thực email
  - Tạo mật khẩu an toàn
- Đăng nhập vào hệ thống
- Xem danh sách và chi tiết sản phẩm
  - Tìm kiếm sản phẩm theo tên
  - Xem giá và thông tin chi tiết

### Người dùng (User)

- Quản lý tài khoản
  - Đăng nhập/Đăng xuất
  - Cập nhật thông tin cá nhân
  - Đổi mật khẩu
- Mua sắm trực tuyến
  - Thêm sản phẩm vào giỏ hàng
  - Chỉnh sửa số lượng sản phẩm
  - Thanh toán đơn hàng
- Quản lý đơn hàng
  - Xem lịch sử đơn hàng
  - Theo dõi trạng thái đơn hàng
  - Hủy đơn hàng (nếu chưa xử lý)

### Quản trị viên (Admin)

- Quản lý sản phẩm
  - Thêm/sửa/xóa sản phẩm
  - Quản lý danh mục
  - Cập nhật giá và tồn kho
- Quản lý đơn hàng
  - Xem tất cả đơn hàng
  - Cập nhật trạng thái đơn hàng
  - Xuất báo cáo bán hàng
- Quản lý người dùng
  - Xem danh sách khách hàng
  - Khóa/mở khóa tài khoản
  - Phân quyền người dùng
- Quản lý nhân viên
  - Thêm/sửa/xóa thông tin nhân viên
  - Phân công công việc
  - Theo dõi hiệu suất

## Tác giả

- Chi Nghia, Quoc Nam
- Email: lechinghia202@gmail.com
- Email: namle022004@gmail.com
