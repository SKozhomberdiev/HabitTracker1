package users.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import service_client.data.User;
import service_client.data.UserRole;
import users.table.UserTable;

import java.io.Serializable;

@Entity
@Table(name = "usr",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Data
@EqualsAndHashCode(of = {"id"})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Email
    @NotNull
    private String email;

    private Boolean emailVerified;

    @JsonIgnore
    private String password;

    private String icon;

    private String locale;

    private int point;

    private String providerId;
    @javax.persistence.Column(name = UserTable.GROUP, nullable = false)
    @javax.persistence.Enumerated(javax.persistence.EnumType.STRING)
    private UserRole group;

    @JsonIgnore
    private String activationCode;

    private Boolean changablePassword;

    public User toDto() {
        return new User(id, username, email,group);
    }

}
