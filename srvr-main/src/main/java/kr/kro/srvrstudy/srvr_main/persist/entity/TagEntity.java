package kr.kro.srvrstudy.srvr_main.persist.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tag")
@EntityListeners(AuditingEntityListener.class)
public class TagEntity {

    @Id
    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

}