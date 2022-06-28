DROP TABLE IF EXISTS feature_server;

CREATE TABLE feature_server
(
    `feature_server_id`      BIGINT       NOT NULL,
    `host`                   VARCHAR(500) NOT NULL,
    `name`                   VARCHAR(100) NOT NULL,
    `description`            VARCHAR(500) DEFAULT NULL,
    `creator_member_id`      BIGINT       NOT NULL,
    `last_updater_member_id` BIGINT       NOT NULL,
    `created_at`             DATETIME(6)  NOT NULL,
    `last_updated_at`        DATETIME(6)  NOT NULL,
    PRIMARY KEY (feature_server_id),
    UNIQUE INDEX `host_UNIQUE` (`host` ASC),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC)
) DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
