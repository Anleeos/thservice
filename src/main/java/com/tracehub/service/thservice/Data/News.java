package com.tracehub.service.thservice.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    private Integer id;
    private String title;
    private String link;
    private String image;
    private String image2;
    private String image3;
    private String creat_time;
    private String user_id;//用户昵称
    private Integer  like_count;
}
