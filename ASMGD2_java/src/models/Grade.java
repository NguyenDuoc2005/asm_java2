
package models;


public class Grade extends Student{
    private String id; 
    private String maSV;
    private int tiengAnh; 
    private int tinHoc; 
    private int GDTC; 
    private String hoTen;
    private float diemTB; 

    public Grade() {
    }

    public Grade(String maSV, int tiengAnh, int tinHoc, int GDTC) {
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    
    
    public Grade(String id, String maSV, int tiengAnh, int tinHoc, int GDTC, String hoTen, float diemTB) {
        this.id = id;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGDTC() {
        return GDTC;
    }

    public void setGDTC(int GDTC) {
        this.GDTC = GDTC;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }
    

    public float getDiemTB(){
        
        return Math.round(diemTB*100f)/100f;
    }
    public Object[] toDataRow(){
        return new Object[]{
            maSV,hoTen,tiengAnh,tinHoc,GDTC,getDiemTB()
        };
    }
        
        
    
}
