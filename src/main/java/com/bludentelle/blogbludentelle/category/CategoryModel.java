package com.bludentelle.blogbludentelle.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CategoryModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",insertable = false)
    @ApiModelProperty(value = "L'id des articles", example="1", required=true)
    int id;

    @NonNull
    @Column(name = "name", nullable = false)
    @ApiModelProperty(value = "nom de la category", example = "mariage", required = true)
    String name;
}
