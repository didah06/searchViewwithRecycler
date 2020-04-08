package com.example.searchviewrecycler;

class DataFilter {
    private String Nama;
    private int ImageID;

    DataFilter(){
        this.Nama = Nama;
        this.ImageID = ImageID;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
