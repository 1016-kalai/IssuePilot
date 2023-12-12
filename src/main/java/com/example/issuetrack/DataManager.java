package com.example.issuetrack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataManager {
    private static ObservableList<Data> jobList = FXCollections.observableArrayList();

    public static ObservableList<Data> getJobList() {
        return jobList;
    }

    public static void addJob(Data job) {
        jobList.add(job);
    }

    public static void clear() {
        jobList.clear();
    }
}
