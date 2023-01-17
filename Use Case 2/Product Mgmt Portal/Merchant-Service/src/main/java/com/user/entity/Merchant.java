package com.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
    @Id
    private int id;
    
    private String email;
    private String userFirstName;
    private String userLastName;
    private String userPassword;

    @DBRef(lazy= true)
    private Set<Role> role;

}
