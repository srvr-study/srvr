DROP TABLE IF EXISTS session;

CREATE TABLE session
(
    `session_key` VARCHAR(36) NOT NULL,
    `username`    VARCHAR(16) NOT NULL,
    `created_at`  DATETIME(6) NOT NULL,
    PRIMARY KEY (session_key),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC)
) DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
