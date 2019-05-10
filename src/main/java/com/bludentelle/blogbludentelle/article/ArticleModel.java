package com.bludentelle.blogbludentelle.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="article")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ArticleModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",insertable = false)
    @ApiModelProperty(value = "L'id des articles", example="1", required=true)
    int id;

    @NonNull
    @Column(name="title", nullable = false, length = 50)
    @ApiModelProperty(value = "titre d'un article", example="Mon mariage", required=true)
    String title;

    @NonNull
    @Column(name="created_date", nullable = false, length = 50)
    @ApiModelProperty(value = "titre d'un article", example="Mon mariage", required=true)
    Date createdDatetime;

    @NonNull
    @Column(name="modified_date", nullable = false, length = 50)
    @ApiModelProperty(value = "titre d'un article", example="Mon mariage", required=true)
    Date modifiedDatetime;

    @NonNull
    @Column(name="description", nullable = false)
    @ApiModelProperty(value = "description d'un article", example="Mon mariage", required=true)
    String description;



}
