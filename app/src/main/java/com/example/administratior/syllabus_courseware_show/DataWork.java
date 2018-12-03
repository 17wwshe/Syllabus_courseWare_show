package com.example.administratior.syllabus_courseware_show;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administratior on 2018/12/3.
 */

public class DataWork {

    private List<FileData> fileDataList;
    private List<FolderData> folderDataList;
    private List<Map<String, Object>> dataList = new ArrayList<>();

    public void setData(String jsonData) {
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonData, Person.class);
        fileDataList = person.getFiles();
        folderDataList = person.getFolders();
//        Log.d("fileData-------",fileDataList.toString());
//        Log.d("fileData-------",folderDataList.toString());
    }

    public List<Map<String, Object>> getData() {
        try {
            JSONArray fileArray = new JSONArray(fileDataList.toString());
            for (int i = 0; i < fileArray.length(); i++) {
                Map<String, Object> map = new HashMap<>();
                JSONObject jsonObject = fileArray.getJSONObject(i);
                if (null != jsonObject) {
                    String fileName = jsonObject.optString("fileName");
                    String fileId = jsonObject.optString("fileId");
                    String fileLink = jsonObject.optString("fileLink");
                    String fileKind = jsonObject.optString("fileKind");
                    map.put("fileName", fileName);
                    map.put("fileId", fileId);
                    map.put("fileLink", fileLink);
//                    Log.d("fileKind--------",fileKind);
                    switch (fileKind) {
                        case "document":
                            map.put("fileImg", R.mipmap.wordx);
                            break;
                        case "pdf":
                            map.put("fileImg", R.mipmap.pdfx);
                            break;
                        case "powerpoint":
                            map.put("fileImg", R.mipmap.pptx);
                            break;
                        case "zip":
                            map.put("fileImg", R.mipmap.zipx);
                            break;
                        case "video":
                            map.put("fileImg", R.mipmap.videox);
                            break;
                        case "excel":
                            map.put("fileImg", R.mipmap.excel);
                            break;
                        default:
                            map.put("fileImg", R.mipmap.allx);
                    }
                    dataList.add(map);

                }
            }
            JSONArray folderArray = new JSONArray(folderDataList.toString());
            for (int j = 0; j < folderArray.length(); j++) {
                JSONObject jsonObject2 = folderArray.getJSONObject(j);
                Map<String, Object> map = new HashMap<>();
                if (null != jsonObject2) {
                    String folderName = jsonObject2.optString("folderName");
                    String folderLinkId = jsonObject2.optString("folderLinkId");
                    String folderLink = jsonObject2.optString("folderLink");
                    map.put("fileName", folderName);
                    map.put("fileId", folderLinkId);
                    map.put("fileLink", folderLink);
                    map.put("fileKind", "folder");
                    map.put("fileImg", R.mipmap.allx);
                }
                dataList.add(map);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
