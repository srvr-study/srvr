DROP TABLE IF EXISTS tag;

CREATE TABLE tag
(
    `tag_id`     BIGINT       NOT NULL,
    `name`       VARCHAR(100) NOT NULL,
    `created_at` DATETIME(6)  NOT NULL,
    PRIMARY KEY (tag_id),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC)
) DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
