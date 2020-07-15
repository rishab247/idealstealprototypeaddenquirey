package com.example.idealstealprototypeaddenquirey.data;

import java.io.Serializable;

public class Measuredata implements Serializable {
    private String size;
    private String pieces;

    public Measuredata(String size, String pieces) {
        this.size = size;
        this.pieces = pieces;
    }

    public Measuredata() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }
}
