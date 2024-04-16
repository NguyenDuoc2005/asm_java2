package models;

public class Student {

    private String maSV;
    private String hoTen;
    private String email;
    private String sdt;
    private Boolean gioiTinh; // true nam false nữ
    private String diaChi;
    private String hinhAnh;

    public Student(String maSV, String hoTen, String email, String sdt, Boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public Student() {
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public Object[] toDataRow(){
        return new Object[]{
            maSV,hoTen,email,sdt,gioiTinh==true?"Nam":"nữ",diaChi,hinhAnh
        };
    }
}
