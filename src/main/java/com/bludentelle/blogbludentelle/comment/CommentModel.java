package com.bludentelle.blogbludentelle.comment;

import com.bludentelle.blogbludentelle.article.ArticleModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommentModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",insertable = false)
    @ApiModelProperty(value = "L'id des commentaire", example="1", required=true)
    int id;

    @NonNull
    @Column(name = "author", nullable = false)
    @ApiModelProperty(value = "nom de l'auteur d'un commentaire", example = "Pierre", required = true)
    String author;

    @NonNull
    @Column(name = "content", nullable = false)
    @ApiModelProperty(value = "le commentaire", example = "ceci est mon commentaire", required = true)
    String content;

    @NonNull
    @Column(name="email", nullable = false)
    @ApiModelProperty(value = "email de l'auteur du commentaire", example = "lambertaurelie17@gmail.com", required = true)
    String email;

    @NonNull
    @Column(name="created_at", nullable = false, length = 50)
    @ApiModelProperty(value = "date d'un commentaire", example="2019-05-12", required=true)
    Date createdDatetime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    ArticleModel article;
}
