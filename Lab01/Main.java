public class Main {  
    public static void main(String[] args) {  
        // Tạo đối tượng NhanVien bằng khởi tạo mặc định  
        NhanVien nv1 = new NhanVien();  

        // Tạo đối tượng NhanVien bằng khởi tạo với tham số  
        NhanVien nv2 = new NhanVien("Bui Xuan Huan", 1.0);  

        // In thông tin nhân viên  
        nv1.inTTin();  
        System.out.println(); 

        nv2.inTTin();  

    }  
}  