package com.bludentelle.blogbludentelle.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",insertable = false)
    @ApiModelProperty(value = "L'id des user", example="1", required=true)
    int id;

    @NonNull
    @Column(name="firstname", nullable = false, length = 50)
    @ApiModelProperty(value = "prenom d'un utilisateur", example="Aurelie", required=true)
    String firstname;

    @NonNull
    @Column(name="lastname", nullable = false, length = 50)
    @ApiModelProperty(value = "nom d'un utilisateur", example="Lambert", required=true)
    String lastname;

    @NonNull
    @Column(name="email", nullable = false)
    @ApiModelProperty(value = "email de l'utilisateur", example = "lambertaurelie17@gmail.com", required = true)
    String email;
}
