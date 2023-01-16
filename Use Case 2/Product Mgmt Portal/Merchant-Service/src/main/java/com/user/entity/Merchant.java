package com.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Document(collection = "merchant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    private String email;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinCollection(name = "USER_ROLE",
//            joinColumns = {
//                    @JoinColumn(name = "USER_ID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "ROLE_ID")
//            }
//    )
//
    @DBRef(lazy= true)
    private Set<Role> role;

}
