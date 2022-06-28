package kr.kro.srvrstudy.srvr_main.persist.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
@EqualsAndHashCode
public class FeatureServerTagPk implements Serializable {

    private static final long serialVersionUID = -8791105315047221193L;

    @Column(name = "feature_server_id", nullable = false)
    private Long featureServerId;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;

}
