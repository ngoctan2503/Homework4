import java.io.*;
import java.util.*;

class Student {
    String maSinhVien;
    String hoTen;
    String gioiTinh;
    double diemPython;
    double diemJava;
    double diemTB;
    String ketQua;

    public Student(String maSinhVien, String hoTen, String gioiTinh, double diemPython, double diemJava) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemPython = diemPython;
        this.diemJava = diemJava;
        this.diemTB = (diemJava * 2 + diemPython) / 3;
        if (diemTB >= 5) {
            this.ketQua = "Đậu";
        } else if (gioiTinh.equals("Nam")) {
            this.ketQua = "Trượt";
        } else {
            this.ketQua = "Đậu";
        }
    }

    public String toString() {
        return maSinhVien + "\t" + hoTen + "\t" + gioiTinh + "\t" + diemPython + "\t" + diemJava + "\t" + diemTB + "\t" + ketQua;
    }
}


