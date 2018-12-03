package com.example.administratior.syllabus_courseware_show;

import java.util.List;

/**
 * Created by Administratior on 2018/12/3.
 */

public class Person {

    private List<FileData> files;
    private List<FolderData> folders;

    Person(List<FileData> files,List<FolderData> folders){
        this.files = files;
        this.folders = folders;
    }

    List<FileData> getFiles(){
        return files;
    }

    List<FolderData> getFolders(){
        return folders;
    }

    public String toString(){
        return  "files:" + files+
                "\nfolders:" + folders;
    }
}
