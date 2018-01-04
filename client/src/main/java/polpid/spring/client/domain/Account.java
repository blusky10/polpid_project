package polpid.spring.client.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;
import polpid.spring.client.auditing.AuditableDomain;
import polpid.spring.client.enums.EnableStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Audited
@AuditOverride(forClass = AbstractAuditable.class)
public class Account extends AuditableDomain {

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EnableStatus enable;

    @OneToMany
    private List<Role> roles;

    public Account(String loginId, String username, String password, String email, EnableStatus enable) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }
}
