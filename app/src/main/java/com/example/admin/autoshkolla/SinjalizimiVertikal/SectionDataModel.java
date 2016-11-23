package com.example.admin.autoshkolla.SinjalizimiVertikal;


import java.util.ArrayList;

public class SectionDataModel {


    private String headerTitle;
    private ArrayList<SingleItemModel> allItemsInSection;

//
//    public SectionDataModel() {
//
//    }
//    public SectionDataModel(String headerTitle, ArrayList<SingleItemModel> allItemsInSection) {
//        this.headerTitle = headerTitle;
//        this.allItemsInSection = allItemsInSection;
//    }


    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItemModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItemModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
