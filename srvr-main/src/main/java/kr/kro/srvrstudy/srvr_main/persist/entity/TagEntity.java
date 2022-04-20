package kr.kro.srvrstudy.srvr_main.persist.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class TagEntity implements Auditing {

    @Id
    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

}
