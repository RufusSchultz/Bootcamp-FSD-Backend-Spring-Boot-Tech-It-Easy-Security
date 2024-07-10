INSERT INTO users (username, password, enabled, apikey, email)
VALUES ('henk', '$2a$12$yj0qjIP0jwmN0YQM6jDNDuHW9cp6C4rdmMvBeqL9OiqO9txNJcfhO', true, '7847493', 'test1@testy.tst'),
       ('miep', '$2a$12$Imu7mJTiKC6gb0ptgxxWr.FOCLeW832rDjIGTeuqhhC6Jy3VjTGJ2', true, '7847494', 'test2@testy.tst'),
       ('kees', '$2a$12$bbx.zkq8X1tj/LymYM/vYOoiofGHfEjaWzXzLXR0.LO2zorqKzgie', true, '7847495', 'test3@testy.tst');
INSERT INTO authorities (username, authority)
VALUES ('henk', 'ROLE_ADMIN'),
       ('miep', 'ROLE_USER'),
       ('kees', 'ROLE_USER');