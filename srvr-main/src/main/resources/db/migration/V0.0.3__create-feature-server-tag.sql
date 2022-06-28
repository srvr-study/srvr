DROP TABLE IF EXISTS feature_server_tag;

CREATE TABLE feature_server_tag
(
    `feature_server_id` BIGINT      NOT NULL,
    `tag_id`            BIGINT      NOT NULL,
    `creator_member_id` BIGINT      NOT NULL,
    `created_at`        DATETIME(6) NOT NULL,
    `is_primary`        BIT(1)      NOT NULL DEFAULT b'0',
    PRIMARY KEY (feature_server_id, tag_id),
    KEY `tag_id_FOREIGN` (`tag_id`),
    CONSTRAINT `tag_id_FOREIGN_CONSTRAINT` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`)
) DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
