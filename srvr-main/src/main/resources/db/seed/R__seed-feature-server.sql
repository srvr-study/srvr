INSERT IGNORE INTO feature_server(feature_server_id,
                                  url,
                                  name,
                                  description,
                                  creator_member_id,
                                  last_updater_member_id,
                                  created_at, last_updated_at)
VALUES (1, 'http://localhost:8080', 'MAIN', null, 1, 1, now(), now());
INSERT IGNORE INTO feature_server(feature_server_id,
                                  url,
                                  name,
                                  description,
                                  creator_member_id,
                                  last_updater_member_id,
                                  created_at, last_updated_at)
VALUES (2, 'http://localhost:8081', 'AUTH', null, 1, 1, now(), now());