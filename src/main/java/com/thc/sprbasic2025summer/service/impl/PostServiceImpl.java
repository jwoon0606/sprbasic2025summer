package com.thc.sprbasic2025summer.service.impl;

import com.thc.sprbasic2025summer.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    int tempId = 0;
    List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        HashMap<String, Object> post = new HashMap<>();
        post.put("id", ++tempId);
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);

        list.add(post);

        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("id", tempId);
        returnMap.put("code", 200);

        return returnMap;
    }

    @Override
    public List<Map<String, Object>> list() {
        return list;
    }

    @Override
    public Map<String, Object> detail(int id) {
        return getPost(id);
    }

    @Override
    public Map<String, Object> update(Map<String, Object> param) {
        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());
        Map<String, Object> mapPost = getPost(id);
        if(mapPost != null) {
            code = 200;
            String title = param.get("title").toString();
            String content = param.get("content").toString();
            String author = param.get("author").toString();
            mapPost.put("title",title);
            mapPost.put("content",content);
            mapPost.put("author",author);
        }

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", code);
        return returnMap;
    }

    @Override
    public Map<String, Object> delete(int id) {
        int code = 0;
        Map<String, Object> tempPost = getPost(id);
        if(tempPost != null) {
            code = 200;
            tempPost.put("id",null);
            cleanList();
        }

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code",code);
        return returnMap;
    }

    public Map<String, Object> getPost(int id) {
        for (Map<String, Object> each : list) {
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId == id) return each;
        }

        return null;
    }

    private void cleanList() {
        int tempI = -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).get("id") == null) {
                tempI = i;
            }
        }

        if(tempI != -1) {
            list.remove(tempI);
        }
    }
}
