DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    `username`      VARCHAR(16)  NOT NULL,
    `password`      VARCHAR(64)  NOT NULL,
    `email`         VARCHAR(30)  NOT NULL,
    `created_at`    DATETIME(6)  NOT NULL,
    PRIMARY KEY (username),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC)
) DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
