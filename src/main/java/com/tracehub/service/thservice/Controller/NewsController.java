package com.tracehub.service.thservice.Controller;

import com.tracehub.service.thservice.Data.News;
import com.tracehub.service.thservice.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NewsController {
    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/community")
    public List<News> accessCommunity(){
        List<News> news=newsRepository.findAll();
        return news;
    }

    @PostMapping("/share")
    public Map<String,String> shareNews(@RequestBody News news){
        Map<String,String> msg = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        news.setCreat_time(format.format(date));
        int random= (int) (Math.random() * 100);
        news.setLike_count(random);
        newsRepository.save(news);
        msg.put("msg","success");
        return msg;
    }
}
