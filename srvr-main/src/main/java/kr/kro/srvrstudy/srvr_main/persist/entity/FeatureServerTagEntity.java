package kr.kro.srvrstudy.srvr_main.persist.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "feature_server_tag")
@EntityListeners(AuditingEntityListener.class)
public class FeatureServerTagEntity {

    @EmbeddedId
    private FeatureServerTagPk pk;

    @Column(name = "creator_member_id", nullable = false)
    private Long creatorMemberId;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "is_primary", nullable = false)
    @ColumnDefault("false")
    private boolean isPrimary = false;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", nullable = false, insertable = false, updatable = false)
    private TagEntity tag;

}
