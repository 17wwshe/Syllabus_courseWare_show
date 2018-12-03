package com.example.administratior.syllabus_courseware_show;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<Map<String,Object>> dataList;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<>();
        listView= (ListView)findViewById(R.id.list_View);
        String jsonData = "{\n" +
                "\t\"files\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"fileId\":\"124646\",\n" +
                "\t\t\t\"fileKind\":\"powerpoint\",\n" +
                "\t\t\t\"fileLink\":\"https://my.stu.edu.cn/courses/campus/mod/resource/view.php?id=124646\",\n" +
                "\t\t\t\"fileName\":\"16-dsl-绪论\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"fileId\":\"124647\",\n" +
                "\t\t\t\"fileKind\":\"pdf\",\n" +
                "\t\t\t\"fileLink\":\"https://my.stu.edu.cn/courses/campus/mod/resource/view.php?id=124647\",\n" +
                "\t\t\t\"fileName\":\"数据结构题集 C语言 于津 陈银冬\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"folders\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"folderLink\":\"https://my.stu.edu.cn/courses/campus/mod/folder/view.php?id=137583\",\n" +
                "\t\t\t\"folderLinkId\":\"135783\",\n" +
                "\t\t\t\"folderName\": \"第01讲课件\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"folderLink\":\"https://my.stu.edu.cn/courses/campus/mod/folder/view.php?id=140824\",\n" +
                " \t\t\t\"folderLinkId\": \"140824\",\n" +
                " \t\t\t\"folderName\": \"第3次实验课\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        DataWork dataWork = new DataWork();
        dataWork.setData(jsonData);
        dataList = dataWork.getData();
//        Log.d("datalist-------",dataList.toString());
        SimpleAdapter simpleAdapter =new SimpleAdapter(
                this,
                dataList,
                R.layout.item,
                new String[]{"fileImg","fileName"},
                new int[]{R.id.ig_kind,R.id.tv_name});
        listView.setAdapter(simpleAdapter);

    }

}
