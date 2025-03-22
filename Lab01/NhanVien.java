class NhanVien {  
    private String tenNhanVien; // Tên nhân viên  
    private double luongCoBan; // Lương cơ bản  
    private double heSoLuong; // Hệ số lương  
    public static final double LUONG_MAX = 30000000; // Lương tối đa  
    
    private static final double LUONG_CO_BAN = 1200000; // Lương cơ bản 

    // Phương thức khởi tạo mặc định  
    public NhanVien() {  
        this.tenNhanVien = "NONAME";  
        this.heSoLuong = 1.0;  
    }  

    // Phương thức khởi tạo với 2 tham số  
    public NhanVien(String ten, double heSo) {  
        this.tenNhanVien = ten;  
        this.heSoLuong = heSo;  
    }  

    // Phương thức tính lương  
    public double tinhLuong() {  
        return LUONG_CO_BAN * heSoLuong;  
    }  

    // Phương thức tăng hệ số lương  
    public boolean tangHeSoLuong(double tang) {  
        double luongMoi = tinhLuong() + (LUONG_CO_BAN * tang);  
        if (luongMoi > LUONG_MAX) {  
            System.out.println("Không thể tăng hệ số lương, lương vượt quá giới hạn cho phép.");  
            return false;  
        } else {  
            heSoLuong += tang;  
            return true;  
        }  
    }  

    // Phương thức in thông tin  
    public void inTTin() {  
        System.out.println("Tên nhân viên: " + tenNhanVien);  
        System.out.println("Hệ số lương: " + heSoLuong);  
        System.out.println("Lương cơ bản: " + LUONG_CO_BAN);  
        System.out.println("Lương hiện tại: " + tinhLuong());  
    }  
}  