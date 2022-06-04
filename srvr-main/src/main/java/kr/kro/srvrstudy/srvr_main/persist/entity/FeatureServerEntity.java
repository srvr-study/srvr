package kr.kro.srvrstudy.srvr_main.persist.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "feature_server")
public class FeatureServerEntity implements Auditing {

    @Id
    @Column(name = "feature_server_id", nullable = false)
    private Long featureServerId;

    @Column(name = "host", nullable = false, unique = true, length = 500)
    private String host;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "creator_member_id", nullable = false)
    private Long creatorMemberId;

    @Column(name = "last_updater_member_id", nullable = false)
    private Long lastUpdaterMemberId;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "last_updated_at", nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "pk.featureServerId")
    @PrimaryKeyJoinColumn
    private List<FeatureServerTagEntity> featureServerTags = new ArrayList<>();

}