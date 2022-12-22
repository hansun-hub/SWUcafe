//swucafe_2020111324_김한선_2022-12-15
package com.android.swucafe;

//note클래스 생성 후, 객체로 사용함
public class Note {

    //변수들_ 리사리클러뷰 개별 항목에 들어감
    int _id;
    String kcal;
    String locationX;
    String locationY;
    String contents;
    String img;
    String descript;

    //Note 클래스 생성자
    public Note(int _id, String kcal, String locationX, String locationY, String contents, String img, String descript) {
        this._id = _id;
        this.kcal = kcal;
        this.locationX = locationX;
        this.locationY = locationY;
        this.contents = contents;
        this.img = img;
        this.descript = descript;
    }

    //Note 클래스 오버라이드한 메서드들
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public void add(Note item) {
    }
}
